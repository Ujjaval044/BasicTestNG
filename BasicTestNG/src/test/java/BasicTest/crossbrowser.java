package BasicTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class crossbrowser {

	WebDriver driver;

	@Parameters("browsername")
	@BeforeClass
	public void beforeClass(String browsername) {
		if (browsername.equalsIgnoreCase("crome")) {
			driver = new ChromeDriver();

		} else if (browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		} else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid input");
		}

	}

	@Test
	public void f() throws Exception {
		driver.manage().window().maximize();
		driver.get("https://www.justrechargeit.com/SignIn.aspx");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.partialLinkText("our pass")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("forgotpass_txtEmailId")).sendKeys("samarth12321@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("forgotpass_imgbtnSubmit")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@AfterClass
	public void afterClass() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
