package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IrctcTrainListPage {
	private static WebElement element = null;

	public static WebElement getChkAvailabilityButton(WebDriver driver, String train_number) {
		WebDriverWait wait = new WebDriverWait(driver, 10000, 1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@aria-label,'"+train_number+"') and text()= ' Check availability & fare ']")));
		element = driver.findElement(By.xpath("//button[contains(@aria-label,'"+train_number+"') and text()= ' Check availability & fare ']"));
		return element;
	}
	
	public static WebElement getBookNowButton(WebDriver driver, String travel_date) {
		WebDriverWait wait = new WebDriverWait(driver, 10000, 1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@aria-label,'"+travel_date+"') and text()= ' Book Now']")));
		element = driver.findElement(By.xpath("//button[contains(@aria-label,'"+travel_date+"') and text()= ' Book Now']"));
		return element;
	}
}
