package com.OrangeHRM.Pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage
{

	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	//Home Page Text to verify homepage displayed successfully.
	By homeText=By.xpath("//div[@class='oxd-topbar-header-title']//h6");
	//List of Quick launch
	By quickLaunchMenus=By.cssSelector("div[class*='orangehrm-quick-launch'] div[class*='oxd-grid-item']");
	
	public void verifyHomePage(String Expectedmsg)
	{
		String homeActualText=toGetText(homeText);
		assertTrue(homeActualText.contains(Expectedmsg));
	}
	
	public void quickLaunch(String userSelOfQuickMenu)
	{
		List<WebElement> quickMenuNames=toFindElements(quickLaunchMenus);
		for(WebElement QuickMenu: quickMenuNames)
		{
			String QMenu=QuickMenu.getText();
			if(QMenu.equalsIgnoreCase(userSelOfQuickMenu))
			{
				QuickMenu.click();
			}
		}
	}
	
	//Left Menu List
	//div[@class='oxd-sidepanel-body']/ul//li//span or //span[contains(@class,'oxd-main-menu-item--name')]
	By leftMenu=By.xpath("//span[contains(@class,'oxd-main-menu-item--name')]");
	
	public void leftMenus(String SelectMenu)
	{
		List<WebElement> menuListNames=toFindElements(leftMenu);
		for(WebElement menuName: menuListNames)
		{
			String LeftMenuName=menuName.getText();
			if(LeftMenuName.equalsIgnoreCase(SelectMenu))
			{
				menuName.click();
				break;
			}
		}
	}
	
	
	//username column selected://div[@class='oxd-table-card']//div[2]
	By usernamecolNames=By.xpath("//div[@class='oxd-table-card']//div[2]");
	//Column names
	By headerName=By.xpath("//div[contains(@class,'oxd-table-header-cell')]");
	//User
	public void adminWebTable(String usernamesearch)
	{
		List<WebElement> usernames=toFindElements(usernamecolNames);
		for(WebElement username: usernames)
		{
			String names=username.getText();
			if(names.equalsIgnoreCase(usernamesearch))
			{
				
			}
		}
	}
}
