package com.eBankingV1.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eBanikngV1.pageObjects.LoginPageObject;
import com.eBankingV1.utilities.XLUtils;

public class TC_DDTLogin_002 extends BaseClass{
	
	@Test (dataProvider="TestData")
	public void DDTLoginTest(String uname, String pwd) throws InterruptedException
	{
		
		logger.info("Url Opened for TC_DDTLogin_002");
		LoginPageObject lp = new LoginPageObject(driver);
		
		lp.Insertusername(uname);
		lp.InsertPassword(pwd);
		logger.info("Informations are provided Sucessfully");
		
		lp.ClickLogin();
		logger.info("Login button is clicked");
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
			
		}else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			Thread.sleep(3000);
			lp.ClickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch (NoAlertPresentException e)
		{
			return false;
		}
	}
	
	@DataProvider(name="TestData")
	String[][] getDatafromexcell() throws IOException{
		String path = System.getProperty("user.dir")+"//src//test//java//com//eBankingV1//testData//TestData.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata [][] = new String[rownum][colcount];
		
		for(int i = 1; i<=rownum; i++)
		{
			for(int j = 0; j<colcount; j++)
			{
				logindata [i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return logindata;
	}

}
