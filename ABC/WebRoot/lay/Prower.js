layui.use(['layer','table', 'treeTable'], function () {
        var $ = layui.jquery;
        var table = layui.table;
        var treeTable = layui.treeTable;
        var layer = layui.layer;
        // 渲染表格
		var insTb = treeTable.render({
            elem: '#demoTreeTb',
            url: '/layui/l?action=adminList',
            toolbar: '#menutoolbarDemo',
            height: 'full-115',
            spread:true,
            tree: {
                iconIndex: 2,           // 折叠图标显示在第几列
                isPidData: true,        // 是否是id、pid形式数据
                idName: 'id',  // id字段名称
                pidName: 'fatherid'  ,      // pid字段名称
                treeDefaultClose:true,
                treeLinkage:true
            },
            cols: [[
            	{fixed:"left",type: "radio", width:30},
                {field: 'id', title: '编号',  align:'center'},
                {field: 'name', title: '姓名',  align:'center'},
                {field: 'fatherid', title: '父类id',  align:'center'},
                {field: 'type', title: '类型',  align:'center'}
            ]]
        });
		
		//监听工具栏
		treeTable.on('toolbar(demoTreeTb)', function(obj){
		    switch(obj.event){
		      case 'btn-expand':	//全部展开
		    	  insTb.expandAll('#demoTreeTb');
		      break;
		      
		      case 'btn-fold':	//全部折叠
		    	  insTb.foldAll('#demoTreeTb');
		      break;
		      
		      case 'addMenu':	//新增权限
		    	  layer.open({
		        		title : "添加权限",
		        		type : 2,
		        		content : "par/prowerAdd.jsp",
		        		area:['800px','700px'],
		    	  })
		      break;
		      
		      case 'updataMenu':	//修改权限
					updataMenu();
		      break;
			        
		      case 'delMenu':	//删除权限
		    	  layer.confirm('确定删除此权限吗?', {icon: 3, title:'提示'}, function(index){
						delMenu();
						layer.close(index);
		            });
		      break;
		    };
		 });
		
	   //---------删除权限-------
		function delMenu(){
	    	var menuid = '';
	    	JSON.stringify(insTb.checkStatus().map(function (d) {
	    		menuid = d.id;
	        }));
	    	alert(menuid)
	    	if(menuid == null || menuid == ""){
	    		layer.msg("请选中一个节点进行删除");
	    	}else{
	    		$.ajax({
	    			url:"http://localhost:8080/layui/qu?action=delMenu",
	    			data:{"menuid":menuid},
	    			type:"post",
	    			dataType:"json",
	    			success:function(data){
	    				//var info = eval("("+data+")");
	    				if(data == 1){
	    					layer.msg("删除成功");
	    					insTb.reload();
	    				}else{
	    					layer.msg("删除失败");
	    				}
	    			}
	    		})
	    	}
	    }

       /*---------修改权限------*/
        function updataMenu(){
        	var authorityId = '';
        	JSON.stringify(insTb.checkStatus().map(function (d) {
				 authorityId = d.id;
            }));
        	if(authorityId == null || authorityId==""){
        		layer.msg('请选择一个进行修改');
        	}else{
        		layer.open({
              		 type:2,
              		 title:"修改权限",
              		 area:['800px','700px'],
              		 content:"par/menuInfo.jsp",
              		 async:false,
              		 success:function(layero, index){
              			 
              					$.post("http://localhost:8080/layui/qu?action=allMenuById",{"menuid":authorityId},function(data){
                      				var info = eval('(' + data + ')')
                      				var body = layui.layer.getChildFrame('body', index);
                      				body.find("#mid").val(info.id);
                      				body.find("#mname").val(info.name);  //权限名
                      				body.find("#mfunction").val(info.function);	//请求路径
              					var select = 'dd[lay-value='+info.type+']';
              					body.find("#type2").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
                  				body.find("#mbtn").val(info.mbth);		//按钮代码
                  				/*body.find("#icon").val(info.data.icon);		//icon图标
    */              				var menuid3 = info.fatherid;
                  				//上级的下拉框
                     			 $.post("http://localhost:8080/layui/qu?action=allMenuByIdName",{"menuid":menuid3},function(res){
                 					var cs = eval('(' + res + ')');
                 					if(cs!=null ){
                 						  body.find("#fatherType2").val(cs.name);
                 					}
              				
             					
     		                  
                 			 })
                 			 
              			 })
                	}
          	    })
        	}
        };
});