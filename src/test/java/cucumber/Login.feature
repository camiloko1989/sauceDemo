#Author: camiloko1989@gmail.com
#Keywords Summary : Test Login Functionality
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
Feature: Check the login page functionalty
  

  @tag2
  Scenario Outline: Login succesfully
    Given I am placed in the Login Page
    When I write a valid username <username> and a valid password <password>
    Then I validate the Product Page title <title>

    Examples: 
      | username      | password     | title    |
      | standard_users | secret_sauce | Products |

      
  @errorvalidations
  Scenario Outline: Login unsuccesfully
    Given I am placed in the Login Page
    When I write an invalid username <username> or an invalid password <password>
    Then I validate the error <message> message

    Examples: 
      | username   | password    | message    |
      | error_user | error_sauce | Username and password do not match any user in this service |