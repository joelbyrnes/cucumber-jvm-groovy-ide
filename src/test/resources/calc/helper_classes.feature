Feature: External classes and utils

Scenario: Should be able to create a helper class and use it
  When I create the helper class with "foo"
  Then I can get "foo" back from it
