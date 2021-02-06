@Verify_Ticket_Booking
Feature: Irctc Ticket Booking Validation

As an Irctc User
I should be able to login and book tickets through Irctc Site

@Login_And_Book_Tickets
Scenario Outline: Login and Book tickets in Irctc Site

	Given I launch "<Url>"
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
| https://www.irctc.co.in | Erode  | Chennai     | 02640        | AC 3 Tier    |

	
@Book_Tickets_From_Home_Page
Scenario Outline: Verify ticket booking in Irctc

	Given I launch "<Url>"
	And I input "From" as "<Origin>"
	And I input "To" as "<Destination>"	
	And I click on "Search" button
	And I click on "Book Now" button of train number "<Train_Number>"
	And I click on "Book Tickets" button for date "<Date>"	

Examples:

| Url                       | Origin  | Destination  | Train_Number |
| https://www.irctc.co.in 	| Erode   | Tuticorin    | 22670        |
