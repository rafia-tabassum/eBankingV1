package com.eBankingV1.testCases;

import java.io.IOException;

import javax.net.ssl.ExtendedSSLSession;

import org.testng.annotations.Test;

import com.eBanikngV1.pageObjects.AddCustomerObject;
import com.eBanikngV1.pageObjects.LoginPageObject;

import junit.framework.Assert;

public class TC_AddCustomer_003 extends BaseClass{
	
	@Test
	public void AddcustomerTest () throws InterruptedException, IOException
	{
		logger.info("Url Opened to Addcustomer Test");
		LoginPageObject lp =new LoginPageObject(driver);
		lp.Insertusername(username);
		lp.InsertPassword(password);
		logger.info("Login Details Provided");
		
		lp.ClickLogin();
		logger.info("Logged In Successfully");
		
		Thread.sleep(3000);
		AddCustomerObject adcust = new AddCustomerObject(driver);
		
		adcust.clickAddnewCustomer();
		Thread.sleep(3000);
		
		adcust.setCustomerName("Rafia");
		adcust.selectGender("female");
		adcust.Customerdob("07", "11", "1995");
		
		Thread.sleep(3000);
		
		adcust.customerAddress("Mirpur 12");
		adcust.Customercity("Dhaka");
		adcust.customerState("Dhaka");
		adcust.customerPin(randomnumber());
		adcust.customertelephoneno("0162345433");
		String email = randomString()+"@gmail.com";
		adcust.customeremail(email);
		
		adcust.customerPassword(randomnumericstring());
		
		adcust.submit();
		
		Thread.sleep(4000);
		logger.info("Customer addedd scuccessfully - Validation.......");
		Thread.sleep(5000);
		boolean validation = driver.getPageSource().contains("Customer Registered Successfully!!!");
		Thread.sleep(3000);
		if(validation==true)
		{
			Assert.assertTrue(true);
			logger.info("Customer Added Successfully");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("testcase failed....");
			captureScreen(driver, "addNewcustomer");
		}
	
	}
}
