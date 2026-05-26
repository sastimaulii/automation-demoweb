Feature: Login Test

  Scenario: Successful login with valid credentials
    Given user open login page
    When user login with username "standard_user" and password "secret_sauce"
    Then user should see homepage

  Scenario: Failed login with invalid credentials
    Given user open login page
    When user login with username "invalid_user" and password "wrong_pass"
    Then user should see error message