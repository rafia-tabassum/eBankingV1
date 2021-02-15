package com.eBankingV1.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.eBankingV1.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig rd = new ReadConfig();
	
	public String baseUrl = rd.getBaseUrl();
	public String username = rd.getUserName();
	public String password = rd.getPassword();
	public String chromepath = rd.getChroPath();
	public String firefoxpath = rd.getFirefoxPath();
	public String iepath = rd.getIEPath();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void Setup(String br)
	{
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.getProperty("webdriver.chrome.driver", rd.getChroPath());
			driver = new ChromeDriver();
		}
		else if (br.equals("firefox"))
		{
			System.getProperty("webdriver.gecko.driver", rd.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		else if (br.equals("ie"))
		{
			System.getProperty("webdriver.ie.driver", rd.getIEPath());
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		return generatedString;
	}

	public static String randomnumber()
	{
		String generatednumb = RandomStringUtils.randomNumeric(8);
		return generatednumb;
	}
	
	public static String randomnumericstring()
	{
		String generatednumb = RandomStringUtils.randomAlphanumeric(10);
		return generatednumb;
	}
}
