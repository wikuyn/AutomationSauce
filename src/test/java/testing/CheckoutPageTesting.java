package testing;

import io.qameta.allure.testng.Tag;
import org.example.base.page.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutPageTesting extends HomePageTesting{

    private CheckoutPage checkoutPage;

    @Test(priority = 8)
    @Tag("Positive Case")
    public void navigateToCheckout(){
        loginPage.setInputUsername(validUsername);
        loginPage.setInputPassword(validPassword);
        homePage = loginPage.clickButtonLogin();
        productDetailPage = homePage.clickProduct("Sauce Labs Bike Light");
        productDetailPage.clickButtonAddToCart();
        cartPage = productDetailPage.clickButtonCart();
        Assert.assertEquals(cartPage.getTittlePage(), "Your Cart");
        checkoutPage = cartPage.clickButtonCheckout();
        Assert.assertEquals(checkoutPage.getTextCheckoutForm(), "Checkout: Your Information");
    }

    @Test(priority = 8)
    @Tag("Negative Case")
    public void inputCheckoutFormEmptyFirstName(){
        loginPage.setInputUsername(validUsername);
        loginPage.setInputPassword(validPassword);
        homePage = loginPage.clickButtonLogin();
        productDetailPage = homePage.clickProduct("Sauce Labs Bike Light");
        productDetailPage.clickButtonAddToCart();
        cartPage = productDetailPage.clickButtonCart();
        Assert.assertEquals(cartPage.getTittlePage(), "Your Cart");
        checkoutPage = cartPage.clickButtonCheckout();
        Assert.assertEquals(checkoutPage.getTextCheckoutForm(), "Checkout: Your Information");
        checkoutPage.setInputFirstName("");
        checkoutPage.setInputLastName("Ndaru");
        checkoutPage.setInputPostal("12230");
        checkoutPage.clickButtonContinueCheckout();
        Assert.assertEquals(checkoutPage.getTextError(), "Error: First Name is required");
    }

    @Test(priority = 9)
    @Tag("Negative Case")
    public void inputCheckoutFormEmptyLastName(){
        loginPage.setInputUsername(validUsername);
        loginPage.setInputPassword(validPassword);
        homePage = loginPage.clickButtonLogin();
        productDetailPage = homePage.clickProduct("Sauce Labs Bike Light");
        productDetailPage.clickButtonAddToCart();
        cartPage = productDetailPage.clickButtonCart();
        Assert.assertEquals(cartPage.getTittlePage(), "Your Cart");
        checkoutPage = cartPage.clickButtonCheckout();
        Assert.assertEquals(checkoutPage.getTextCheckoutForm(), "Checkout: Your Information");
        checkoutPage.setInputFirstName("Wiku");
        checkoutPage.setInputLastName("");
        checkoutPage.setInputPostal("12230");
        checkoutPage.clickButtonContinueCheckout();
        Assert.assertEquals(checkoutPage.getTextError(), "Error: Last Name is required");
    }

    @Test(priority = 10)
    @Tag("Negative Case")
    public void inputCheckoutFormEmptyPostal(){
        loginPage.setInputUsername(validUsername);
        loginPage.setInputPassword(validPassword);
        homePage = loginPage.clickButtonLogin();
        productDetailPage = homePage.clickProduct("Sauce Labs Bike Light");
        productDetailPage.clickButtonAddToCart();
        cartPage = productDetailPage.clickButtonCart();
        Assert.assertEquals(cartPage.getTittlePage(), "Your Cart");
        checkoutPage = cartPage.clickButtonCheckout();
        Assert.assertEquals(checkoutPage.getTextCheckoutForm(), "Checkout: Your Information");
        checkoutPage.setInputFirstName("Wiku");
        checkoutPage.setInputLastName("Ndaru");
        checkoutPage.setInputPostal("");
        checkoutPage.clickButtonContinueCheckout();
        Assert.assertEquals(checkoutPage.getTextError(), "Error: Postal Code is required");
    }
}
