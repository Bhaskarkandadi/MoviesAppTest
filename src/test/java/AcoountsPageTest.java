import Pages.AccountsPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AcoountsPageTest {
    WebDriver driver;
    LoginPage loginpage;
    AccountsPage accountspage;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        loginpage = new LoginPage(driver);
        accountspage = new AccountsPage(driver);
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginpage.login("rahul","rahul@2021");
    }

    @Test(priority = 1)
    public void testAccountsPageUI() {
        accountspage.clickaccountbutton();
        accountspage.Accountheading();
        accountspage.Membershipheading();
        accountspage.Membershipname();
        accountspage.MembershipPassword();
        accountspage.Plandetails();
        accountspage.Logoutbutton();
        accountspage.Footersection();

    }
    @Test(priority = 2)
    public void Logoutfuctionality() {
        accountspage.clickaccountbutton();
        accountspage.logout();
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
