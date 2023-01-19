$(document).ready(()=> {	
	
	    console.info("llamada lis1");
		$.ajax({
			type: 'GET',
			url: 'http://localhost:8081/api/lis1',
			dataType: 'json',
			success: function(res){
				console.info("llamada success");
				let data='';
				res.forEach(element => {
					data+=`
						<tr>
							<td>${element.id_personaje}</td>
							<td>${element.nombre}</td>
							<td>${element.clase}</td>
							<td>${element.nivel}</td>
						</tr>
					`;
					console.debug("dato columna " + element);
				});
				console.info("rellenar tabla");
				$('#tbody').html(data);
			}
		});
	
});