/*
 * This contains the JavaScript functions used in index.html
 */

$(document).ready(function ()
	{
	
		//Back-End Validation CSS Changer JS
		var errorMsg = document.getElementById("errorMsg").innerHTML;
		if(errorMsg.match("First Name")){
			$('#fname').addClass('errorMessage');
		}
		if(errorMsg.match("Last Name")){
			$('#lname').addClass('errorMessage');
		}
		if(errorMsg.match("Email") || errorMsg.match("Email (Exists)")){
			$('#email').addClass('errorMessage');
		}
		if(errorMsg.match("Password")){
			$('#pass').addClass('errorMessage');
			$('#pass_c').addClass('errorMessage');
		}
		
		$('#fname').keypress(function(){
			$('#fname').removeClass('errorMessage');
		});
		$('#lname').keypress(function(){
			$('#lname').removeClass('errorMessage');
		});
		$('#email').keypress(function(){
			$('#email').removeClass('errorMessage');
		});
		$('#pass').keypress(function(){
			$('#pass').removeClass('errorMessage');
		});
		$('#pass_c').keypress(function(){
			$('#pass_c').removeClass('errorMessage');
		});
		//Back-End Validation CSS Changer JS
		
		//Birth Year JS
		var currentYear = (new Date()).getFullYear();
		var minimumYear = currentYear - 70;
		for(i = currentYear; i >= minimumYear; i--)
		{
			$("#b_year").get(0).options[$("#b_year").get(0).options.length] = new Option(i, i);
		}
		//Birth Year JS
		
		//Modal JS
		var modal = document.getElementById('myModal');
		var btn = document.getElementById("myBtn");
		var span = document.getElementsByClassName("close")[0];
		btn.onclick = function()
		{
		 modal.style.display = "block";
		}
		span.onclick = function()
		{
		 modal.style.display = "none";
		}
		window.onclick = function(event)
		{
		 if (event.target == modal)
		 {
		     modal.style.display = "none";
		 }
		}
		//Modal JS
	}
);