alert(666)
layui.use(['form','layer','laydate','table','laytpl','dtree'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        form = layui.form,
        table = layui.table;
    	var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;
    	courseTask: 'task/courseTask'

    	
    	  
    /*------------- 加载用户数据 --------------------------------*/
    var tableIns = table.render({
    	 elem: '#test',
         url:'http://localhost:8080/ABC/sta?action=seleStaff',
        toolbar: '#toolbarDemo',
        page : true,
        method:"post",
        height: 'full-145',
        limit : 10,
        limits : [5,10,15,20,25],
        cols : [[//name    sectionname  rankname  rolename         
        	{fixed:"left",type: "checkbox", width:30},
            {field: 'id', title: '编号',  align:'center'},
            {field: 'sectionname', title: '姓名',  align:'center'},
            {field: 'rankname', title: '用户名',  align:'center'},
            {field: 'rolename', title: '密码',  align:'center'}
          
        ]] ,parseData: function(res){ //将原始数据解析成 table 组件所规定的数据
            return {
                "code": res.code, //解析接口状态
                "msg": res.msg, //解析提示文本
                "count": res.count, //解析数据长度
                "data": res.data //解析数据列表
                
              };
            }, request: {
                pageName: 'page' // 页码的参数名称，默认：page
                , limitName: 'size' //每页数据量的参数名，默认：limit
            },
    });
    /*------------- 加载用户数据 --end------------------------------*/

    /*-------- 搜索用户 ----------------------------*/
    $("#doSubmit2").click(function(){
    	var like = $("#doSubmit").val()
    	$("#doSubmit1")[0].click();
    	 tableIns.reload({
	      url:"/layui/l?action=userList",
	      page: {
	        curr: 1 //重新从第 1 页开始
	      }
    	
	    });
    })
    
     //工具栏事件lay-filtre="updatquan"
	  table.on('toolbar(newsList)', function(obj){
	    var checkStatus = table.checkStatus(obj.config.id);
	    var data = checkStatus.data;
	    var userid = '';
	    for(i=0;i<data.length;i++){
	    	userid = data[i].id;
	    }
	    switch(obj.event){
	      case 'fenFunc':	//分配权限
				if(data.length == 0 || data.length > 1){
					layer.msg("请选择一行数据进行操作")
					return ;
				}else{
					hairMenu(userid);
				}
	      break;
	      
	      case 'addMenu':	//新增用户
	    	  addUser()
	    	  
	      break;
	      
	      case 'hairMenu':	//分配角色
	    	  if(data.length == 0 || data.length > 1){
					layer.msg("请选择一行数据进行操作")
					return ;
				}else{
					HairRole(userid);
				}
	      break;
	      
	      case 'updataMenu':	//修改用户信息
	    	  if(data.length == 0 || data.length > 1){
					layer.msg("请选择一行数据进行操作")
					return ;
				}else{
					upUser(userid);
				}
	      break;
		        
	      case 'delMenu':	//删除用户
	    	  if(data.length == 0 || data.length > 1){
					layer.msg("请选择一行数据进行操作")
					return ;
				}else{
					layer.confirm('确定删除用户吗', {icon: 3, title:'提示'}, function(index){
						alert(index)
						var loginName = $("#loginName").val();
						/*if(userid == loginName){
							layer.msg("你正在登录当前账号,无法删除")
						}else{*/
							deleteuser(userid);
							layer.close(index);
						/*}*/
		            });
				}
	      break;
	    };
	  });
    
    //修改用户
    function upUser(userid){
    	layui.layer.open({
    		title : "修改用户信息",
    		type : 2,
    		content : "par/userInfo.jsp",
    		area:['400px','540px'],
    		success:function(layero, index){//seleuser
    			$.ajax({
    				url:"http://localhost:8080/ABC/sta?action=seleuser",
    				type:"post",
    				async: false,
    				data:{"userid":userid},
    				success:function(data){
    					
    					var info = eval('(' + data + ')');
          				var body = layui.layer.getChildFrame('body', index);
    					body.find("#uname").val(info[0].name);//hi
    					body.find("#hi").val(info[0].id);//hi
    					/*  ------下拉框赋值-------*/-
    					setTimeout(function() {
    						$.ajax({
        						url:"http://localhost:8080/ABC/sta?action=seleuser",
        						type:"post",
        						async: false,
        						data:{"userid":userid},
        						success:function(data){
        							//[{"id":3,"name":"520","rankid":1,"roleid":1,"sectionid":1}]
        							var info2 = eval("("+data+")")
        							var select = 'dd[lay-value="'+ info2[0].rankid +'"]';
        							var select1 = 'dd[lay-value="'+ info2[0].roleid +'"]';
        							var select2 = 'dd[lay-value="'+ info2[0].sectionid +'"]';
        							body.find("#role1").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
        							body.find("#role2").siblings("div.layui-form-select").find('dl').find(select1).click();	//菜单样式
        							body.find("#role3").siblings("div.layui-form-select").find('dl').find(select2).click();	//菜单样式
        						}
        					})
    					}, 100)
    					
    				}
    			})
    		}
    	})
    }
    
    //删除用户
    function deleteuser(userid){
    	$.ajax({
    		url:"http://localhost:8080/ABC/sta?action=deleUser",
    		data:{"userid":userid},
    		type:"post",
    		success:function(data){
    			if(data == 1){
    				layer.msg("删除成功")
    				tableIns.reload("#newsList");
    			}
    		}
    	})
    }
    
    
    //分配权限
    function hairMenu(userid){
    	layui.layer.open({
    		title : "分配权限",
    		type : 1,
    		content : $('#dtree1'),
    		area:['300px','500px'],
    		success:function(){
    		    //给dtree树加载数据
    			dtree.render({
				  elem: "#dataTree3",
				  url: "/layui/qu?action=selePrower",
				  dataStyle: "layuiStyle",  //使用layui风格的数据格式
				  dataFormat: "list",  //配置data的风格为list
				  response:{message:"msg",statusCode:0},  //修改response中返回数据的定义
				  checkbar:true,
				  line: true,  // 显示树线
				  done: function(res, $ul, first){
					  $.ajax({
						  url:"/layui/qu?action=seleProweByID",
						  type:"post",
						  data:{"userid":userid},
						  success:function(res){
							  var cs = eval('(' + res + ')');
							  $.each(cs,function(index,row){
								dtree.chooseDataInit("dataTree3",[row.id]); // 初始化选中
							  })
						  }
					  })
  		    	  }
    			});
    		},
    		btn:['分配权限'],
    		yes: function(index, layero){
    			var params = dtree.getCheckbarNodesParam("dataTree3");
    			var infos = JSON.stringify(params);
    			var cs = eval('(' + infos + ')');
    			var menuidList = new Array();	//所有选中值的权限id
    			//alert(menuidList.length);
    			$.each(cs,function(index,row){
					menuidList[index] = row.nodeId;
    			})
    			alert(menuidList)
    			$.ajax({
    				url:"/layui/qu?action=menuByUserid",
    				data:{"array":menuidList,"userid":userid},
    				type:"post",
    				traditional:true,
    				success:function(data){
    					var demo = eval('(' + data + ')');
    					alert(demo)
    					if(demo > 0){
    						layer.msg("分配成功");
    						layer.close(index)	//关闭
    					}else{
    						layer.msg("分配失败");
    					}
    				}
    			})
    		}
    	})
    }

    //分配角色
    /*function HairRole(userid){
    	layer.open({
    		type:1,
    		title:"分配角色",
    		area:['200px','100px'],
    		content:$('#hairRole'),
    		success:function(){
    			//查询全部角色
    	    	$.ajax({
    	    		url:"/MenuTest/RoleServlet?action=selePrower",
    	    		type:"post",
    	    		dataType:"json",
    	    		success:function(data){
    	    			
    	    		}
    	    	})
    		}
    	})
    }*/
    
    //新增用户
    function addUser(){
    	layui.layer.open({
    		title : "添加用户",
    		type : 2,
    		content : "par/userAdd.jsp",
    		area:['400px','490px']
    		
    	})
    }
    
     

})