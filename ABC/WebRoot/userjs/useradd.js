layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;

  $.ajax({
	  url:"http://localhost:8080/ABC/sta?action=seleRole",
	  type:"post",
	  success:function(data){
		  var info = eval("("+data+")");
		  var row = info.data;
		  var role = $("#role1");
		  var html = '';
		  html += '<option value="0">请选择</option>';
		  $.each(info,function(index,item){
			  html += '<option value="'+item.id+'">'+item.name+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })
    $.ajax({
	  url:"http://localhost:8080/ABC/sta?action=seleRank",
	  type:"post",
	  success:function(data){
		  var info = eval("("+data+")");
		  var row = info.data;
		  var role = $("#role2");
		  var html = '';
		  html += '<option value="0">请选择</option>';
		  $.each(info,function(index,item){
			  html += '<option value="'+item.id+'">'+item.name+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })
    $.ajax({
	  url:"http://localhost:8080/ABC/sta?action=seleSection",
	  type:"post",
	  success:function(data){
		  var info = eval("("+data+")");
		  var row = info.data;
		  var role = $("#role3");
		  var html = '';
		  html += '<option value="0">请选择</option>';
		  $.each(info,function(index,item){
			  html += '<option value="'+item.id+'">'+item.name+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })
  
  function checkUname(uname){
	  var is = false;
	  $.ajax({
		  url:"/MenuTest/UserServlet?action=isUname",
		  data:{"uname":uname},
		  async:false,
		  type:"post",
		  success:function(data){
			  if(data == 0){
				  is = true;
			  }else{
				  is = false;
			  }
			  
		  }
	  })
	  return is;
  }
  
  $("#uname").blur(function(){
	 /* var name = $("#uname").val();
	  if(!name.length == "" || !name.length == null){
		  var check = checkUname(name);
		  if(check == false){
			  layer.alert("登录账号已存在! 请重新输入")
		  }
	  }*/
  })
  
  
  $("#tijiao").click(function(){
	  var name = $("#uname").val();
	  var pass = $("#password").val();
	  var realName = $("#realName").val();
	  var sex = $("input[type='radio']:checked").val();
	  var email = $("#email").val();
	  var phone = $("#phone").val();
	  var role1 = $("select[name='role1']").val();
	  var role2 = $("select[name='role2']").val();
	  var role3 = $("select[name='role3']").val();
	  alert(role2)
	  var data = {
			  "loginname":name,
			  "type1":role1,
			  "type2":role2,
			  "type3":role3
	  }
	  if(name.length<3){
		  layer.alert("登录名不能小于3位数")
		  return false;
	  }
	  $.ajax({
	  		url:"http://localhost:8080/ABC/sta?action=useradd",
			data:data,
			tyep:"post",
			success:function(data){
				if(data == 1){
					layer.msg("添加成功")
					setTimeout(function(){

						parent.layer.closeAll("iframe");
						parent.layui.table.reload('test');
					
		        	},1000);
					
					return data;
				}else{
					layer.msg("系统异常");
				}
				
			}
	  })
	  return false;
  })
  
});
