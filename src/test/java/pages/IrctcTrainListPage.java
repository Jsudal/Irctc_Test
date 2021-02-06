package test.java.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IrctcTrainListPage {
	
	private WebDriver driver;
	private By i_agree_button = By.xpath("//span[contains(text(),'I Agree')]/ancestor::button");
	private By yes_button = By.xpath("//span[contains(text(),'Yes')]/ancestor::button");
	
	public IrctcTrainListPage(WebDriver driver) {
		this.driver = driver;
	}	

	public void selectTrainClass(String class_name,String train_number) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1));
		By train_class = By.xpath("//strong[contains(text(),'"+train_number+"')]/parent::div/parent::div/parent::app-train-avl-enq/div[5]/div/table/tr/td//strong[contains(text(),'"+class_name+"')]"); 
		wait.until(ExpectedConditions.presenceOfElementLocated(train_class));
		driver.findElement(train_class).click();
	}
	
	public void clickBookNowButton(String train_number) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1));
		By book_now_button = By.xpath("//strong[contains(text(),'"+train_number+"')]/parent::div/parent::div/parent::app-train-avl-enq//button[contains(text(),'Book Now')]");
		wait.until(ExpectedConditions.presenceOfElementLocated(book_now_button));
		driver.findElement(book_now_button).click();
	}
	
	public void clickIAgreeButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1));		
		wait.until(ExpectedConditions.presenceOfElementLocated(i_agree_button));
		driver.findElement(i_agree_button).click();
	}
	
	public void clickYesButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1));		
		wait.until(ExpectedConditions.presenceOfElementLocated(yes_button));
		driver.findElement(yes_button).click();
	}
}
