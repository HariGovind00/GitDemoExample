package com.OrangeHRM.Tests;

import org.testng.annotations.Test;

import com.OrangeHRM.Pages.BasePage;
import com.OrangeHRM.Pages.LoginPage;

public class LoginPageTest extends BaseTest
{
	@Test
	public void loginPageTest()
	{
		page.getInstance(LoginPage.class).loginPageFun("Admin","admin123");
	}
	
	@Test
	public void getTitleTest()
	{
		String title=page.getInstance(BasePage.class).getTitle();
		System.out.println("title="+title);
	}

}
