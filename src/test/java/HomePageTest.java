import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {
    private WebDriver driver;
    private HomePage homePage;
    LoginPage loginpage;
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginpage = new LoginPage(driver);
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginpage.login("rahul", "rahul@2021");
    }
    @Test
    public void testHomePage() {
        assert homePage.getMainheadingText().equals(homePage.getMainheadingText());
        assert homePage.playbuttoncheck();
        assert homePage.getHeadingText1().equals("Trending Now");
        assert homePage.getHeadingText2().equals("Originals");
    }
    @Test
    public void testMoviesDisplayed() {
        assert homePage.areMoviesDisplayedInSection("Trending Now");
        assert homePage.areMoviesDisplayedInSection("Originals");
    }
    @Test
    public void testContactSection() {
        homePage.contactSectioncheck();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
