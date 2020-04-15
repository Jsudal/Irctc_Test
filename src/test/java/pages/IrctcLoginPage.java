package test.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class IrctcLoginPage {
	
	final WebDriver driver;
	
	@FindBy(how = How.ID, using = "userId")	 
	public WebElement userNameInput;
	
	@FindBy(how = How.ID, using = "pwd")	 
	public WebElement passwordInput;
	
	@FindBy(how = How.ID, using = "nlpAnswer")	 
	public WebElement nlpCaptchaInput;
	
	@FindBy(how = How.ID, using = "captcha")	 
	public WebElement captchaInput;
	
	@FindBy(how = How.XPATH, using = ".//button[text()='SIGN IN']")	 
	public WebElement signInButton;
	
	public IrctcLoginPage(WebDriver driver) {
	    this.driver = driver;
	}			
}