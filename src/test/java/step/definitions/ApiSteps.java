package test.java.step.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import test.java.pages.ApiTests;
import io.cucumber.java.en.Then;

public class ApiSteps {	
	
	ApiTests apiTest;
	
	@Given("^I make the Get Api call$")
	public void i_make_the_get_api_call() throws Throwable {
		apiTest = new ApiTests();
		apiTest.makeGetRequest();
	}
	
	@Then("^I get the status code as \"([^\"]*)\" in the response$")
	public void i_get_the_status_code_as_in_the_response(String status_code) throws Throwable {
		apiTest.validateResponseStatusCode();
	}
	
	@Then("^I get the first name of user with user id \"([^\"]*)\" as \"([^\\\"]*)\"$")
	public void i_get_the_first_name_of_user_with_user_id_as(String user_id, String first_name) throws Throwable {
		apiTest.validateFirstName(user_id,first_name);
	}
}