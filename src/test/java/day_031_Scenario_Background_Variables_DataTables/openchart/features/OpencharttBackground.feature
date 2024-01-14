Feature: Opencart Test
  Background:
    Given user navigate to "http://opencart.abstracta.us/"

  Scenario: Search for mac
    When user search for "mac"
    Then listed product number should be 4


  Scenario: Search for tablet
    When user search for "tablet"
    Then listed product number should be 0

  Scenario: Search for apple
    When user search for "Apple"
    Then listed product number should be 1


