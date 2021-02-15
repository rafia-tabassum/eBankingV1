package com.eBankingV1.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eBanikngV1.pageObjects.LoginPageObject;

public class TC_LoginTest_001 extends BaseClass{


	@Test
	public void logintest() throws IOException
	{
		logger.info("URL is Opened");
		LoginPageObject lp = new LoginPageObject(driver);
		
		lp.Insertusername(username);
		lp.InsertPassword(password);
		
		lp.ClickLogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Testcase Passed!");
		}else
		{
			captureScreen(driver, "logintest");
			Assert.assertTrue(false);
			logger.info("TestCase Failed");
			
		}
	}
}
