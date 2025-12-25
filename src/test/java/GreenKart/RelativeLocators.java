package GreenKart;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators 
{
    public static void main(String[] args)
    {
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    	driver.get("https://www.google.com");

    	// Find the search label (always present on Google)
    	WebElement searchLabel = driver.findElement(By.cssSelector("label[for='APjFqb']"));

    	// Locate the actual search box using a relative locator
    	WebElement searchBox = driver.findElement(
    	        with(By.tagName("textarea")).above(searchLabel)
    	);
 
    	// Type text
    	searchBox.sendKeys("Using Relative Locators on Google");
    }
}
