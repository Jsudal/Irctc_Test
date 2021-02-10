@Validate_Api
Feature: Sample Api Validation

As a quality engineer
I should be able to make Api calls and validate the response through Automation Scripts 

@Make_Api_Call_Validate_Response
Scenario Outline: Successfully make a Get Api call, validate response code and first name of users fetched 

	Given I make the Get Api call
  Then I get the status code as "200" in the response  
  And I get the first name of user with user id "<User_Id>" as "<First_Name>"
      
Examples:

| User_Id | First_name |
| 7       | Michael    |
| 8  			| Lindsay    |
| 9   		| Tobias     |