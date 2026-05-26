@api
Feature: User API Test

  Scenario: Full CRUD user
    Given user set base api url
    When user create new user
    Then response should be success

    When user get user by id
    Then response should be success

    When user update user
    Then response should be success

    When user delete user
    Then response should be success