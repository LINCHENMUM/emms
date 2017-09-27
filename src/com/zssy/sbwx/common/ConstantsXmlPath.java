package com.zssy.sbwx.common;

import java.util.Map;

import com.zssy.sbwx.util.Dom4jUtil;

public class ConstantsXmlPath {
	
//	�Ѻ�̨xml�����ļ��еĲ�����Ϣ���������ŵ�map�ϣ���ǰ̨������ʾ
	public static final Map<String,String> orgMap=Dom4jUtil.getDom4jMap("/xml/org.xml","����");
	
//	�Ѻ�̨xml�����ļ��е��豸��Ϣ���������ŵ�map�ϣ���ǰ̨������ʾ
	public static final Map<String,String> deviceMap=Dom4jUtil.getDom4jMap("/xml/device.xml","�豸");
	
//	�Ѻ�̨xml�����ļ��е���������Ϣ���������ŵ�map�ϣ���ǰ̨������ʾ
	public static final Map<String,String> transportorMap=Dom4jUtil.getDom4jMap("/xml/transportor.xml","������");
	
//	�Ѻ�̨xml�����ļ��е�ά��״̬�����ͣ���Ϣ���������ŵ�map�ϣ���ǰ̨������ʾ
	public static final Map<Integer,String> repairStatusMap=Dom4jUtil.getrepairStatusMap("/xml/repairStatus.xml","״̬");
	
//	�Ѻ�̨xml ���ļ��е�ά�޽����Ϣ���������ŵ�map�ϣ���ǰ̨������ʾ
	public static final Map<Integer,String> repairResultMap=Dom4jUtil.getrepairStatusMap("/xml/repairResult.xml","���");
	
}
