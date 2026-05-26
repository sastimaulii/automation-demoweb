package web.steps;

import io.cucumber.java.en.*;
import web.pages.LoginPage;

import static org.junit.Assert.*;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(Hooks.driver);

    @Given("user open login page")
    public void openLoginPage() throws InterruptedException {
        Hooks.driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000); // biar stabil
    }

    @When("user login with username {string} and password {string}")
    public void login(String username, String password) {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLogin();
    }

    @Then("user should see homepage")
    public void verifyHomepage() {
        assertTrue(Hooks.driver.getCurrentUrl().contains("inventory"));
    }

    @Then("user should see error message")
    public void verifyError() {
        assertTrue(loginPage.isErrorDisplayed());
    }
}