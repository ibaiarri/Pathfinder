$(document).ready(()=> {	
		$.ajax({
			url:'http://localhost:8080/pathfinder/personaje',
			type: 'GET',
			dataType: 'json',
			success: function(res){
				let data='';
				res.forEach(element => {
					data+=`
						<tr>
							<td>${element.id_personaje}</td>
							<td>${element.clase}</td>
							<td>${element.nivel}</td>
							<td>${element.curso}</td>
							<td>${element.nota}</td>
						</tr>
					`
				});
				$('#tbody').html(data);
			}
		})
	
});