package web.steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

public class CustomerSteps {

    WebDriver driver = DriverManager.getDriver();

    @When("user add product to cart")
    public void addToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("product should be in cart")
    public void verifyCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
        Assert.assertTrue(driver.getPageSource().contains("Sauce Labs Backpack"));
    }
}
