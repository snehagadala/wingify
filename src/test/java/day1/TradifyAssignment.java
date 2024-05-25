package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TradifyAssignment 

{
  @Test
  public void testcase() throws InterruptedException 
  
 {
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://103.119.255.167:10002/web/login");
	  driver.manage().window().maximize();
	  Thread.sleep(3000);
	  driver.findElement(By.linkText(" laundry_240524")).click();
	  driver.findElement(By.xpath("//button[@class='close']")).click();
	 driver.findElement(By.linkText("Select")).click();

	  
	  
	  
	  
	  
}
}
