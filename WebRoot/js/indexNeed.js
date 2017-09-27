
//首页js
  function layout(){
      Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
       var viewport = new Ext.Viewport({
            layout:'border',
            items:[
            
            		{
	                    region:'north',
	                    split:true,
	                    height: 49,
						autoScroll:true,
	                    minSize: 49,
	                    maxSize: 49,
	                    html:'<iframe name="headContent" width="100%" height="100%" frameborder="no" scrolling="no" src=public/top.jsp></iframe>'
                	},
					{
	                    region:'west',
	                    id:'west-panel',
	                    title:'功能菜单',
	                    split:true,
	                    autoScroll:false,
	                    width: 120,
	                    minSize: 120,
	                    maxSize: 120,
	                    collapsible: true,
	                    margins:'0 0 0 5',
	                    layout:'accordion',
                    	layoutConfig:{
                        	animate:true
                    	},

						 items: [
							{
								title:'设备管理',
								border:false,
								//子菜单
								html:'<iframe name="westContent" width="100%" height="100%" frameborder="no" scrolling="no" src="public/leftmenu_device.jsp"></iframe>'
								
							},{
								title:'维修管理',
								border:false,
								//子菜单
								html:'<iframe name="westContent" width="100%" height="100%" frameborder="no" scrolling="no" src="public/leftmenu_repair.jsp"></iframe>'
								
							},{
								title:'统计报表',
								border:false,
								//子菜单
								html:'<iframe name="westContent" width="100%" height="100%" frameborder="no" frameborder="0" scrolling="no" src="public/leftmenu_report.jsp"></iframe>'
							}
							,{
								title:'工作日志',
								border:false,
								//子菜单
								html:'<iframe name="westContent" width="100%" height="100%" frameborder="no" frameborder="0" scrolling="no" src="public/leftmenu_log.jsp"></iframe>'
							}
							,{
								title:'记事本',
								border:false,
								//子菜单
								html:'<iframe name="westContent" width="100%" height="100%" frameborder="no" frameborder="0" scrolling="no" src="public/leftmenu_notebook.jsp"></iframe>'
							}
							,{
								title:'用户管理',
								border:false,
								//子菜单
								html:'<iframe name="westContent" width="100%" height="100%" frameborder="no" frameborder="0" scrolling="no" src="public/leftmenu_user.jsp"></iframe>'
							}
							],
						  listeners: {
							click: function(n) {
								//parent.mainContent.src="http://www..cn";
								alert("sadfsdkfjsad");
							}
						}
               		},
               		{
	                	region:'center',
						id:'center-panel',
	                	html:'<iframe name="mainContent" width="100%" height="100%" frameborder="0" scrolling="yes" src="${pageContext.request.contextPath}/borrowReturnList.action"></iframe>'
                	},
                	{
	                    region:'south',
	                    split:true,
						autoScroll:true,
	                    height: 1,
						minSize: 1,
	                    maxSize: 1,
	                    html:'<iframe name="footContent" width="100%" height="100%" frameborder="no" scrolling="no" src=public/foot.jsp ></iframe>'
                	}
               
             ]
        });
        
    } 