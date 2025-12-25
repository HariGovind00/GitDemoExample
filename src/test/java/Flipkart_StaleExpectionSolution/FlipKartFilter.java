package Flipkart_StaleExpectionSolution;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FlipKartFilter extends FlipKartProductSearchLinkCount
{
@Test(dependsOnMethods = "elementLocator")
public void filterTest()
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	//Filter page verfication
	String filterText=driver.findElement(By.className("rgHxCQ")).getText();
	SoftAssert soft=new SoftAssert();
	soft.assertTrue(filterText.contains("filter"));
	//Filter name list
	List<WebElement> filterNames=driver.findElements(By.cssSelector("div[class*='FtQCb2']"));
	for(WebElement filterName: filterNames)
	{
		String filter=filterName.getText();
		System.out.println(filter);
		if(filter.equalsIgnoreCase("Color"))
		{
			filterName.click();
			//Getting the list of sub-filter name
			List<WebElement>filListNames=driver.findElements(By.cssSelector("div[class*='ewzVkT']"));
			for(WebElement subFilterList:filListNames)
			{
				String subFil=subFilterList.getText();
				System.out.println(subFil);
				if(subFil.equalsIgnoreCase("Black, Silver"))
				{
					subFilterList.click();
					//driver.findElement(By.xpath("//div[@class='q58xaq M8zy8w']/span")).click();			}
					break;
				}
				
		
		}
			break;
	}
}
	
}
}
