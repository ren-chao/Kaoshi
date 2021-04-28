layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;

/*  var userid = $("#uid").val();
  alert(userid);*/
/*  $.ajax({
	  url:"/MenuTest/RoleServlet?action=allRole",
	  type:"post",
	  success:function(data){
		  var info = eval("("+data+")");
		  var row = info.data;
		  var role = $("#role1");
		  $.ajax({
			  url:"/MenuTest/UserServlet?action=",	//查询用户是否有角色有返回1,没有返回0
		  })
		  var html = '<option value="0">无角色</option>';
		  $.each(row,function(index,item){
			  html += '<option value="'+item.id+'">'+item.rname+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })*/
  
/*  //自定义验证规则
  var isyan = form.verify({
	uname: function(value){
      if(value.length < 3){
        return '登录名不能小于3位数';
      }
      if(!/[^\u4e00-\u9fa5]/.test(value)){
    	  return "登录名不能为中文";
      }
    },
    password: [
      /^[\S]{6,12}$/
      ,'密码必须6到12位，且不能出现空格'
    ],
    content: function(value){
      layedit.sync(editIndex);
    }
  });*/
  $.ajax({
	  url:"http://localhost:8080/ABC/sta?action=seleRole",
	  type:"post",
	  async: false,
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
	  async: false,
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
	  async: false,
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
	  /*var is = false;
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
	  return is;*/
  }
  
  $("#uname").blur(function(){
	  var name = $("#uname").val();
	  var name2 = $("#uname2").val();
	  if(name !=null && name!=name2 ){
		  var check = checkUname(name);
		  if(check == false){
			  layer.alert("登录账号已存在! 请重新输入");
		  }
	  }
  })
  
  
  $("#xiugai").click(function(){
	  var name = $("#logname").val();
	  var count = $("#count").val();//hi
	  var id=$("#hi").val();
	
	  var data = {
			  "loginname":name,
			  "coutn":count,
			  "id":id
	  }
	  if(name.length<3){
		  layer.alert("登录名不能小于3位数")
		  return false;
	  }
	  $.ajax({
	  		url:"http://localhost:8080/ABC/bu?action=UpdatSe",
			data:data,
			tyep:"post",
			success:function(data){
				if(data == 1){
					layer.msg("用户信息修改成功");
					setTimeout(function(){
						parent.layer.closeAll("iframe");
			            //刷新父页面
						parent.layui.table.reload('test');
		        	},1000);
				}else{
					layer.msg("系统异常");
				}
			}
	  })
	  return false;
  })
  
});
/*jQuery(function($){ 
	  $.ajax({
		  url:"/MenuTest/RoleServlet?action=allRole",
		  type:"post",
		  success:function(data){
			  var info = eval("("+data+")");
			  var role = $("#role");
			  var html = '';
			  $.each(info.data,function(index,datas){
				  html += '<option value="'+datas.id+'">'+datas.rname+'</option>';
			  })
			  role.html(html);
		  }
		  
	})
}); */