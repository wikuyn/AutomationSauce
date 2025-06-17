package testing;

import org.example.base.page.HomePage;
import org.example.base.page.ProductDetailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTesting extends LoginTesting{

    public static HomePage homePage = LoginTesting.homePage;
    private ProductDetailPage productDetailPage;

    @Test(priority = 5)
    public void navigateToProductDetail(){
        loginPage.setInputUsername(validUsername);
        loginPage.setInputPassword(validPassword);
        homePage = loginPage.clickButtonLogin();
        productDetailPage = homePage.clickProduct("Sauce Labs Bike Light");
        Assert.assertEquals(productDetailPage.getProductDetailName(), "Sauce Labs Bike Light");
    }

}
