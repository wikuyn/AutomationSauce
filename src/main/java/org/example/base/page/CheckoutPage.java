package org.example.base.page;

import org.example.base.page.helper.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;
    private By inputFirstName = By.id("first-name");
    private By inputLastName = By.id("last-name");
    private By inputPostal = By.id("postal-code");
    private By textCheckoutForm = By.cssSelector("[data-test='title']");
    private By textError = By.cssSelector("[data-test='error']");
    private By btnContinue = By.id("continue");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setInputFirstName(String firstName) {
        WaitElement.waitForElementToBeVisible(driver, inputFirstName);
        driver.findElement(inputFirstName).sendKeys(firstName);
    }

    public void setInputLastName(String lastName) {
        WaitElement.waitForElementToBeVisible(driver, inputLastName);
        driver.findElement(inputLastName).sendKeys(lastName);
    }

    public void setInputPostal(String postalCode) {
        WaitElement.waitForElementToBeVisible(driver, inputPostal);
        driver.findElement(inputPostal).sendKeys(postalCode);
    }

    public String getTextCheckoutForm() {
        WaitElement.waitForElementToBeVisible(driver, textCheckoutForm);

        return driver.findElement(textCheckoutForm).getText();
    }

    public String getTextError() {
        WaitElement.waitForElementToBeVisible(driver, textError);

        return driver.findElement(textError).getText();
    }

    public void clickButtonContinueCheckout(){
        WaitElement.waitForElementToBeVisible(driver, btnContinue);
        driver.findElement(btnContinue).click();
    }
}
