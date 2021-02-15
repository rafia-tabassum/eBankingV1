package com.eBankingV1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configurations\\config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			
			System.out.println("Exception is"+ e.getMessage());
		}
	}
	
	public String getBaseUrl()
	{
		String url = pro.getProperty("baseurl");
		return url;
	}
	
	public String getUserName()
	{
		String uname = pro.getProperty("username");
		return uname;
	}
	
	public String getPassword()
	{
		String pwd = pro.getProperty("password");
		return pwd;
	}
	
	public String getChroPath()
	{
		String chropath = pro.getProperty("chromepath");
		return chropath;
	}
	
	public String getFirefoxPath()
	{
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getIEPath()
	{
		String iepath = pro.getProperty("iepath");
		return iepath;
	}
}
