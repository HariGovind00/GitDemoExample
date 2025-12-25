package com.OrangeHRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage
{

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	//username field
	By uname=By.xpath("//input[@name='username']");
	//userPassword
	By upass=By.xpath("//input[@name='password']");
	//Login Button Click
	By loginBtn=By.cssSelector("button[class*='login-button']");
	
	public void loginPageFun(String username,String password)
	{
		toSenKeys(uname, username);
		toSenKeys(upass, password);
		toClick(loginBtn);
	}
	
	
	
	
}
