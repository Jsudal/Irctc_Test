package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IrctcTrainSearchPage {

	private static WebElement element = null;

	public static WebElement getFromInput(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"origin\"]/span/input"));
		return element;
	}
	
	public static WebElement getToInput(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"destination\"]/span/input"));
		return element;
	}
	
	public static WebElement getDateField(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[contains(@placeholder,\"Journey Date\")]"));
		return element;
	}
	
	public static WebElement getFindTrainsButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[text()=\"Find trains\"]"));
		return element;
	}
}
