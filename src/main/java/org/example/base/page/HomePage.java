package org.example.base.page;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.example.base.page.helper.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private By textProduct = By.cssSelector("[data-test='title']");
    private By elementProductName = By.cssSelector("[data-test='inventory-item-name']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextProduct(){
        Allure.step("The user navigate to the homepage");
        WaitElement.waitForElementToBeVisible(driver, textProduct);
        return driver.findElement(textProduct).getText();
    }

    public ProductDetailPage clickProduct(String product){
        Allure.step("The user click product "+product);
        /*
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementProductName));
        for (int i = 0; i < elements.size(); i++){
            System.out.println(elements.get(i).getText());
            if (elements.get(i).getText().equals(product)){
                elements.get(i).click();
                System.out.println("Element clicked "+ elements.get(i).getText());
            }
        }

         */

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementProductName));
        List<WebElement> elements = driver.findElements(elementProductName);

        for (WebElement element : elements) {
            if (element.getText().trim().equals(product)) {
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                break;
            }
        }
        return new ProductDetailPage(driver);
    }
}
