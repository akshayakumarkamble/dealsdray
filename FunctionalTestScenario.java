package deals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunctionalTestScenario {

	public static void main(String[] args) throws InterruptedException, Throwable {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.dealsdray.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys("prexo.mis@dealsdray.com");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='css-sukebr']/descendant::div/following::div/span[text()='chevron_right']")).click();
		driver.findElement(By.xpath("//span[text()='Orders']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Add Bulk Orders']")).click();
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("F:\\demo-data.xlsx");
		driver.findElement(By.xpath("//button[text()='Import']")).click();
		driver.findElement(By.xpath("//button[text()='Validate Data']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\FunctionalTestValidationScreenshot\\screenshot68.png");
		FileUtils.copyFile(src, dest);
		
	}

}
