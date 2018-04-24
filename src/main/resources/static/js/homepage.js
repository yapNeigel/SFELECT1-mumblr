/*
 * This contains the JavaScript functions used in index.html
 */

$(document).ready(function ()
	{
	
		console.log('hey');
		var currentYear = (new Date()).getFullYear();
		var minimumYear = currentYear - 70;
		for(i = currentYear; i >= minimumYear; i--)
		{
			$("#b_year").get(0).options[$("#b_year").get(0).options.length] = new Option(i, i);
		}
		
		var modal = document.getElementById('myModal');

		//Get the button that opens the modal
		var btn = document.getElementById("myBtn");

		//Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];

		//When the user clicks the button, open the modal 
		btn.onclick = function()
		{
		 modal.style.display = "block";
		}

		//When the user clicks on <span> (x), close the modal
		span.onclick = function()
		{
		 modal.style.display = "none";
		}

		//When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event)
		{
		 if (event.target == modal)
		 {
		     modal.style.display = "none";
		 }
		}
	}
);