package org.example.base.page;

import io.qameta.allure.Allure;
import org.example.base.page.helper.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage{

    private WebDriver driver;

    private By textTittle = By.className("title");
    private By productItemName = By.className("inventory_item_name");
    private By btnRemoveProduct = By.name("remove-sauce-labs-bike-light");
    private By btnCheckout = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTittlePage(){
        WaitElement.waitForElementToBeVisible(driver, textTittle);

        return driver.findElement(textTittle).getText();
    }

    public String getProductItemName() {
        WaitElement.waitForElementToBeVisible(driver, productItemName);
        return driver.findElement(productItemName).getText();
    }

    public void clickButtonRemove(){

        Allure.step("The user click button remove");
        WaitElement.waitForElementToBeVisible(driver, btnRemoveProduct);
        driver.findElement(btnRemoveProduct).click();
    }

    public CheckoutPage clickButtonCheckout(){
        Allure.step("The user click button checkout");
        WaitElement.waitForElementToBeVisible(driver, btnCheckout);
        driver.findElement(btnCheckout).click();
        return new CheckoutPage(driver);
    }
}
