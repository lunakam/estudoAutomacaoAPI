Feature: Find User

  Scenario: Find User
    Given I have a valid request
    When I search a user
    Then I should see the user data

  Scenario: Doesn't Find User
    Given I have a valid request
    When I search an invalid user
    Then I should see status code 404

  Scenario: Delay Response
    Given I have a valid request
    When I search an delay request
    Then I should see status code 200
    And I should see the time response delay

    Scenario: Create User
      When I create a new user
      Then I should see status code 201

