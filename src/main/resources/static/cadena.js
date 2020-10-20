function adicionarFila(item) {
    var markup = "<tr class=\"filasP\"><td>" + item.nombres + "</td><td>" + item.documento + "</td><td>" + item.cargo + "</td></tr>";
    $("#tablaPersonas").append(markup);
}

function inicializarElementos() {
    $(".filasP").remove("tr");
}

function adicionarFilaFactura(item) {
    var markup = "<tr class=\"filasF\"><td>" + item.numero + "</td><td>" + item.concepto + "</td><td>" + item.importe + "</td></tr>";
    $("#tablaCadenas").append(markup);
}

function inicializarElementosFacturas() {
    $(".filasF").remove("tr");
}

var cadena = (function () {
    return {
    	cargar(){
    		var promesa = apiclientCadena.getFacturas(); 
    		promesa.done(function(data){
    			inicializarElementosFacturas();
    			data.map(adicionarFilaFactura);
    		})
            .fail(function(){ 
            	alert(promesa.responseText);
            });
    		
    		var promesa = apiclientCadena.getPersonas(); 
    		promesa.done(function(data){
    			inicializarElementos();
    			data.map(adicionarFila);
    		})
            .fail(function(){ 
            	alert(promesa.responseText);
            });
    	}
    };
}());