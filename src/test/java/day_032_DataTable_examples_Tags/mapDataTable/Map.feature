Feature: map islemleri

  Scenario: map islem1
    Given my string is as fallows
      | Ankara   |
      | Istanbul |
    When my data is as follows
      | name1  | name2    | name3    |
      | Ankara | Istanbul | name3    |
      | name1  | Istanbul | name3    |
      | name1  | Ankara   | Istanbul |
      | name1  | name2    | name3    |
    Then  the count of the cities are 5