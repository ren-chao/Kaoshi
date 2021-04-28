layui.extend({///LayuiExercise/WebRoot/common/layui/lay-module/layui_ext/dtree/dtree.css
    dtree: '{/}common/layui/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','laytpl','dtree'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;
    	var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;
/*
layui.use('table', function(){*/
  var table = layui.table;
  alert(2);
  var tableIns = table.render({
    elem: '#test'
    ,url:'http://localhost:8080/ABC/qu?action=seleQuan'
     ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板 
    ,title: '用户数据表'
    ,cols: [[
     {fixed:"left",type: "checkbox", width:50},
            {field: 'id', title: '编号',  align:'center'},
            {field: 'name', title: '登录名', minWidth:100, align:"center"},
         
    ]]
    ,page: true
  });
  
  //头工具栏事件
  table.on('toolbar(test)', function(obj){
    alert("table.on");
    var checkStatus = table.checkStatus(obj.config.id);
    var data = checkStatus.data;
    var userid = "";
    for(i=0;i<data.length;i++){
    	userid = data[i].id;
    }
    switch(obj.event){
      case 'addUser'://新增用户
    	  
    	  addUser();
      break;
      case 'deleUser'://删除用户
    	  if(data.length == 0 || data.length > 1){
				layer.msg("请选择一行数据进行操作")
				return ;
			}else{
				layer.confirm('确定删除用户吗', {icon: 3, title:'提示'}, function(index){
					var loginName = $("#loginName").val();
					if(userid == loginName){
						layer.msg("你正在登录当前账号,无法删除")
					}else{
						deleUser(userid);
						layer.close(index);
					}
	            });
			}
      break;
      case 'updataMenu'://修改用户
    	  	if(data.length == 0 || data.length > 1){
				layer.msg("请选择一行数据进行操作")
				return ;
			}else{
				upUser(userid);
			}
      break;
      
      //自定义头工具栏右侧图标 - 提示
      case 'LAYTABLE_TIPS':
        layer.alert('这是工具栏右侧自定义的一个图标按钮');
      break;
    };
  });
  
  //监听行工具事件
  table.on('tool(test)', function(obj){
    var data = obj.data;
    //console.log(obj)
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      layer.prompt({
        formType: 2
        ,value: data.email
      }, function(value, index){
        obj.update({
          email: value
        });
        layer.close(index);
      });
    }
  });
  
  function upUser(userid){//修改用户   /LayuiExercise/WebRoot/common/pop/userInfo.jsp
	  layui.layer.open({
  		title : "修改权限",
  		type : 2,
  		content : "par/menuInfo.jsp",
  		area:['400px','540px'],
  		success:function(layero, index){
  			$.ajax({
  				url:"http://localhost:8080/ABC/qu?action=seleByid",
  				type:"post",
  				data:{"userid":userid},
  				success:function(data){
  					alert(data)
  					var info = eval('(' + data + ')')
      				var body = layui.layer.getChildFrame('body', index);
      				body.find("#mid").val(info[0].id);
      				body.find("#mname").val(info[0].name);  //权限名
      				body.find("#mfunction").val(info[0].path);	//请求路径
					var select = 'dd[lay-value='+info[0].type+']';
					body.find("#type2").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
					body.find("#mbtn").val(info[0].mbth);		//按钮代码
  				/*body.find("#icon").val(info.data.icon);		//icon图标
*/              				var menuid3 = info[0].fid;

  				//上级的下拉框
     			 $.post("http://localhost:8080/ABC/qu?action=seleByfid",{"menuid":menuid3},function(res){
 					var cs = eval('(' + res + ')');
 					if(cs!=null ){
 						  body.find("#fatherType2").val(cs[0].name);
 					}
  				})
					
               
 			 }
  				})
  			}
  		})
  }
  
  function deleUser(userid){//删除用户
  	$.ajax({
  		url:"http://localhost:8080/ABC/qu?action=delquan",
  		data:{"userid":userid},
  		type:"post",
  		success:function(data){
  			if(data == "1"){
  				layer.msg("删除成功")
  				tableIns.reload("#test");
  			}
  		}
  	})
  }
  
  function addUser() {//新增用户
	  layui.layer.open({
  		title : "新增用户",
  		type : 2,
  		content : "par/prowerAdd.jsp",
  		area:['400px','550px'],
  	  })
  }
});
