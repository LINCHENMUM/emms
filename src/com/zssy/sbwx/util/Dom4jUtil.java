package com.zssy.sbwx.util;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jUtil {

	//private final static File file = new File("d:\\org.xml");
	//private final static Map orgMap = new HashMap<String,String>();
//	private static String srcPath = Dom4jUtil.class.getResource("/").getPath();
	private static String srcPath="E:\\workspace\\sbwx\\WebRoot\\WEB-INF\\classes";
	public static Map<String,String> getDom4jMap(String filename,String mapname){
		try{
			
//			System.out.println(filePath);
			File file = new File(srcPath+filename);
//			System.out.println(file.getAbsolutePath());
//			System.out.println(file.getPath());
			Map map = new HashMap<String,String>();
			SAXReader reader = new SAXReader();
			if (file.exists()) {
                Document document = reader.read(file);// 读取XML文件
                Element root = document.getRootElement();// 得到根节点
                System.out.println(root.getName());
                for (Iterator i = root.elementIterator(mapname); i.hasNext();) {
                	Element element = (Element) i.next();
                	Element celement = element.element("名称");
                	String celementText = celement.getText();
                	System.out.println(celementText);
                	map.put(celementText, celementText);
                }
            }
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static Map<Integer,String> getrepairStatusMap(String filename,String mapname){
		try{
	
			File file = new File(srcPath+filename);
			Map map = new HashMap<String,String>();
			SAXReader reader = new SAXReader();
			if (file.exists()) {
                Document document = reader.read(file);// 读取XML文件
                Element root = document.getRootElement();// 得到根节点
                System.out.println(root.getName());
                for (Iterator i = root.elementIterator(mapname); i.hasNext();) {
                	Element element = (Element) i.next();
                	String elementid = element.attributeValue("sid");
                	System.out.println(elementid);
                	Integer statusid = Integer.parseInt(elementid);
                	Element celement = element.element("名称");
                	String celementText = celement.getText();
                	System.out.println(celementText);
                	map.put(statusid, celementText);
                }
            }
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println("ddddd");
		getDom4jMap("/xml/org.xml","部门");
		getDom4jMap("/xml/transportor.xml","输送人");
		getDom4jMap("/xml/device.xml","设备");
		getrepairStatusMap("/xml/repairStatus.xml","状态");
		getrepairStatusMap("/xml/repairResult.xml","结果");
	}

}
