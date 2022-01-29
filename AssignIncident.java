package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignIncident extends BaseClass_Incident  {

	@Test
	public void assignIncident()throws InterruptedException {
			
		//click "All"
		//driver.findElement(By.xpath("//span[@id='incident_breadcrumb']/a")).click();
		
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		
		//Give Incident value and search
		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
		String incinumber_Value = inciNumber.get(0);
		System.out.println("for Assign "+ incinumber_Value);
		driver.findElement(By.xpath("(//label[text()='Search'])[2]/following-sibling::input")).sendKeys(incinumber_Value, Keys.ENTER);
		
		//click on first resulting value
		driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).click();
		
			
		WebElement categories = driver.findElement(By.id("incident.category"));
		Select category = new Select(categories);
		category.selectByIndex(2);
		
		driver.findElement(By.id("activity-stream-textarea")).sendKeys("Testing in Progress");
		
		
		//Click on Update button
		Thread.sleep(5000);
		driver.findElement(By.id("sysverb_update_bottom")).click();
		
		
	}

}
