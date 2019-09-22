package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IrctcTrainListPage {
	private static WebElement element = null;

	public static WebElement getChkAvailabilityButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[contains(text(),'22670')]"));
		return element;
	}
}
