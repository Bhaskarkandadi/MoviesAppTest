package Pages;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win64//chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @Test(priority = 1)
    public void testLoginPageUI() {
        assert loginPage.isLogoImageDisplayed();
        assert loginPage.getHeadingText().equals("Login");
        assert loginPage.getUsernameLabelText().equals("USERNAME");
        assert loginPage.getPasswordLabelText().equals("PASSWORD");
        loginPage.clickLoginButton();
    }

    @Test(priority = 2)
    public void testLoginFunctionalities() throws InterruptedException {
        loginPage.login("", "");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        loginPage.login("", "password");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        loginPage.login("username", "");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        loginPage.login("rahul", "wrong_password");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        loginPage.login("rahul", "rahul@2021");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
