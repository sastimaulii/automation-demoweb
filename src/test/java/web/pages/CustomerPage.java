package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerPage {

    WebDriver driver;

    By title = By.className("title");

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }
}