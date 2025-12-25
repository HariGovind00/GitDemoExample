package GreenKart;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

public class NewTabOpen 
{
@Test()
public void win() throws IOException
{
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.google.com");
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://amazon.com/");
	Set<String> win=driver.getWindowHandles();
	Iterator<String> itr=win.iterator();
		String Parent=itr.next();
		String Child=itr.next();
		System.out.println(driver.switchTo().window(Parent));
		driver.navigate().to("https://www.flipkart.com/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	
//Take screenshot
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\SeleniumAutomationFreshStart\\JavaConcepts\\Screenshot\\googe.jpg"));
//	driver.switchTo().newWindow(WindowType.WINDOW);
//	driver.get("https://amazon.com/");
		
		LogEntries entry=driver.manage().logs().get(LogType.BROWSER);
		List<org.openqa.selenium.logging.LogEntry> logs=entry.getAll();
		for(org.openqa.selenium.logging.LogEntry e: logs)
		{
			System.out.println(e.getMessage());
		}
		
		
}
}
