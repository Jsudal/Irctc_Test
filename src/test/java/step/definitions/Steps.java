package test.java.step.definitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import test.java.pages.IrctcHomePage;
import test.java.pages.IrctcLoginPage;
import test.java.pages.IrctcTrainListPage;
import test.java.pages.IrctcTrainSearchPage;

public class Steps {
	
	WebDriver driver = null;
	
	IrctcLoginPage LoginPage = null;
	
	@Given("^I launch \"([^\"]*)\"$")
	public void i_launch(String url) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "Chrome_Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);		
		if (url.equals("https://www.irctc.co.in")) {
			try {
				IrctcHomePage.getHomePageAdCloseButton(driver).click();
			}
			catch (NoSuchElementException ne) {
				ne.getSuppressed();
			}			
		}
		LoginPage = PageFactory.initElements(driver, IrctcLoginPage.class);
	}

	@When("^I click on \"([^\"]*)\" button$")
	public void i_click_on_button(String button_name) throws Throwable {
	    if (button_name.equals("Login")) {
	    	IrctcHomePage.getLoginLink(driver).click();
	    } else if (button_name.equals("Find_Trains")) {
	    	IrctcTrainSearchPage.getFindTrainsButton(driver).click();
	    } else if (button_name.equals("Sign_In")) {
	    	LoginPage.signInButton.click();
	    }	    	
	}
	
	@Given("^I click on \"([^\"]*)\" button of train number \"([^\"]*)\"$")
	public void i_click_on_button_of_train_number(String button_name, String train_number) throws Throwable {		
		IrctcTrainListPage.getChkAvailabilityButton(driver, train_number).click();
	}
	
	@Then("^I click on \"([^\"]*)\" button for date \"([^\"]*)\"$")
	public void i_click_on_button_for_date(String button_name, String travel_date) throws Throwable {		
		IrctcTrainListPage.getBookNowButton(driver, travel_date).click();
	}
	
	@When("^I input \"([^\"]*)\" as \"([^\"]*)\"$")
	public void i_input_as(String input_box_name, String input_value) throws Throwable {
	    
	    if (input_box_name.equals("From")) {
	    	WebElement from = IrctcTrainSearchPage.getFromInput(driver);
	    	from.sendKeys(input_value);
	    	Thread.sleep(1000);
	    	from.sendKeys(Keys.ENTER);
	    } else if (input_box_name.equals("To")) {
	    	WebElement to = IrctcTrainSearchPage.getToInput(driver);
	    	to.sendKeys(input_value);
	    	Thread.sleep(1000);
	    	to.sendKeys(Keys.ENTER);
	    } else if (input_box_name.equals("Date")) {
	    	WebElement date_field = IrctcTrainSearchPage.getDateField(driver);
	    	Actions builder = new Actions(driver);
	    	builder.keyDown(date_field, Keys.SHIFT).sendKeys(Keys.HOME).sendKeys(Keys.DELETE).keyUp(Keys.SHIFT).perform();
	    	Thread.sleep(2000);
	    	System.out.println(input_value);
	    	date_field.sendKeys(input_value);
	    	Thread.sleep(2000);
	    } else {
	    	Assert.fail("Input box name passed from feature file not found/defined. Script Execution terminated.");
	    }
	}
	
	@When("^I input \"([^\"]*)\" at Run time$")
	public void i_input_at_Run_time(String input_box_name) throws Throwable {
		
		boolean isPassword;
		if (input_box_name.equals("Password")) {
			isPassword = true;
			String prompt_message = "Please enter your Irctc password:";
			String pwd = Utilities.displayOptionDialog(prompt_message,isPassword);
			LoginPage.passwordInput.sendKeys(pwd);
	    } else if (input_box_name.equals("Captcha")) {
	    	isPassword = false;
	    	String prompt_message = "Please enter the Captcha displayed:";
	    	String captcha = Utilities.displayOptionDialog(prompt_message,isPassword);
	    	try {
	    		LoginPage.nlpCaptchaInput.sendKeys(captcha);
	    	}
	    	catch (NoSuchElementException ne) {
	    		ne.getSuppressed();
	    		LoginPage.captchaInput.sendKeys(captcha);
	    	}	    	
	    } else if (input_box_name.equals("UserName")) {
	    	isPassword = false;
	    	String prompt_message = "Please enter your Irctc UserName:";	    	
	    	String user_name = Utilities.displayOptionDialog(prompt_message,isPassword);
	    	LoginPage.userNameInput.sendKeys(user_name);
	    }	    
	}
}
