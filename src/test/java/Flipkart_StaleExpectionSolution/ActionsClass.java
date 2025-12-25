package Flipkart_StaleExpectionSolution;

import java.awt.RenderingHints.Key;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsClass
{
static WebDriver driver;
@Test
public void actionActions() throws InterruptedException
{
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.flipkart.com/");
	Actions act=new Actions(driver);
	//Locator ele for search text
	WebElement searchBox=driver.findElement(By.className("Pke_EE"));
	act.doubleClick(searchBox).perform();
	act.moveToElement(searchBox).sendKeys("sunglasses1").perform();
	act.doubleClick(searchBox).keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
	WebElement searchCTAClick=driver.findElement(By.cssSelector("._2iLD__"));
	//act.sendKeys(searchCTAClick, Keys.ENTER).perform();
	act.click(searchCTAClick).perform();
	
	//scrollToElement
	WebElement CategoryOpt=driver.findElement(By.cssSelector("div[class='bpjkJb'] span[class='TSD49J']:nth-of-Type(3)"));
	act.moveToElement(CategoryOpt).click().perform();
	
	WebElement subCat=driver.findElement(By.cssSelector("a[title='Jackets']"));
	act.moveToElement(subCat).click().perform();
	
	
	//Thread.sleep(2000);
//	driver.quit();
	
}
}
