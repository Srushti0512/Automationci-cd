
@tag
Feature: Purchase the order from Ecommerce Website
I want to use this template for my feature file

Background:
Given I landed on Ecommerce Page


@tag2
Scenario Outline: Positive Test of Submitting the order
       Given Logged in the username <name> and password <password>
       When I add product the <productName> to cart
       And Checkout <productName> and submit the order
       Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage
       
       Examples:
       |name                |password    |  productName |
       |Srushti@gmail.com   |Srushti@143!|  ZARA COAT 3 |
