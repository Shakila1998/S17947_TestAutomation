import org.example.common.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestLogin {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(Constants.CHROME_ARGUMENT);
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }

    @Test
    public void TestValidCredentials() {
        Login loginPage = new Login(driver);
        loginPage.open();
        loginPage.setUsername("admin");
        loginPage.setPassword("manager");
        loginPage.clickLoginButton();
    }

    @Test
    public void TestIncorrectUserName() {
        Login loginPage = new Login(driver);
        loginPage.open();
        loginPage.setUsername("IncorrectUser");
        loginPage.setPassword("manager");
        loginPage.clickLoginButton();
    }

    @Test
    public void TestIncorrectPassword() {
        Login loginPage = new Login(driver);
        loginPage.open();
        loginPage.setUsername("admin");
        loginPage.setPassword("IncorrectPassword");
        loginPage.clickLoginButton();
    }

}
