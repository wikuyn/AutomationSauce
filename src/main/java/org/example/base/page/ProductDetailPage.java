package org.example.base.page;

import org.example.base.page.helper.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailPage {
    private WebDriver driver;

    private By productDetailName = By.cssSelector("[data-test='inventory-item-name']");
    private By buttonAddToCart = By.name("add-to-cart");
    private By badgesCart = By.className("shopping_cart_badge");
    private By buttonCart = By.id("shopping_cart_container");

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductDetailName(){
        WaitElement.waitForElementToBeVisible(driver, productDetailName);
        return driver.findElement(productDetailName).getText();
    }

    public void clickButtonAddToCart(){
        WaitElement.waitForElementToBeVisible(driver, buttonAddToCart);
        driver.findElement(buttonAddToCart).click();
    }

    public String getBadgesQuantity(){
        WaitElement.waitForElementToBeVisible(driver,badgesCart);

        return driver.findElement(badgesCart).getText();
    }

    public CartPage clickButtonCart(){
        WaitElement.waitForElementToBeVisible(driver,buttonCart);

        driver.findElement(buttonCart).click();
        return new CartPage(driver);
    }
}
