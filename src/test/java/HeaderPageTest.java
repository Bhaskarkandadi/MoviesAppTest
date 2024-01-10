import Pages.HeaderSectionPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderPageTest {
    WebDriver driver;
    HeaderSectionPage headersectionpage;
    LoginPage loginpage;

    @BeforeMethod
    public void setUp() {
        // Set up the WebDriver instance (assuming you have ChromeDriver installed)
        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        headersectionpage = new HeaderSectionPage(driver);
        loginpage = new LoginPage(driver);
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginpage.login("rahul","rahul@2021");
    }

    @Test(priority = 1)
    public void testHeaderUI() {
        headersectionpage.WebsiteLogocheck();
        headersectionpage.nav_Home_check();
        headersectionpage.nav_Popular_check();
        headersectionpage.searchButton_check();
        headersectionpage.avatarButton_check();
    }

    @Test(priority = 2)
    public void testHeaderFunctionalities() {
        headersectionpage.navHomeCheck();
        headersectionpage.nav_popular_check();
        headersectionpage.nav_Accounts_check();

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
