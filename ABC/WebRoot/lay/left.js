function clickLeft(url,id,zhi){
/*	var  ur=url+"&maid="+id;
	var item={
		id:id,
		xiuid:xiuid
	}*/
	alert(url)
/*	$("#di").load("/"+url,function(){
		$.getScript("lay/userlist.js");
	});
*/
	
}
function cl(url,id,zhi,ss){
	alert(ss)
	$("#di").load("/"+url,function(){
		$.getScript("lay/"+ss);
	});
}
layui.use('element', function(){
	var element = layui.element;

});
