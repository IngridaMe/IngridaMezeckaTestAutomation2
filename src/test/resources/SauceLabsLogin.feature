Feature: SauceLabsLogin
  User is able to login with correct credentials. Error message is shown if wrong/empty data is provided

  Scenario: User is able to login with correct credentials
    Given user is navigeted to 'http://saucedome.com/'
    Then user sees page title 'Swag Labs'
    