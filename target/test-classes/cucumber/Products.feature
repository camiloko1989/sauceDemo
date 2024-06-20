#Author: camiloko1989@gmail.com
#Keywords Summary : Test Products Functionality
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
@tag
Feature: Test the functionalities in Product Page

  @tag2
  Scenario: Order the products by name ascending
    Given I am on the product page
    When I click on the ascending name order option
    Then I see the products ordered by name in ascending way
    
  Scenario: Order the products by name descending
    Given I am on the product page
    When I click on the descending name order option
    Then I see the products ordered by name in descending way

  Scenario: Order the products by price ascending
    Given I am on the product page
    When I click on the ascending price order option
    Then I see the products ordered by price in ascending way

  Scenario: Order the products by price ascending
    Given I am on the product page
    When I click on the descending price order option
    Then I see the products ordered by price in descending way
    
   
  Scenario: Add one product to the cart
  	Given I am on the product page
  	When I select a product "Labs Backpack" and add it to the cart
  	Then The product is added to the cart
      
 	Scenario: Add multiple products to the cart
  	Given I am on the product page
  	When I select the following products and add it to the cart
  		| product      | 
      | Labs Onesie  |
      | Bolt T-Shirt |
      | Bike Light   |
  	Then The product is added to the cart
  	
  	Examples: 
      
      
   Scenario Outline: Open one item page
  	Given I am on the product page
  	When I select a product <product> and I open it
  	Then The item page is displayed
  	
  	Examples: 
      | product      | 
      | Labs Onesie  |


