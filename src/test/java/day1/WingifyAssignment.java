package day1;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WingifyAssignment 
{
@Test(dataProvider = "credentials")
public void Verifylogincredentials (String scenario, String username ,String password)
{
	WebDriver driver = new ChromeDriver();
	driver.get("https://sakshingp.github.io/assignment/login.html");
	driver.manage().window().maximize();
	//driver.findElement(By.id("username")).sendKeys(username);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.id("log-in")).click();
	
	if (scenario.equals("alphabets"))
	{
		System.out.println("login success");
	}
	else if(scenario.equals("numbers"))
	{
		System.out.println("login success");
	}
	else if(scenario.equals("empty"))
	{
	WebElement errormessage = driver.findElement(By.id("random_id_3"));
	Assert.assertEquals(errormessage.getText(),"Both Username and Password must be present");}
	
	else if(scenario.equals("lowercase"))
	{
		System.out.println("login success");}
	driver.findElement(By.xpath("//table[@id='transactionsTable']/thead/tr/th[5]")).click();
	List<WebElement> amount =driver.findElements(By.xpath("//table[@id='transactionsTable']/tbody/tr/td[5]"));
	List<Double> amountlist = new ArrayList<>();
	for(WebElement p : amount)
	{
		amountlist.add(Double.valueOf(p.getText().replace("USD", "").replace(" ", "").replace(",", "")));
		
	}
	List<Double> sortedamountlist = new ArrayList<>(amountlist);
	Collections.sort(sortedamountlist);
	Assert.assertEquals(sortedamountlist, amountlist);}
	

@DataProvider(name = "credentials")
public Object[] getData()
{
	return new Object[][]
{
		{"alphabets", "Sneha" , "Sneha"  },
		{"lowercase", "vikas"," vikas"},
		{"numbers", "1234", "123456"},
		{"special characters" ,"@#$%" , "@#$%$#@"},
		{"empty", "", ""}
};
}}
