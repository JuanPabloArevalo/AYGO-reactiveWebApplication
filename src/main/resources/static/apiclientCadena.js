var apiclientCadena = (function(){
    var equipoBackEnd = "http://localhost:8080"
    return{
    	getFacturas(){
            return $.ajax({
                url:  equipoBackEnd+"/facturas",
                type: "GET",  
            });
        },
        getPersonas(){
            return $.ajax({
                url:  equipoBackEnd+"/personas",
                type: "GET",
            });
        }
    }
}());
