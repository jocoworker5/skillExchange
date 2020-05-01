// Call the dataTables jQuery plugin
$(document).ready(function() {
	$('#dataTable').DataTable();
	$("#grade").click(function() {
		$('#dataTable1').DataTable({
			"lengthChange": true,
			"pageLength" : 5
		});
	})

});
