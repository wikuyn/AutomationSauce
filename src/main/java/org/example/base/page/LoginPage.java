package org.example.base.page;

import io.qameta.allure.Allure;
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

    public void setInputUsername(String username){
        Allure.step("The user input username "+username);
        WaitElement.waitForElementToBeVisible(driver, inputUsername);
        driver.findElement(inputUsername).sendKeys(username);
    }

    @Step("Input password: {password}")
    public void setInputPassword(String password){
        Allure.step("The user input password "+password);
        WaitElement.waitForElementToBeVisible(driver, inputPassword);
        driver.findElement(inputPassword).sendKeys(password);
    }

    @Step("Click login button")
    public HomePage clickButtonLogin(){
        Allure.step("The user click button login");
        driver.findElement(btnLogin).click();
        return new HomePage(driver);
    }

    @Step("Get error message from popup")
    public String getErrorMessage() {
        WaitElement.waitForElementToBeVisible(driver, popupError);
        Allure.step("The user can see error message "+popupError);
        return driver.findElement(popupError).getText();
    }
}
