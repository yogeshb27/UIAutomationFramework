package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import resources.ConfigReader;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    ConfigReader configReader = new ConfigReader();

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {

        driver = DriverManager.getDriver(browser);
        System.out.println("Running on: "+browser);
        System.out.println("Thread ID: "+Thread.currentThread().getName());

        driver.get(configReader.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
