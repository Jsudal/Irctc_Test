package pages;

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
		//To-Do - Use a better element identifier
		element = driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-main-page/div[1]/div/div[1]/div/div/div[1]/div/app-jp-input/div[3]/form/div[3]/p-calendar/span/input"));
		return element;
	}
	
	public static WebElement getFindTrainsButton(WebDriver driver) {
		//To-Do - Use a better element identifier
		element = driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-main-page/div[1]/div/div[1]/div/div/div[1]/div/app-jp-input/div[3]/form/div[7]/button"));
		return element;
	}
	
	
	
}
