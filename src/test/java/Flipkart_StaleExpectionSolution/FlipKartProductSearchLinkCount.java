package Flipkart_StaleExpectionSolution;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import org.testng.annotations.Test;

public class FlipKartProductSearchLinkCount
{

	public static WebDriver driver;
    @Test(invocationCount = 1)
    public void elementLocator() throws InterruptedException {
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.flipkart.com/");

        // Wait until the top category elements are visible
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("._1ch8e_")));
        List<WebElement> categoryList = driver.findElements(By.cssSelector("._1ch8e_"));

        for (int i = 0; i < categoryList.size(); i++)
        {
            String categoryName = categoryList.get(i).getText();
            System.out.println(categoryName);

            if (categoryName.equalsIgnoreCase("Electronics")) 
            {
                categoryList.get(i).findElement(By.className("_2GaeWJ")).click();

                // ✅ Wait for left side menu to appear after click
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._16rZTH a")));

                // ✅ Find the new left menu items again (fresh DOM)
                List<WebElement> leftList = driver.findElements(By.cssSelector("._16rZTH a"));

                for (int j = 0; j < leftList.size(); j++)
                {
                	String text= leftList.get(j).getText();
                        if (text.equalsIgnoreCase("Cameras & Accessories"))
                        {
                            leftList.get(j).click();
                           int imgcount= driver.findElements(By.xpath("//div[@class='ybB1XH'][1]//img")).size();
                           System.out.println("Image Count="+imgcount);
                           break;
                        }
            }
                break;
        }
        }
    }
}
