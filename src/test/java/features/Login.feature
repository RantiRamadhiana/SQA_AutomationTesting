#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Log in to the application
		@TDD
  	Scenario: Success Login
  	Given user is on login page
    When Input username
    And Input Password
    And user login button click
    Then user in on dashboard page
    
    @TDD
    Scenario: Failed Login
  	Given user is on login page
    When Input username
    And Input Invalid Password
    And user login button click
    Then user get error message
    
    @TDDParameter
  	Scenario Outline: user Login to saucedemo
   	Given user is on saucedemo login page
    When I input <username> as username
    And I input <password> as password
    And user login button
    Then I verify login result

    Examples: 
      | username  | password | status  |
      | standard_user | secret_sauce | success |
      | standard_user |     7 | Fail    |
    
    
    @TDD
    Scenario: User checkout complete
  	Given user already login saucedemo site
    When user click add to cart button on one product or more
    And user click cart icon on the top right side
    And user check shopping list product & click checkoutbutton
    And user fill firstname in biodata form
    And user fill lastname in biodata form
    And user fill postal code in biodata form
    And user click continue button
    And user click the finish button
    Then user successfully purchased the product & user can back to inventory page

    @TDD
    Scenario: User checkout fail
  	Given user already login saucedemo site
    When user click add to cart button on one product or more
    And user click cart icon on the top right side
    And user check shopping list product & click checkoutbutton
    And user fill empty firstname in biodata form
    And user fill empty lastname in biodata form
    And user fill empty postal code in biodata form
    And user click continue button
    Then user failed to buy product & get warning message error 