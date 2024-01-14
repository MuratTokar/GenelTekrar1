Feature: OrangeHRM

  Scenario: login
    Given user on page
    When user login with the following credentials
      | username | admin    |
      | password | admin123 |
    Then login should be successful