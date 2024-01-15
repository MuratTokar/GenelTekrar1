
@genel   // burayi tags a eklesem hepsini calistirir
Feature: Tags

  @smoke
  Scenario: scenario 1
    Given tags scenario 1 step 1
    When tags scenario 1 step 2
    Then tags scenario 1 step 3


  @smoke,@regression
  Scenario: scenario 2
    Given tags scenario 2 step 1
    When tags scenario 2 step 2
    Then tags scenario 2 step 3

  @regression
  Scenario: scenario 3
    Given tags scenario 3 step 1
    When tags scenario 3 step 2
    Then tags scenario 3 step 3