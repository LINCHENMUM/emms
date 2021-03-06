package com.zssy.sbwx.util;

import java.security.MessageDigest;
import java.io.*;
import javax.crypto.*; 
import javax.crypto.spec.*; 

public class EncryptUtil 
{

// 用MD5不可逆的加密算法，仅限于对字符串加密。
public static String encrypt(String inStr) 
{
	MessageDigest md = null;
	String out = null;

	try 
	{
		md = MessageDigest.getInstance("MD5");
		byte[] digest = md.digest(inStr.getBytes());
		out = byte2hex(digest);
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	return out;
}

private static String byte2hex(byte[] b) 
{
	String hs = "";
	String stmp = "";
	for (int n = 0; n < b.length; n++) 
	{
		stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
		if (stmp.length() == 1) 
		{
			hs = hs + "0" + stmp;
		} 
		else 
		{
			hs = hs + stmp;
		}
	}
	return hs.toUpperCase();
}

// 测试用例，不需要传递任何参数，直接执行即可。
public static void main(String[] args)
{
	String str1 = "123";
	String str2 = "this is my first encrypt programe";
	String str3 = "欢迎使用 杰软科技 !";
	String str4 = "#%$?  密钥字符串";
    String str=encrypt(str2);
	System.out.println("outStr1 is : " + str);
	System.out.println("outStr3 is : " + encrypt(str3));
	System.out.println("outStr4 is : " + encrypt(str4));
	System.out.println("解密文件  is : " + decryptFile("E://123//123.txt.jsmt",str1));
	System.out.println("加密文件  is : "+encryptFile("E:\\123\\123.txt",str1));
}


/** 
加密方法 
输入：要加密的文件，密钥字符串
输出： 
对输入的文件加密后，保存到同一文件夹下增加了".jsmt"扩展名的文件中。 
*/ 
public static int encryptFile(String FileName,String sKey)
{ 
	int Rtn=0;
	try
	{ 
		// 因为密钥须为32位的字符串，故将用户传递的参数用encrypt方法进行处理；
		//（由0-F组成，共32个字符，我们将其拆解为2个16位的密码后进行二次加密运算）如： 
		// AD67EA2F3BE6E5AD D368DFE03120B5DF

		sKey=encrypt(sKey);
		if(sKey.length() != 32)
		{ 
			Rtn=-1;	// sKey is Wrong. //密码长度必须等于32！
			return Rtn;
		}
		byte[] bytK1 = getKeyByStr(sKey.substring(0,16)); 
		byte[] bytK2 = getKeyByStr(sKey.substring(16,32)); 

		File fileIn=new File(FileName);
		if (!fileIn.exists())
		{
			Rtn=-2;	// 需要加密的文件没有找到。
			return Rtn;
		}

		FileInputStream fis = new FileInputStream(fileIn); 
		byte[] bytIn = new byte[(int)fileIn.length()]; 
		for(int i = 0;i<fileIn.length();i++)
		{ 
			bytIn[i] = (byte)fis.read(); 
		} 

		//加密 
		byte[] bytOut = encryptByDES(encryptByDES(bytIn,bytK1),bytK2); 
		String fileOut = fileIn.getPath() + ".jsmt"; 
		FileOutputStream fos = new FileOutputStream(fileOut); 
		for(int i = 0;i<bytOut.length;i++)
		{ 
			fos.write((int)bytOut[i]); 
		} 
		fos.close(); 
		return Rtn;
	}
	catch(Exception e)
	{ 
		Rtn=-3;	// 其他原因导致的加密失败！
		return Rtn;
	} 
} 


/** 
解密函数 
输入： 
要解密的文件，密钥字符串 
输出： 
对制定的文件进行解密处理，保存到用户指定的文件中。（注：待解密的文件扩展名必须为：.jsmt） 
*/ 
private static int decryptFile(String CryptFileName,String sKey)
{ 
	int Rtn=0;	// 默认的返回值为0,成功！
	try
	{ 
		// 因为密钥须为32位的字符串，故将用户传递的参数用encrypt方法进行处理；
		//（由0-F组成，共32个字符，我们将其拆解为2个16位的密码后进行二次解密运算）如： 
		// AD67EA2F3BE6E5AD D368DFE03120B5DF

		sKey=encrypt(sKey);
		if(sKey.length()!=32)
		{
			Rtn=-1;	// sKey is Wrong. //密码长度必须等于32！
			return Rtn;
		}

		String strPath = CryptFileName; 
		if(!strPath.substring(strPath.length()-5).toLowerCase().equals(".jsmt"))
		{
			Rtn=-2;	// CryptFileName 扩展名必须为：.jsmt
			return Rtn;
		}

		//用户指定要保存的文件 
		strPath = strPath.substring(0,strPath.length()-5); 
		byte[] bytK1 = getKeyByStr(sKey.substring(0,16)); 
		byte[] bytK2 = getKeyByStr(sKey.substring(16,32)); 

		File fileIn=new File(CryptFileName);
		if (!fileIn.exists())
		{
			Rtn=-3;	// 需要解密的文件没有找到。
			return Rtn;
		}

		FileInputStream fis = new FileInputStream(fileIn); 
		byte[] bytIn = new byte[(int)fileIn.length()]; 
		for(int i = 0;i<fileIn.length();i++)
		{ 
			bytIn[i] = (byte)fis.read(); 
		} 

		//解密 
		byte[] bytOut = decryptByDES(decryptByDES(bytIn,bytK2),bytK1); 
		File fileOut =new File(strPath); 
		fileOut.createNewFile(); 
		FileOutputStream fos = new FileOutputStream(fileOut); 
		for(int i = 0;i<bytOut.length;i++)
		{ 
			fos.write((int)bytOut[i]); 
		} 
		fos.close(); 
		return Rtn;	// 解密成功
	}
	catch(Exception e)
	{ 
		Rtn=-4;	// 其他原因导致的解密失败！
		return Rtn;
	} 
} 


/*
用DES方法加密输入的字节 
bytKey需为8字节长，是加密的密码 
*/ 
private static byte[] encryptByDES(byte[] bytP,byte[] bytKey) throws Exception
{ 
	DESKeySpec desKS = new DESKeySpec(bytKey); 
	SecretKeyFactory skf = SecretKeyFactory.getInstance("DES"); 
	SecretKey sk = skf.generateSecret(desKS); 
	Cipher cip = Cipher.getInstance("DES"); 
	cip.init(Cipher.ENCRYPT_MODE,sk); 
	return cip.doFinal(bytP); 
} 

/** 
用DES方法解密输入的字节 
bytKey需为8字节长，是解密的密码 
*/ 
private static byte[] decryptByDES(byte[] bytE,byte[] bytKey) throws Exception
{ 
	DESKeySpec desKS = new DESKeySpec(bytKey); 
	SecretKeyFactory skf = SecretKeyFactory.getInstance("DES"); 
	SecretKey sk = skf.generateSecret(desKS); 
	Cipher cip = Cipher.getInstance("DES"); 
	cip.init(Cipher.DECRYPT_MODE,sk); 
	return cip.doFinal(bytE); 
} 

/** 
输入密码的字符形式，返回字节数组形式。 
如输入字符串：AD67EA2F3BE6E5AD 
返回字节数组：{173,103,234,47,59,230,229,173} 
*/ 
private static byte[] getKeyByStr(String str)
{ 
	byte[] bRet = new byte[str.length()/2]; 
	for(int i=0;i<str.length()/2;i++)
	{ 
		Integer itg = 	new Integer(16*getChrInt(str.charAt(2*i)) + getChrInt(str.charAt(2*i+1))); 
		bRet[i] = itg.byteValue(); 
	} 
	return bRet; 
} 

/** 
计算一个16进制字符的10进制值 
输入：0-F 
*/ 
private static int getChrInt(char chr)
{ 
	int iRet=0; 
	if(chr=="0".charAt(0)) iRet = 0; 
	if(chr=="1".charAt(0)) iRet = 1; 
	if(chr=="2".charAt(0)) iRet = 2; 
	if(chr=="3".charAt(0)) iRet = 3; 
	if(chr=="4".charAt(0)) iRet = 4; 
	if(chr=="5".charAt(0)) iRet = 5; 
	if(chr=="6".charAt(0)) iRet = 6; 
	if(chr=="7".charAt(0)) iRet = 7; 
	if(chr=="8".charAt(0)) iRet = 8; 
	if(chr=="9".charAt(0)) iRet = 9; 
	if(chr=="A".charAt(0)) iRet = 10; 
	if(chr=="B".charAt(0)) iRet = 11; 
	if(chr=="C".charAt(0)) iRet = 12; 
	if(chr=="D".charAt(0)) iRet = 13; 
	if(chr=="E".charAt(0)) iRet = 14; 
	if(chr=="F".charAt(0)) iRet = 15; 
	return iRet; 
} 

}// class is over.
