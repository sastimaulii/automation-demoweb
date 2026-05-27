@web
Feature: E2E Customer Flow

  Scenario: User login and view product list
    Given user open login page
    When user login with username "standard_user" and password "secret_sauce"
    Then user should see homepage