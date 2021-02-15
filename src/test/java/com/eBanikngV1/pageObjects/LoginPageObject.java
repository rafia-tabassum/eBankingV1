package com.eBanikngV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

	WebDriver ldriver;
	
	public LoginPageObject(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]") 
	@CacheLookup
	WebElement lnkLogout;
	
	public void Insertusername(String uname)
	{
		txtUsername.sendKeys(uname);
	}
	
	public void InsertPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void ClickLogin()
	{
		btnLogin.click();
	}
	
	public void ClickLogout()
	{
		lnkLogout.click();
	}
}
