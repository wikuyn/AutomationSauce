package org.example.base.page;

import io.qameta.allure.Step;
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputUsername));
        driver.findElement(inputUsername).sendKeys(username);
    }

    @Step("Input password: {password}")
    public void setInputPassword(String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
        driver.findElement(inputPassword).sendKeys(password);
    }

    @Step("Click login button")
    public HomePage clickButtonLogin(){
        driver.findElement(btnLogin).click();
        return new HomePage(driver);
    }

    @Step("Get error message from popup")
    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(popupError));
        return driver.findElement(popupError).getText();
    }
}
