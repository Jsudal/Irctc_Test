package test.java.step.definitions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import test.java.pages.IrctcHomePage;
import test.java.pages.IrctcLoginPage;
import test.java.pages.IrctcTrainListPage;
import test.java.pages.IrctcTrainSearchPage;
import test.java.pages.IrctcBookingPage;

public class Steps {
	
	WebDriver driver;
	IrctcHomePage homePage;
	IrctcTrainListPage trainListPage;
	IrctcTrainSearchPage trainSearchPage;
	IrctcBookingPage trainBookingPage;
	IrctcLoginPage LoginPage;
	
	@Given("^I launch \"([^\"]*)\"$")
	public void i_launch(String url) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "Chrome_Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);		
		homePage = new IrctcHomePage(driver);		
		if (url.equals("https://www.irctc.co.in")) {
			try {							
				homePage.clickAlertOkButton();
			}
			catch (NoSuchElementException ne) {
				ne.getSuppressed();
			}			
			try {							
				homePage.clickHomePageAdCloseButton();
			}
			catch (NoSuchElementException ne) {
				ne.getSuppressed();
			}			
		}
		LoginPage = PageFactory.initElements(driver, IrctcLoginPage.class);
	}

	@When("^I click on \"([^\"]*)\" button$")
	public void i_click_on_button(String button_name) throws Throwable {
		trainSearchPage = new IrctcTrainSearchPage(driver);
		if (button_name.equals("Login")) {
	    	homePage.clickLoginLink();
	    } else if (button_name.equals("Search")) {
	    	trainSearchPage.clickSearchButton();
	    } else if (button_name.equals("Sign_In")) {
	    	LoginPage.clickSignInButton();
	    } else if (button_name.equals("Logout")) {
	    	homePage.clickLogoutLink();
	    } else if (button_name.equals("I Agree")) {
	    	try {							
	    		trainListPage.clickIAgreeButton();
			} 
	    	catch (NoSuchElementException ne) {
				ne.getSuppressed();
			}	    	
	    } else if (button_name.equals("Yes")) {
	    	try {							
	    		trainListPage.clickYesButton();
	    	} 
	    	catch (NoSuchElementException ne) {
	    		ne.getSuppressed();
	    	}
	    }
	}
	
	@Then("^I land on \"([^\"]*)\" page$")
	public void i_land_on_page(String page_name) throws Throwable {
		trainBookingPage = new IrctcBookingPage(driver);
		if (page_name.equals("Booking")) {
			trainBookingPage.verifyPresenceOfPassengerDetailsHeader();
			trainBookingPage.verifyPresenceOfContactDetailsHeader();
		}
	}
	
	@When("^I click on \"([^\"]*)\" button of train number \"([^\"]*)\"$")
	public void i_click_on_button_of_train_number(String button_name, String train_number) throws Throwable {				
		trainListPage.clickBookNowButton(train_number);
	}
	
	@When("^I select the class as \"([^\"]*)\" for train number \"([^\"]*)\"$")
	public void i_select_the_class_as_for_train_number(String class_name, String train_number) throws Throwable {				
		trainListPage = new IrctcTrainListPage(driver);
		trainListPage.selectTrainClass(class_name,train_number);
	}	
	
	@When("^I input \"([^\"]*)\" as \"([^\"]*)\"$")
	public void i_input_as(String input_box_name, String input_value) throws Throwable {
	    
	    if (input_box_name.equals("From")) {
	    	trainSearchPage.enterFromInput(input_value);	    	    	
	    } 
	    else if (input_box_name.equals("To")) {
	    	trainSearchPage.enterToInput(input_value);   	
	    } 
	    else if (input_box_name.equals("Date")) {
	    	trainSearchPage.selectDateField(input_value);
	    } 
	    else {
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
			LoginPage.enterPasswordInput(pwd);
	    } else if (input_box_name.equals("Captcha")) {
	    	isPassword = false;
	    	String prompt_message = "Please enter the Captcha displayed:";
	    	String captcha = Utilities.displayOptionDialog(prompt_message,isPassword);
	    	try {
	    		LoginPage.enterNlpCaptchaInput(captcha);
	    	}
	    	catch (NoSuchElementException ne) {
	    		ne.getSuppressed();
	    		LoginPage.enterCaptchaInput(captcha);
	    	}	    	
	    } else if (input_box_name.equals("UserName")) {
	    	isPassword = false;
	    	String prompt_message = "Please enter your Irctc UserName:";	    	
	    	String user_name = Utilities.displayOptionDialog(prompt_message,isPassword);
	    	LoginPage.enterUserNameInput(user_name);
	    }	    
	}
}
