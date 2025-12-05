package testing;

import io.qameta.allure.testng.Tag;
import org.example.base.page.CartPage;
import org.example.base.page.HomePage;
import org.example.base.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.PanelUI;

public class CartPageTesting extends HomePageTesting {
    public CartPage cartPage;
    public HomePage homePage;

    @Test(priority = 9)
    @Tag("Positive Case")
    public void removeProductFromCart(){
        loginPage.setInputUsername(validUsername);
        loginPage.setInputPassword(validPassword);
        homePage = loginPage.clickButtonLogin();
        productDetailPage = homePage.clickProduct("Sauce Labs Bike Light");
        productDetailPage.clickButtonAddToCart();
        cartPage = productDetailPage.clickButtonCart();
        System.out.println("Jumlah barang di keranjang "+cartPage.getCartItemCount());
        Assert.assertEquals(cartPage.getTittlePage(), "Your Cart");
        Assert.assertEquals(cartPage.getCartItemCount(), 1);
        cartPage.clickButtonRemove();
        Assert.assertEquals(cartPage.getCartItemCount(), 0);
        System.out.println("Jumlah barang di keranjang "+cartPage.getCartItemCount());
    }

    @Test(priority = 10)
    public void addMultipleProductToCartFromCart(){
        loginPage.setInputUsername(validUsername);
        loginPage.setInputPassword(validPassword);
        homePage = loginPage.clickButtonLogin();
        productDetailPage = homePage.clickProduct("Sauce Labs Bike Light");
        productDetailPage.clickButtonAddToCart();
        cartPage = productDetailPage.clickButtonCart();
        Assert.assertEquals(cartPage.getCartItemCount(), 1);
        homePage = cartPage.clickButtonContinueShop();
        homePage.clickProduct("Sauce Labs Bolt T-Shirt");
        productDetailPage.clickButtonAddToCart();
        productDetailPage.clickButtonCart();
        System.out.println("Jumlah barang di keranjang anda "+cartPage.getCartItemCount());
    }

    @Test(priority = 11)
    public void navigateToProductDetailFromCart(){
        loginPage.setInputUsername(validUsername);
        loginPage.setInputPassword(validPassword);
        homePage = loginPage.clickButtonLogin();
        homePage.getListProductAndClickAddToCart("Sauce Labs Bike Light");
        cartPage = homePage.clickButtonCart();
        cartPage.clickButtonContinueShop();
        Assert.assertEquals(homePage.getTextProduct(), "Products");
    }

}
