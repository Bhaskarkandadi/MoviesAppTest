import Pages.LoginPage;
import Pages.Searchpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchPageTest {
    WebDriver driver;
    Searchpage searchpage;
    LoginPage loginpage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        loginpage = new LoginPage(driver);
        searchpage = new Searchpage(driver);
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginpage.login("rahul", "rahul@2021");
    }

    @Test
    public void testmoviessearchCount() {
        searchpage.Searchrandom();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
