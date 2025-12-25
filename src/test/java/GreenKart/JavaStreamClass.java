package GreenKart;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaStreamClass 
{
@Test 
public void javaStream()
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	System.out.println(driver.getCurrentUrl());
	List<WebElement> prices=driver.findElements(By.cssSelector("div[class*='table'] td:nth-of-type(3)"));
	
	List<String> price=prices.stream().map(s->s.getText()).sorted().collect(Collectors.toList());
	System.out.println(price);
	
	
	driver.close();

}
}
