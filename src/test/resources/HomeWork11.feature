Feature: Login successful


  Scenario: user logs in successfully
    Given user navigate to webpage https://www.saucedemo.com/
    When user writes correct username and password
    Then user can login and see product page and put 1 product in cart


