package testing;

import org.example.base.page.HomePage;
import org.example.base.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseSetup;

public class LoginTesting extends BaseSetup {

    public final String validUsername = "standard_user";
    public final String validPassword = "secret_sauce";

    private final String invalidUsername = "invalidusername";
    private final String invalidPassword = "invalidpassword";

    public static HomePage homePage;


    @Test(priority = 1)
    public void loginUsingEmptyCredential(){
        loginPage.setInputUsername("");
        loginPage.setInputPassword("");
        loginPage.clickButtonLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test(priority = 2)
    public void loginUsingEmptyUsername(){
        loginPage.setInputUsername("");
        loginPage.setInputPassword(validPassword);
        loginPage.clickButtonLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test(priority = 3)
    public void loginUsingEmptyPassword(){
        loginPage.setInputUsername(validUsername);
        loginPage.setInputPassword("");
        loginPage.clickButtonLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

    @Test(priority = 4)
    public void loginUsingInvalidPassword(){
        loginPage.setInputUsername(validUsername);
        loginPage.setInputPassword(invalidPassword);
        loginPage.clickButtonLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(priority = 4)
    public void loginUsingValidCredential(){
        loginPage.setInputUsername(validUsername);
        loginPage.setInputPassword(validPassword);
        homePage = loginPage.clickButtonLogin();
        Assert.assertEquals(homePage.getTextProduct(), "Products");
    }
}
