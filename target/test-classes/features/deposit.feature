Feature: Deposit money
  As a customer
  I want to deposit money into my account
  So that I can increase my balance

Background:
  Given a customer with id 1 and pin 111 with balance 100 exists
  When I login to ATM with id 1 and pin 111

Scenario: Deposit money successfully
  When I deposit 200
  Then my account balance is 300

Scenario: Deposit zero or negative amount
  When I deposit -50
  Then I should see an error message "Invalid deposit amount"
