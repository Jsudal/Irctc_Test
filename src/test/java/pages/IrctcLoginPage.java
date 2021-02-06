package test.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class IrctcLoginPage {
	
	final WebDriver driver;
	
	public IrctcLoginPage(WebDriver driver) {
	    this.driver = driver;
	}
	
	@FindBy(how = How.ID, using = "userId")	 
	private WebElement userNameInput;
	
	@FindBy(how = How.ID, using = "pwd")	 
	private WebElement passwordInput;
	
	@FindBy(how = How.ID, using = "nlpAnswer")	 
	private WebElement nlpCaptchaInput;
	
	@FindBy(how = How.ID, using = "captcha")	 
	private WebElement captchaInput;
	
	@FindBy(how = How.XPATH, using = "//button[text()='SIGN IN']")	 
	private WebElement signInButton;
	
	public void clickSignInButton () {
		signInButton.click();
	}
	
	public void enterUserNameInput (String user_name) {
		userNameInput.sendKeys(user_name);
	}
	
	public void enterPasswordInput (String pwd) {
		passwordInput.sendKeys(pwd);
	}
	
	public void enterNlpCaptchaInput (String captcha) {
		nlpCaptchaInput.sendKeys(captcha);
	}
	
	public void enterCaptchaInput (String captcha) {
		captchaInput.sendKeys(captcha);
	}
		
}