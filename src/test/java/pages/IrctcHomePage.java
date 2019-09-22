package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IrctcHomePage {

	private static WebElement element = null;
	
	public static WebElement getLoginLink (WebDriver driver) {
		element = driver.findElement(By.id("loginText"));
		return element;
	}
}