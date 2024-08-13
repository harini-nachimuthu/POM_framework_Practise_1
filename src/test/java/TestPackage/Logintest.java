package TestPackage;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pagepackage.Loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Logintest {
	WebDriver driver;
	Loginpage loginpage;
	
	@BeforeTest
	public void before() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
	}
	@Test(priority=1)
	public void logititlecheck() {
		String expected="Test Login | Practice Test Automation";
		String actual=driver.getTitle();
		Assert.assertEquals(actual, expected);
		System.out.println("Title of page:: "+driver.getTitle());
	}
	@Test(priority=2)
	public void login() {
		loginpage=new Loginpage(driver);
		loginpage.username("student");
		loginpage.password("Password123");
		loginpage.submit();
		loginpage.message();
	}
	@AfterTest
	public void after() {
		driver.quit();
	}
}
