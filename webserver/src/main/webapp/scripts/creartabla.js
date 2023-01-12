
function tablaseleccionable(){
     var table = $('#tabla').DataTable();
 
    $('#example tbody').on('click', 'tr', function () {
        $(this).toggleClass('selected');
    });
 
    $('#button').click(function () {
        alert(table.rows('.selected').data().length + ' row(s) selected');
    });
}