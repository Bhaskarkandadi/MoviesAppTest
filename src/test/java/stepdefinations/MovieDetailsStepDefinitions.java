package stepdefinations;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MovieDetailsPage;
import Pages.PopularPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MovieDetailsStepDefinitions {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homepage;
    private LoginPage loginpage;

    private MovieDetailsPage movieDetailsPage;
    private PopularPage popularPage;


    @Before
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        loginpage = new LoginPage(driver);
        homepage = new HomePage(driver);
        movieDetailsPage = new MovieDetailsPage(driver);
        popularPage = new PopularPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://qamoviesapp.ccbp.tech");


    }
    @After
    public void teardown() {
        driver.quit();
    }

    @Given("User is on log in page")
    public void userIsLoggedIn() {
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginpage.login("rahul","rahul@2021");

    }

    @When("User clicks on a movie")
    public void userClicksOnMovie() {
        homepage.clickOnAnyMovie();

    }

    @Then("Movie details page should display correct UI elements")
    public void verifyMovieDetailsUIElements() {
        movieDetailsPage.testUIElements();
    }

    @Given("Test UI elements on Movie Details Page from Popular Page")
    public void userIsOnHomePage() {
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginpage.login("rahul","rahul@2021");
    }

    @Given("User is on the Popular Page")
    public void userIsOnPopularPage() {
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginpage.login("rahul","rahul@2021");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Popular")));
        driver.findElement(By.linkText("Popular")).click();
    }

    @When("User clicks on any Movie")
    public void userClicksOnPopularMovie() {
        popularPage.clickOnAnyMovie();
    }

    @Then("Popular Movie details page should display correct UI elements")
    public void verifyPopularMovieDetailsUIElements() {
        movieDetailsPage.testUIElements();
    }
}
