Feature: Login to SwagDemo page

  Scenario: Login functionality
    Given user navigate to "https://www.saucedemo.com/"
    When user input username as "standard_user"
    And user input password as "secret_sauce"
    And user click to login button
    Then login schould be successful
