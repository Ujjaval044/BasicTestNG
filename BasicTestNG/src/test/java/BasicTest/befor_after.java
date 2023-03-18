package BasicTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class befor_after {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void tc_01() throws Exception {

//		Go to URL 
		driver.get("https://blazedemo.com/");
		Thread.sleep(5000);

	}

	@Test
	public void tc_02() throws Exception {

//		Choose your departure city:
		new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("Philadelphia");
		Thread.sleep(2000);

//		Choose your destination city:
		new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("New York");
		Thread.sleep(2000);

//		Click on FindFlights button
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//		Click on FindFlights button
		driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test
	public void tc_03() throws Exception {
//		Fill all the data(Valid/Invalid) then click on 'Purchase' Flight button
		driver.findElement(By.id("inputName")).sendKeys("uvy");
		Thread.sleep(1000);
		driver.findElement(By.id("address")).sendKeys("123 main st");
		Thread.sleep(1000);
		driver.findElement(By.id("city")).sendKeys("Philadelphia");
		Thread.sleep(1000);
		driver.findElement(By.id("state")).sendKeys("PA");
		Thread.sleep(1000);
		driver.findElement(By.id("zipCode")).sendKeys("23456");
		Thread.sleep(2000);

		new Select(driver.findElement(By.name("cardType"))).selectByVisibleText("Visa");
		Thread.sleep(2000);

		driver.findElement(By.id("creditCardNumber")).sendKeys("2345617890");
		driver.findElement(By.id("creditCardMonth")).sendKeys("12");
		Thread.sleep(2000);
		driver.findElement(By.id("creditCardYear")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("creditCardYear")).sendKeys("2026");
		Thread.sleep(2000);
		driver.findElement(By.id("nameOnCard")).sendKeys("UVYSAME");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@AfterMethod
	public void afterClass() throws Exception {

		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("MMMddyyyy_HHmmss");

		File abc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(abc, new File(".\\Screenshot\\" + df.format(d) + ".png"));

	}

}
