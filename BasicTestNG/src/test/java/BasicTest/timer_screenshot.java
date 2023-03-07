package BasicTest;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class timer_screenshot {
	@Test

	public void screenshot() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("https://secure.indianatollroad.org/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Date d = new Date();
		DateFormat df = new SimpleDateFormat("MMMddyyyhhmmss");
		System.out.println(df.format(d));

		// tack screenshot
		File a = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(a, new File("C:\\Users\\Tina Patel\\git\\repository3\\BasicTestNG\\src\\test\\java\\screenshot\\" + df.format(d) + ".png"));
	}
}
