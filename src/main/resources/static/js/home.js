/**
 * This contains the JavaScript functions used in home.html
 */

$(document).ready(function (){
	var date = new Date();
	var dateFinal = date.toLocaleDateString();
	document.getElementById("postDate").value = dateFinal;
	
	$('#post_btn').click(function(){
		var timeFinal = date.toLocaleTimeString();
		$('#postTime').val(timeFinal);
	});
});