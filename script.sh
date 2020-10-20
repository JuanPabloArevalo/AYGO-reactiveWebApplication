#!/bin/bash
	aws ec2 create-key-pair --key-name keyFlux --query 'KeyMaterial' --output text > keyFlux.pem
	chmod 400 keyFlux.pem 
	aws ec2 create-security-group --group-name my-sg-cli-flux --description "SecurityGroupFlux" --vpc-id vpc-2c361a56
	aws ec2 authorize-security-group-ingress --group-name my-sg-cli-flux --protocol tcp --port 8080 --cidr 0.0.0.0/0
	aws ec2 authorize-security-group-ingress --group-name my-sg-cli-flux --protocol tcp --port 22 --cidr 0.0.0.0/0
	aws ec2 run-instances --image-id ami-032930428bf1abbff --count 3 --instance-type t2.micro --key-name keyFlux --security-groups my-sg-cli-flux
	sleep 90
	aws ec2 describe-instances --filters "Name=instance.group-name,Values=my-sg-cli-flux" --query "Reservations[].Instances[]" > instancias.json
	for (( c=0; c<3; c++ ))
	do  
		dns=$(./jq-win64.exe -r '.['$c'].PublicDnsName' instancias.json)
		ssh -o StrictHostKeyChecking=no -i "keyFlux.pem" ec2-user@$dns "sudo yum update -y"
		ssh -i "keyFlux.pem" ec2-user@$dns "sudo yum install -y docker"
		ssh -i "keyFlux.pem" ec2-user@$dns "sudo usermod -a -G docker ec2-user"
		ssh -i "keyFlux.pem" ec2-user@$dns "sudo service docker start"
		ssh -i "keyFlux.pem" ec2-user@$dns "docker run -d -p 8080:8080 --name reactiveWeb juanarevalomerchan/aygo_reactive_web_services"
	done