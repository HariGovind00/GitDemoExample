package com.OrangeHRM.Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.OrangeHRM.Pages.PageClass;

public class BaseTest
{
public WebDriver driver;
public WebDriverWait wait;
public PageClass page;

@BeforeMethod
public void setUpBrowser()
{
	driver=new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
	page=new PageClass(driver, wait);
}



@AfterMethod
public void teardown() throws InterruptedException
{
	Thread.sleep(5000);
	driver.quit();
}
}
