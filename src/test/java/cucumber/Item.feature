#Author: camiloko1989@gmail.com
#Keywords Summary : Test Items Functionality
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
Feature: Test the functionalities in Item Page
  I want to use this template for my feature file
  

  @tag1
  Scenario Outline: Title of your scenario
  	Given I am on the item <product> page
    When I click on Add to Cart on the product <product>
    Then The item is added to the cart
    
    Examples: 
      | product     | 
      | Labs Onesie |

