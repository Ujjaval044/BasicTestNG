package BasicTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JRE_forgetPassword {
	@Test
	public void f() throws Exception {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.justrechargeit.com/SignIn.aspx");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.partialLinkText("our pass")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("forgotpass_txtEmailId")).sendKeys("samarth12321@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("forgotpass_imgbtnSubmit")).click();
		Thread.sleep(3000);
		driver.quit();
	}
}
