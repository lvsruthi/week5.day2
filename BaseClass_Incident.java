package week5.day1;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass_Incident {
	public ChromeDriver driver;
	public static List <String> inciNumber= new ArrayList<String>();
	public String sheetName;
	
	/*<class name="week5.day1.NewIncident"/>
      <class name="week5.day1.UpdateIncident"/>
      <class name="week5.day1.AssignIncident"/>
      <class name="week5.day1.DeleteIncident"/>
*/
		
		@BeforeMethod
		@Parameters({"url","username","password"})
		public void preCondition(String UrlTest, String UsernameTest, String PasswordTest) throws InterruptedException
		{
			// TODO Auto-generated method stub
			WebDriverManager.chromedriver().setup();

			// Step1: Load ServiceNow application URL
			driver = new ChromeDriver();
			
			driver.get(UrlTest);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

			// Maximize
			driver.manage().window().maximize();
			
			//inside frame gsft_main
			//using WebElement
			Thread.sleep(2000);
			WebElement frame = driver.findElement(By.id("gsft_main"));
			driver.switchTo().frame(frame);
			//enter username and password
			driver.findElement(By.id("user_name")).sendKeys(UsernameTest);
			driver.findElement(By.id("user_password")).sendKeys(PasswordTest);
			//click okay
			driver.findElement(By.id("sysverb_login")).click();
			
			Thread.sleep(3000);
			//Search “incident “ Filter Navigator
			driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");

			
		}
		
		@AfterMethod
		public void postCondition()
		{
		
			driver.close();
			
		}
		
		@DataProvider
		String[][] getData() throws IOException
		{
			
			return ReadIncidentExcel.readIncidentExcel(sheetName);
			
		}
		
		
	
}
