package BasicTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class alart {
  @Test
  public void f() throws Exception {
	  WebDriver driver;
	  driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		Thread.sleep(5000);

		driver.findElement(By.id("alertButton")).click();
		System.out.println("Click Button to see alert: " + driver.switchTo().alert().getText());
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(4000);

		driver.findElement(By.id("timerAlertButton")).click();
		Thread.sleep(8000);
		System.out
				.println("On button click, alert will appear after 5 seconds: " + driver.switchTo().alert().getText());

		driver.switchTo().alert().accept();
		Thread.sleep(4000);

		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(2000);

		System.out.println("Do you confirm action?: " + driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Thread.sleep(4000);
		String a = driver.findElement(By.xpath("//*[@id=\"confirmResult\"]")).getText();
		System.out.println("after  confirm action: " + a);
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.id("promtButton")));

		driver.findElement(By.id("promtButton")).click();
		Thread.sleep(2000);

		System.out.println("On button click, prompt box will appear: " + driver.switchTo().alert().getText());
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("xyzegv");
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		
		driver.quit();

  }
  
}
