
//��ҳjs
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
	                    title:'���ܲ˵�',
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
								title:'�豸����',
								border:false,
								//�Ӳ˵�
								html:'<iframe name="westContent" width="100%" height="100%" frameborder="no" scrolling="no" src="public/leftmenu_device.jsp"></iframe>'
								
							},{
								title:'ά�޹���',
								border:false,
								//�Ӳ˵�
								html:'<iframe name="westContent" width="100%" height="100%" frameborder="no" scrolling="no" src="public/leftmenu_repair.jsp"></iframe>'
								
							},{
								title:'ͳ�Ʊ���',
								border:false,
								//�Ӳ˵�
								html:'<iframe name="westContent" width="100%" height="100%" frameborder="no" frameborder="0" scrolling="no" src="public/leftmenu_report.jsp"></iframe>'
							}
							,{
								title:'������־',
								border:false,
								//�Ӳ˵�
								html:'<iframe name="westContent" width="100%" height="100%" frameborder="no" frameborder="0" scrolling="no" src="public/leftmenu_log.jsp"></iframe>'
							}
							,{
								title:'���±�',
								border:false,
								//�Ӳ˵�
								html:'<iframe name="westContent" width="100%" height="100%" frameborder="no" frameborder="0" scrolling="no" src="public/leftmenu_notebook.jsp"></iframe>'
							}
							,{
								title:'�û�����',
								border:false,
								//�Ӳ˵�
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