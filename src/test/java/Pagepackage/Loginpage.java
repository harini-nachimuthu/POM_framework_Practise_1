package Pagepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
	
	public Loginpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="submit")
	WebElement submit;
	
	@FindBy(xpath="//body//div//div//section//div//div//article")
	WebElement message;
	
	public void username(String user) {
		username.sendKeys(user);
	}
	public void password(String pass) {
		password.sendKeys(pass);
	}
	public void submit() {
		submit.click();
	}
	public void message() {
		String name=message.getText();
		System.out.println("name: "+name);
	}
}
