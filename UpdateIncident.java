package week5.day1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateIncident extends BaseClass_Incident {

	@Test
	public void updateIncident() throws InterruptedException {
		
		
		//click "All"
		//driver.findElement(By.xpath("//span[@id='incident_breadcrumb']/a")).click();
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		
		//Give Incident value and search
		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
		String inciValue = inciNumber.get(0);
		System.out.println("for update "+ inciValue);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='sysverb_new']/following::input[1]")).sendKeys(inciValue, Keys.ENTER);
		
		//click on first resulting value
		driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).click();
		
		WebElement state = driver.findElement(By.id("incident.state"));
		Select states = new Select(state);
		states.selectByIndex(1);
		
		WebElement Properties = driver.findElement(By.id("incident.priority"));
		Select property = new Select(Properties);
		property.selectByIndex(1);
		
		//Click on Update button
		Thread.sleep(5000);
		driver.findElement(By.id("sysverb_update_bottom")).click();
		
		
	}

}
