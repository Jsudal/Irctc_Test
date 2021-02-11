@Validate_Irctc_Site
Feature: Irctc Site Validation

As an Irctc User
I should be able to login, search for Trains and navigate to booking page

@Login_Successfully_And_Logout
Scenario Outline: Login successfully using valid credentials and logout

	Given I launch Irctc Site 
  When I click on "Login" button
	And I input "UserName" at Run time
	And I input "Password" at Run time
	And I input "Captcha" at Run time
	And I click on "Sign_In" button	
	And I click on "Logout" button

Examples:

| Url                     |
| https://www.irctc.co.in |


@Login_Search_And_Navigate_To_Book_Tickets
Scenario Outline: Login, Search for Trains, Navigate to Booking Page and Logout

	Given I launch Irctc Site
  When I click on "Login" button
	And I input "UserName" at Run time
	And I input "Password" at Run time
	And I input "Captcha" at Run time
	And I click on "Sign_In" button
	And I input "From" as "<Origin>"
	And I input "To" as "<Destination>"
	And I click on "Search" button
	And I select the class as "<Class>" for train number "<Train_Number>"
	And I click on "Book Now" button of train number "<Train_Number>"
	And I click on "I Agree" button
	And I click on "Yes" button
	Then I land on "Booking" page
	And I click on "Logout" button

Examples:

| Url                     | Origin | Destination | Train_Number | Class        |
| https://www.irctc.co.in | Erode  | Chennai     | 02650        | Sleeper      |