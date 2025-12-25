package com.OrangeHRM.Pages;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends PageClass
{

	public BasePage(WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
	}
	
	
	public void toClick(By locator)
	{
		driver.findElement(locator).click();
	}
	
	public void toSenKeys(By locator,String val)
	{
		driver.findElement(locator).sendKeys(val);
	}
	
	public String toGetText(By locator)
	{
		return driver.findElement(locator).getText();
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public void toFind(By locator)
	{
		driver.findElement(locator);
	}
	public List<WebElement> toFindElements(By locator)
	{
		return driver.findElements(locator);
	}
	

}
