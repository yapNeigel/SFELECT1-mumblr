/**
 * This contains the JavaScript functions used in index.html
 */

$(document).ready(function () {
	console.log('hey');
    var currentYear = (new Date()).getFullYear();
    var minimumYear = currentYear - 70;
    for(i = minimumYear; i <= currentYear; i++){        
    	$("#b_year").get(0).options[$("#b_year").get(0).options.length] = new Option(i, i);
    }
});