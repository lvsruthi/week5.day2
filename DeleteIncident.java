package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteIncident extends BaseClass_Incident{

	@Test
	public void deleteIncident() throws InterruptedException {
		
		
		//click "All"
		//driver.findElement(By.xpath("//span[@id='incident_breadcrumb']/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		
		//Give Incident value and search
		driver.switchTo().frame("gsft_main");
		String incinumber_Value = inciNumber.get(0);
		System.out.println("for delete "+ incinumber_Value);
		driver.findElement(By.xpath("(//label[text()='Search'])[2]/following-sibling::input")).sendKeys(incinumber_Value, Keys.ENTER);
		
		//click on first resulting value
		driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).click();
		
		//Click on Update button
		Thread.sleep(5000);
		driver.findElement(By.id("sysverb_delete_bottom")).click();
		
		//confirm delete
		//Actions builder = new Actions(driver);
		Thread.sleep(2000);
		WebElement okButton = driver.findElement(By.xpath("//button[@id='ok_button']"));
		okButton.click();
		//builder.moveToElement(okButton).click().perform();
		//confirm if its deleted
		//search for the deleted item
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Search'])[2]/following-sibling::input")).sendKeys(incinumber_Value, Keys.ENTER);
		
		//verify if No records to display is displayed
		String noRecord = driver.findElement(By.xpath("//tbody[@class='list2_body']//td")).getText();
		if(noRecord.contains("No records"))
			System.out.println("Deletion successful");
		else
			System.out.println("Deletion unsuccessful");
		
		inciNumber.remove(0);
		
		
		
	}

}
