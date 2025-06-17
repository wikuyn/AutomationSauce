package org.example.base.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailPage {
    private WebDriver driver;

    private By productDetailName = By.cssSelector("[data-test='inventory-item-name']");
    private By buttonAddToCart = By.name("add-to-cart");

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductDetailName(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productDetailName));
        return driver.findElement(productDetailName).getText();
    }

    public void clickButtonAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonAddToCart));
        driver.findElement(buttonAddToCart).click();
    }
}
