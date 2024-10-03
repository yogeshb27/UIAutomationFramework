package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import resources.ConfigReader;
import utils.BaseTest;
import utils.DriverManager;
import java.io.IOException;
import java.time.Duration;

public class LoginTest extends BaseTest {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    ConfigReader configReader = new ConfigReader();

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        // Get valid email id and password values from config.properties file
        String email = configReader.getProperty("validEmail");
        String password = configReader.getProperty("validPassword");
        // Login to the application
        loginPage.login(email, password);

        HomePage homePage = new HomePage(driver);
        wait.until(ExpectedConditions.visibilityOf(homePage.homePageHeading));
        String expectedUrl = "https://rahulshettyacademy.com/client/dashboard/dash";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed or URL mismatch");
    }
}
