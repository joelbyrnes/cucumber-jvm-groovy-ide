# language: en
Feature: Addition
  In order to avoid silly mistakes
  Cashiers must be able to calculate a sum

  Scenario: Regular numbers
    Given I have entered 3 into the calculator
    And I have entered 2 into the calculator
    When I press add
    Then the stored result should be 5

  Scenario: More numbers
    Given I have entered 6 into the calculator
    And I have entered 3 into the calculator
    When I press add
    Then the stored result should be 9

  @import
  Scenario: Using Add and divide steps which are defined in different files should get the same calc object.
    Given I have entered 6 into the calculator
    And I have entered 3 into the calculator
    When I press add
    Then the stored result should be 9

    When I have entered 3 into the calculator
    And I press divide
    Then the stored result should be 3
