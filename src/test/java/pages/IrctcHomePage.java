package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class IrctcHomePage {	
	
	private WebDriver driver;
	
	public IrctcHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By login_link = By.xpath("//a[text()=' LOGIN ']");
	private By logout_link = By.xpath("//span[contains(text(),'Logout')]/parent::a"); 
	private By ad_close_button = By.id("corover-close-btn");
	private By alert_ok_button = By.xpath("//button[contains(text(),'OK')]");
	
	public void clickLoginLink () {
		driver.findElement(login_link).click();
	}
	
	public void clickLogoutLink () {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1));
		wait.until(ExpectedConditions.presenceOfElementLocated(logout_link));			
		driver.findElement(logout_link).click();
	}
	
	public void clickAlertOkButton () {
		driver.findElement(alert_ok_button).click();
	}
	
	public void clickHomePageAdCloseButton () {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1));
		wait.until(ExpectedConditions.presenceOfElementLocated(ad_close_button));				
		driver.findElement(ad_close_button).click();
	}
}