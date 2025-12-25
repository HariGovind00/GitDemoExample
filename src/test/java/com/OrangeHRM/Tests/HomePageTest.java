package com.OrangeHRM.Tests;

import org.testng.annotations.Test;

import com.OrangeHRM.Pages.HomePage;

public class HomePageTest extends LoginPageTest
{
@Test(enabled = false)
public void VerifyHomePage()
{
	loginPageTest();
	page.getInstance(HomePage.class).verifyHomePage("Dashboard");
}

@Test(enabled = false)
public void QuickLinkMenuTest()
{
	loginPageTest();
	page.getInstance(HomePage.class).quickLaunch("My Timesheet");
}

@Test
public void leftMenuTest()
{
	loginPageTest();
	page.getInstance(HomePage.class).leftMenus("Admin");
}
}
