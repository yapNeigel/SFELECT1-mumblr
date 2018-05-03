/**
 * This contains the JavaScript functions used in home.html
 */

$(document).ready(function (){
	
//	ClassicEditor.create( document.querySelector( '#content' ) ).catch( error => {
//        console.error( error );
//    } );
	
	$(function() { $('#content').froalaEditor() });
	
	/*CKEDITOR.replace( 'content',{
	    filebrowserUploadUrl: 'https://api.imgur.com/3/upload'	
	});*/
	
	$('#post_btn').click(function(){
		var now = new Date();
		var utcDate1 = new Date(Date.UTC(now.getUTCFullYear(),now.getUTCMonth(), now.getUTCDate(), now.getUTCHours(), now.getUTCMinutes(), now.getUTCSeconds(),now.getUTCMilliseconds()));
		var utcfinal = utcDate1.toUTCString();
		$('#postDate').val(utcfinal);
	});
	
	$('.formatUTC').each(function(i) {
		var date = new Date(this.innerHTML);
		this.innerHTML = formatDate(date);
	});
	
	function formatDate(date) {
		var hours = date.getHours();
		var minutes = date.getMinutes();
		var ampm = hours >= 12 ? 'pm' : 'am';
		
		hours = hours % 12;
		hours = hours ? hours : 12;
		minutes = minutes < 10 ? '0'+minutes : minutes;
		
		var strTime = hours + ':' + minutes + ' ' + ampm;
		var strMonths = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']
		
		return strMonths[date.getMonth()] + " " + date.getDate() + ", " + date.getFullYear() + " at " + strTime;
	}
});