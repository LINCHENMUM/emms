package com.zssy.sbwx.common;

import java.util.Map;

import com.zssy.sbwx.util.Dom4jUtil;

public class ConstantsXmlPath {
	
//	把后台xml配置文件中的部门信息读出来，放到map上，在前台界面显示
	public static final Map<String,String> orgMap=Dom4jUtil.getDom4jMap("/xml/org.xml","部门");
	
//	把后台xml配置文件中的设备信息读出来，放到map上，在前台界面显示
	public static final Map<String,String> deviceMap=Dom4jUtil.getDom4jMap("/xml/device.xml","设备");
	
//	把后台xml配置文件中的输送人信息读出来，放到map上，在前台界面显示
	public static final Map<String,String> transportorMap=Dom4jUtil.getDom4jMap("/xml/transportor.xml","输送人");
	
//	把后台xml配置文件中的维修状态（类型）信息读出来，放到map上，在前台界面显示
	public static final Map<Integer,String> repairStatusMap=Dom4jUtil.getrepairStatusMap("/xml/repairStatus.xml","状态");
	
//	把后台xml 置文件中的维修结果信息读出来，放到map上，在前台界面显示
	public static final Map<Integer,String> repairResultMap=Dom4jUtil.getrepairStatusMap("/xml/repairResult.xml","结果");
	
}
