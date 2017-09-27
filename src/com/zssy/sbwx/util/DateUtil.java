package com.zssy.sbwx.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	
	

	 /**
     * ��ȡ�Զ����ʽ���ַ�������
     * @param format
     * @param date
     * @return String
     * @throws ParseException 
     */
    public static String getStringDate(String format, String dateString) throws ParseException {
        return new SimpleDateFormat(format).format(parseStringDate(format,dateString));
    }
    
    /**
     * ��ȡ�Զ����ʽ�����ڸ�ʽ
     * @param format
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date parseStringDate(String format, String date) throws ParseException {
        return new SimpleDateFormat(format).parse(date);
    }
    /**
     * ��ȡ�Զ����ʽ���ַ�������
     * @param format
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getFormatDate(String format,Date date) throws ParseException{
		return new SimpleDateFormat(format).format(date);
    }
    /**
     * ��ȡ�Զ����ʽ�����ڸ�ʽ
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
			// �趨����25JUL�����ڸ�ʽ
			DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
			// �����յ����ַ���ת��ΪDate����
			Date date = df1.parse(dateString);
			// �趨��������ڸ�ʽ
			DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
			// ����ʽ����������
			String result = df2.format(date);
			// ��ӡ���
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
			//�趨����25JUL�����ڸ�ʽ
			DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
			// �����յ����ַ���ת��ΪDate����
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
//			 �趨����25JUL�����ڸ�ʽ
			DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
			// �����յ����ַ���ת��ΪDate����
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
