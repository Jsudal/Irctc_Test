package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class IrctcBookingPage {	
	
	private WebDriver driver;
	
	public IrctcBookingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By passenger_details_header = By.xpath("//span[contains(text(),'Passenger Details')]");
	private By contact_details_header = By.xpath("//span[contains(text(),'Contact Details')]");	
	
	public void verifyPresenceOfPassengerDetailsHeader () {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1));
		wait.until(ExpectedConditions.presenceOfElementLocated(passenger_details_header));		
	}	
	
	public void verifyPresenceOfContactDetailsHeader () {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1));
		wait.until(ExpectedConditions.presenceOfElementLocated(contact_details_header));
	}
}