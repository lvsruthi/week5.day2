package week5.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewIncident extends BaseClass_Incident {
	
	@BeforeClass
	void beforeClass()
	{
		sheetName= "Incident_Excel";
	}
	
	@Test(priority=1 , dataProvider="getData")
	public void newIncident(String description, String Notes) throws InterruptedException, IOException {
				
		//click "All"
		//driver.findElement(By.xpath("//span[@id='incident_breadcrumb']/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		
		//Click New button
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_new")).click();
		
		//Select a value for Caller and Enter value for short_description
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		//go to next window
		Set<String> windows = driver.getWindowHandles();
		List <String> window = new ArrayList<String>(windows);
		driver.switchTo().window(window.get(1));
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(window.get(0));
		
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("incident.short_description")).sendKeys(description);
		
		driver.findElement(By.id("incident.work_notes")).sendKeys(Notes);
		
		//Read the incident number and save it a variable
		String inciNumber_value = driver.findElement(By.id("incident.number")).getAttribute("value");
		
		inciNumber.add(inciNumber_value);
		//Click on Submit button
		Thread.sleep(5000);
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		
		System.out.println("The id is "+ inciNumber);
		//driver.switchTo().defaultContent();
		// Search the same incident number in the next search screen as below
		
		//driver.switchTo().frame("gsft_main");
		String inci_value = inciNumber.get(0);
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys(inci_value, Keys.ENTER);
		
		//Verify the incident is created successful
		String frst_result = driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).getText();
		if (frst_result.contains(inciNumber.get(0)))
			System.out.println("Created sucessfully");
		
		
	}
	

}