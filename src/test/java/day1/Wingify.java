package day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Wingify
{
	@Test
	public void login () throws InterruptedException
	{
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://sakshingp.github.io/assignment/login.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("hello");
	driver.findElement(By.id("password")).sendKeys("1234");
	driver.findElement(By.id("log-in")).click();
	driver.findElement(By.xpath("//table[@id='transactionsTable']/thead/tr/th[5]")).click();
	List<WebElement> amount =driver.findElements(By.xpath("//table[@id='transactionsTable']/tbody/tr/td[5]"));
	List<Double> amountlist = new ArrayList<>();
	for(WebElement p : amount)
	{
		amountlist.add(Double.valueOf(p.getText().replace("USD", "").replace(" ", "").replace(",", "")));
		
	}
	List<Double> sortedamountlist = new ArrayList<>(amountlist);
	Collections.sort(sortedamountlist);
	Assert.assertEquals(sortedamountlist, amountlist);
	
}
}