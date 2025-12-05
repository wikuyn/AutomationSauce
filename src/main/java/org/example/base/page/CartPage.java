package org.example.base.page;

import io.qameta.allure.Allure;
import org.example.base.page.helper.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage{

    private WebDriver driver;

    private By textTittle = By.className("title");
    private By productItemName = By.className("inventory_item_name");
    private By btnRemoveProduct = By.name("remove-sauce-labs-bike-light");
    private By btnCheckout = By.id("checkout");
    private By btnContinueShop = By.id("continue-shopping");
    private By cartItemList = By.cssSelector("div.cart_item[data-test='inventory-item']");

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

    public HomePage clickButtonContinueShop(){
        Allure.step("The user click button continue shopping");
        WaitElement.waitForElementToBeVisible(driver, btnContinueShop);
        driver.findElement(btnContinueShop).click();
        return new HomePage(driver);
    }

    public int getCartItemCount(){
        try {
            WaitElement.waitForElementToBeVisible(driver, cartItemList);
            List<WebElement> cartItem = driver.findElements(cartItemList);
            for (WebElement e :cartItem) {
                System.out.println(e.getText());
            }
            return cartItem.size();
        }catch (TimeoutException e){
            return 0;
        }
    }
}
