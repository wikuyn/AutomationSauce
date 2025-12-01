package testing;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
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
    @Tag("Negative Case")
    @Owner("Wiku Yoga Ndaru")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Given The user want to checkout product in saucedemo\n" +
            "And the user navigate to the login page\n" +
            "When the user input empty username and password\n"+
            "Then the user can see error message\n" +
            "And the user failed to login")
    public void loginUsingEmptyCredential(){
        loginPage.setInputUsername("");
        loginPage.setInputPassword("");
        loginPage.clickButtonLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test(priority = 2)
    @Tag("Negative Case")
    @Description("Given the user want to checkout product in saucedemo\n" +
            "And the user navigate to the login page\n" +
            "When the user input empty username\n"+
            "And the user input valid password\n"+
            "Then the user can see error message\n" +
            "And the user failed to login")
    public void loginUsingEmptyUsername(){
        loginPage.setInputUsername("");
        loginPage.setInputPassword(validPassword);
        loginPage.clickButtonLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username");
    }

    @Test(priority = 3)
    @Tag("Negative Case")
    @Description("Given the user want to checkout product in saucedemo\n" +
            "And the user navigate to the login page\n" +
            "When the user input empty password\n"+
            "And the user input valid username\n"+
            "Then the user can see error message\n" +
            "And the user failed to login")
    public void loginUsingEmptyPassword(){
        loginPage.setInputUsername(validUsername);
        loginPage.setInputPassword("");
        loginPage.clickButtonLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

    @Test(priority = 4)
    @Tag("Negative Case")
    @Description("Given the user want to checkout product in saucedemo\n" +
            "And the user navigate to the login page\n" +
            "When the user input valid username\n"+
            "And the user input invalid password\n"+
            "Then the user can see error message\n" +
            "And the user failed to login")
    public void loginUsingInvalidPassword(){
        loginPage.setInputUsername(validUsername);
        loginPage.setInputPassword(invalidPassword);
        loginPage.clickButtonLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(priority = 4)
    @Tag("Positive Case")
    @Description("Given the user want to checkout product in saucedemo\n" +
            "When the user input valid username\n"+
            "And the user input valid password\n"+
            "Then the user will be navigate to home page\n"+
            "And the user successfully login\n")
    public void loginUsingValidCredential(){
        loginPage.setInputUsername(validUsername);
        loginPage.setInputPassword(validPassword);
        homePage = loginPage.clickButtonLogin();
        Assert.assertEquals(homePage.getTextProduct(), "Products");
    }
}
