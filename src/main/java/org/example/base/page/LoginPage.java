package org.example.base.page;

import io.qameta.allure.Step;
import org.example.base.page.helper.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    //-ea
    private WebDriver driver;
    private By inputUsername = By.id("user-name");
    private By inputPassword = By.id("password");
    private By btnLogin = By.id("login-button");
    private By popupError = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Input username: {username}")
    public void setInputUsername(String username){
        WaitElement.waitForElementToBeVisible(driver, inputUsername);
        driver.findElement(inputUsername).sendKeys(username);
    }

    @Step("Input password: {password}")
    public void setInputPassword(String password){
        WaitElement.waitForElementToBeVisible(driver, inputPassword);
        driver.findElement(inputPassword).sendKeys(password);
    }

    @Step("Click login button")
    public HomePage clickButtonLogin(){
        driver.findElement(btnLogin).click();
        return new HomePage(driver);
    }

    @Step("Get error message from popup")
    public String getErrorMessage() {
        WaitElement.waitForElementToBeVisible(driver, popupError);
        return driver.findElement(popupError).getText();
    }
}
