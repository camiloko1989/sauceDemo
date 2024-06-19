#Author: camiloko1989@gmail.com
#Keywords Summary :
#Feature: List of scenarios.

@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @runThis
  Scenario: Validate total price of added products
    Given I am on the product page
    When I select the following products and add it to the cart
  		|product| 
      |Labs Onesie|
      |Bolt T-Shirt|
      |Bike Light|
    When I click on the cart icon
    When I go the checkout page
    When I fill the form with name "Camilo" last name "Jimenez" and zip code "000111"
    When I go to overview page
    Then The total price is the same as the sum of each product price
    
