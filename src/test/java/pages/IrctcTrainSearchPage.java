package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class IrctcTrainSearchPage {
	
	private WebDriver driver;	
	
    private By from_input = By.xpath("//*[@id='origin']/span/input");
	private By to_input = By.xpath("//*[@id='destination']/span/input");
	private By date_field = By.xpath("//input[contains(@placeholder,'Journey Date')]");
	private By search_btn = By.xpath("//button[text()='Search']");
	
	public IrctcTrainSearchPage(WebDriver driver) {
		this.driver = driver;
	}		 

	public void enterFromInput(String input_value) throws Throwable {		
		driver.findElement(from_input).sendKeys(input_value);
		Thread.sleep(5000);
		driver.findElement(from_input).sendKeys(Keys.ARROW_DOWN);		
		driver.findElement(from_input).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(5000);
		driver.findElement(from_input).sendKeys(Keys.ENTER);
	}
	
	public void enterToInput(String input_value) throws Throwable {		
		driver.findElement(to_input).sendKeys(input_value);
		Thread.sleep(2000);
		driver.findElement(to_input).sendKeys(Keys.ENTER);
	}
	
	public void selectDateField(String input_value) throws Throwable {				
		Actions builder = new Actions(driver);
    	builder.keyDown(driver.findElement(date_field), Keys.SHIFT).sendKeys(Keys.HOME).sendKeys(Keys.DELETE).keyUp(Keys.SHIFT).perform();
    	Thread.sleep(2000);	    	
    	driver.findElement(date_field).sendKeys(input_value);
    	Thread.sleep(2000);
	}
	
	public void clickSearchButton() throws Throwable {		
		driver.findElement(search_btn).click();
		Thread.sleep(2000);
	}
}
