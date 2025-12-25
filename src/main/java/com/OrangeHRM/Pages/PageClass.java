package com.OrangeHRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageClass
{
WebDriver driver;
WebDriverWait wait;

public PageClass(WebDriver driver,WebDriverWait wait)
{
	this.driver=driver;
	this.wait=wait;
}

//Create a generic method to call the call instead of everytime creating object
public <TPage extends BasePage> TPage getInstance(Class<TPage> PageClass)
{
	try 
	{
		return PageClass.getDeclaredConstructor(WebDriver.class,WebDriverWait.class).newInstance(this.driver,this.wait);
	} 
	catch (Exception e) {
	e.printStackTrace();
	}
	return null;
}

}
