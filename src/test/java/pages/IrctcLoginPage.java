package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IrctcLoginPage {

	private static WebElement element = null;
	
	public static WebElement getUserNameInput (WebDriver driver) {
		element = driver.findElement(By.id("userId"));
		return element;
	}
	
	public static WebElement getPasswordInput (WebDriver driver) {
		element = driver.findElement(By.id("pwd"));
		return element;
	}
	
	public static WebElement getNlpCaptchaInput (WebDriver driver) {
		element = driver.findElement(By.id("nlpAnswer"));
		return element;
	}
	
	public static WebElement getCaptchaInput (WebDriver driver) {
		element = driver.findElement(By.id("captcha"));
		return element;
	}
	
	public static WebElement getSignInButton (WebDriver driver) {		
		element = driver.findElement(By.xpath("//button[text()=\"SIGN IN\"]"));
		return element;
	}
	
	
	
}