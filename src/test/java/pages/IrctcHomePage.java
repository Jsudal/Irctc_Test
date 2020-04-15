package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IrctcHomePage {

	private static WebElement element = null;
	
	public static WebElement getLoginLink (WebDriver driver) {
		element = driver.findElement(By.id("loginText"));
		return element;
	}
	
	public static WebElement getHomePageAdCloseButton (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10000, 1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("corover-close-btn")));
		element = driver.findElement(By.id("corover-close-btn"));
		return element;
	}
}