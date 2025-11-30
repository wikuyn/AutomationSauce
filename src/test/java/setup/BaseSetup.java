package setup;

import com.google.common.io.Files;
import org.example.base.page.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseSetup {
    private final String URL = "https://www.saucedemo.com/";
    private WebDriver driver;
    public LoginPage loginPage;

    @BeforeMethod
    public void BaseSetup() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\wikun\\Documents\\AutomationSauceDemo\\src\\main\\resources\\driver\\chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--guest"); // Jalankan Chrome dalam Guest Mode
        //instance driver as chrome driver;
        driver = new ChromeDriver(options);
        /*

        //setup browser to maximize
        driver.manage().window().maximize();
        //give timeout 10 scn
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //navigate browser to website
        driver.navigate().to(URL);

         */

        WebDriver driver = new RemoteWebDriver(
                new URL("http://chrome:4444/wd/hub"),
                options
        );
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result){
        if (result.getStatus() == ITestResult.SUCCESS){
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshot/"+result.getName()+".jpg"));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        if (driver != null) {
            driver.quit();
        }
    }

}