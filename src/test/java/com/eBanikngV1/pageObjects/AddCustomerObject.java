package com.eBanikngV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerObject {
	
	WebDriver ldriver;
	
	public AddCustomerObject(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath="/html/body/div[3]/div/ul/li[2]") 
	@CacheLookup
	WebElement txtaddcustomer;
	
	@FindBy (name="name")
	@CacheLookup
	WebElement txtname;
	
	@FindBy (name="rad1")
	@CacheLookup
	WebElement rdbtn;
	
	@FindBy (name="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy (name="addr")
	@CacheLookup
	WebElement txtaddr;
	
	@FindBy (name="city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy (name="state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy (name="pinno")
	@CacheLookup
	WebElement txtpinno;
	
	@FindBy (name="telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
	@FindBy (name="emailid")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy (name="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy (name="sub")
	@CacheLookup
	WebElement btnsubmit;
	
	
	public void clickAddnewCustomer()
	{
		txtaddcustomer.click();
	}
	
	public void setCustomerName(String cname)
	{
		txtname.sendKeys(cname);
	}

	public void selectGender(String cgender)
	{
		rdbtn.click();
	}
	
	public void Customerdob(String mm, String dd, String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void customerAddress(String caddress)
	{
		txtaddr.sendKeys(caddress);
	}
	
	public void Customercity(String ccity)
	{
		txtcity.sendKeys(ccity);
	}
	
	public void customerState(String cstate)
	{
		txtstate.sendKeys(cstate);
	}
	
	public void customerPin(String pinno)
	{
		txtpinno.sendKeys(String.valueOf(pinno));
	}
	
	public void customertelephoneno(String ctelephone)
	{
		txttelephoneno.sendKeys(String.valueOf(ctelephone));
	}
	
	public void customeremail(String email)
	{
		txtemailid.sendKeys(email);
	}
	
	public void customerPassword(String cpwd)
	{
		txtpassword.sendKeys(cpwd);
	}
	
	public void submit()
	{
		btnsubmit.click();
	}
}
