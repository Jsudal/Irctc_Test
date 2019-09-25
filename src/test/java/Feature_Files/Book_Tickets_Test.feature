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
	#And I input "Date" as "<Date>"
	And I click on "Find_Trains" button
	And I click on "Check_Availability" button of train number "<Train_Number>"
	And I click on "Book Tickets" button for date "<Date>"

Examples:

| Url                     | Origin | Destination | Date        | Train_Number | Passengers_Name                |
| https://www.irctc.co.in | Erode  | Tuticorin   | 30 Sep 2019 | 22670        | Sudalaimani, Susila, Jayakumar |

	
@Book_Tickets_From_Home_Page
Scenario Outline: Verify ticket booking in Irctc

	Given I launch "<Url>"
	And I input "From" as "<Origin>"
	And I input "To" as "<Destination>"
	#And I input "Date" as "<Date>"
	And I click on "Find_Trains" button
	And I click on "Check_Availability" button of train number "<Train_Number>"
	And I click on "Book Tickets" button for date "<Date>"	

Examples:

| Url                       | Origin  | Destination  | Date        | Train_Number |
| https://www.irctc.co.in 	| Erode   | Tuticorin    | 30 Sep 2019 | 22670        |
