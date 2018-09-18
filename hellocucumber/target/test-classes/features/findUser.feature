Feature: Find User

  Scenario: Find User
    Given I have a valid request
    When I search a user
    Then I should see the user data