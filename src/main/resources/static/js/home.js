/**
 * This contains the JavaScript functions used in home.html
 */

function updCon(data,content){
	$(function() { $('.updContent').froalaEditor({
		theme: 'custom'
	}) });
	document.getElementById("initContent"+data).style.display = "none";
	document.getElementById("card-btns"+data).style.display = "none";
	document.getElementById("editContent"+data).style.display = "block";
}

function canUpd(data){
	document.getElementById("editContent"+data).style.display = "none";
	document.getElementById("initContent"+data).style.display = "block";
	document.getElementById("card-btns"+data).style.display = "block";
}

function editComment(data,content){
	
	if(document.getElementById("editCommentSection"+data).style.display == "block"){
		$("#editCommentSection"+data).css("display", "none");
	} else {
		$("#editCommentSection"+data).css("display", "block");
	}
}

function delComment(data){
	$('#delCommentId').val(data);
	$("#delCommentConfModal").fadeIn();
}

function delPost(data){
	$('#delPostID').val(data);
	$("#delConfModal").fadeIn();
}

function comment(data){
	
	if(document.getElementById("commentArea"+data).style.display == "block"){
		$("#commentArea"+data).css("display", "none");
	} else {
		$("#commentArea"+data).css("display", "block");
	}

}

function commentDateSetter(data){
	
	var now = new Date();
	var utcDate1 = new Date(Date.UTC(now.getUTCFullYear(),now.getUTCMonth(), now.getUTCDate(), now.getUTCHours(), now.getUTCMinutes(), now.getUTCSeconds(),now.getUTCMilliseconds()));
	var utcfinal = utcDate1.toUTCString();
	console.log('test');
	$('#commentDate'+data).val(utcfinal);

}



function clsMod(){
	$("#delConfModal").fadeOut();
}

function clsCommentMod(){
	$("#delCommentConfModal").fadeOut();
}
$(document).ready(function (){
	$(function() { $('#content').froalaEditor({
		theme: 'custom'
	}) });
	
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
	
	$('.commentContent').each(function() {
		$(".commentContent").froalaEditor({
			theme: 'custom'
		});
	});
	
	$('.editCommentContent').each(function() {
		$(".editCommentContent").froalaEditor({
			theme: 'custom'
		});
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