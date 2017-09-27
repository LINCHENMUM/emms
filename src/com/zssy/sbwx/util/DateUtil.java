package com.zssy.sbwx.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	
	

	 /**
     * 获取自定义格式的字符串日期
     * @param format
     * @param date
     * @return String
     * @throws ParseException 
     */
    public static String getStringDate(String format, String dateString) throws ParseException {
        return new SimpleDateFormat(format).format(parseStringDate(format,dateString));
    }
    
    /**
     * 获取自定义格式的日期格式
     * @param format
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date parseStringDate(String format, String date) throws ParseException {
        return new SimpleDateFormat(format).parse(date);
    }
    /**
     * 获取自定义格式的字符串日期
     * @param format
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getFormatDate(String format,Date date) throws ParseException{
		return new SimpleDateFormat(format).format(date);
    }
    /**
     * 获取自定义格式的日期格式
     * @param format
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date formatDate(String format,Date date) throws ParseException{
    	return new SimpleDateFormat(format).parse(getFormatDate(format, date));
    }
    public static Date string2Date(String dateString){
		 try {
			// 设定接收25JUL的日期格式
			DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
			// 将接收到的字符串转化为Date类型
			Date date = df1.parse(dateString);
			// 设定输入的日期格式
			DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
			// 按格式生成输入结果
			String result = df2.format(date);
			// 打印结果
			System.err.println(result);
			return date;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date initialDate(){
		try{
			//设定接收25JUL的日期格式
			DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
			// 将接收到的字符串转化为Date类型
			Date date = df1.parse("1900-01-01");
			return date;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date getToday(){
		try{
			DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
			String today = df2.format(new Date());
			System.out.println(today);
//			 设定接收25JUL的日期格式
			DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
			// 将接收到的字符串转化为Date类型
			Date date = df1.parse(today);
			return date;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getTodayString(){
		try{
			DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
			String today = df2.format(new Date());
			System.out.println(today);
			return today;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
    public static void main(String args[]){
    	try {
			System.out.println(DateUtil.formatDate(DateUtil.YYYY_MM_DD_HH_MM_SS, new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
