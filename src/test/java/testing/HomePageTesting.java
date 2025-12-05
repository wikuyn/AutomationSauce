package testing;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.Tag;
import org.example.base.page.CartPage;
import org.example.base.page.CheckoutPage;
import org.example.base.page.HomePage;
import org.example.base.page.ProductDetailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTesting extends LoginTesting{

     public ProductDetailPage productDetailPage;
     public CheckoutPage checkoutPage;

    @Test(priority = 6)
    @Tag("Positive Case")
    @Description("Given the user want to navigate to product detail page\n" +
            "And the user already successfully login\n"+
            "When the user click product item\n"+
            "Then the user will be navigate to the detail product page\n"+
            "And the user can see detail information of the product\n")
    public void navigateToProductDetail(){
        loginPage.setInputUsername(validUsername);
        loginPage.setInputPassword(validPassword);
        homePage = loginPage.clickButtonLogin();
        productDetailPage = homePage.clickProduct("Sauce Labs Bike Light");
        Assert.assertEquals(productDetailPage.getProductDetailName(), "Sauce Labs Bike Light");
    }

    @Test(priority = 7)
    @Tag("Positive Case")
    @Owner("Wiku Yoga Ndaru")
    @Severity(SeverityLevel.CRITICAL)
    public void addSingleProductToCartFromHomePage(){
        loginPage.setInputUsername(validUsername);
        loginPage.setInputPassword(validPassword);
        homePage = loginPage.clickButtonLogin();
        homePage.getListProductAndClickAddToCart("Sauce Labs Bike Light");
        Assert.assertEquals(homePage.getCartCount(), "1");
    }


    @Test(priority = 8)
    public void addMultipleProductToCartFromHomepage(){
        loginPage.setInputUsername(validUsername);
        loginPage.setInputPassword(validPassword);
        homePage = loginPage.clickButtonLogin();
        homePage.getListProductAndClickAddToCart("Sauce Labs Bike Light");
        homePage.getListProductAndClickAddToCart("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(homePage.getCartCount(), "2");
    }


}
