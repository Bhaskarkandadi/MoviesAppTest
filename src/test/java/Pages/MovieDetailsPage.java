package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class MovieDetailsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By movieTitle = By.xpath("//h1[@class='movie-title']");
    private By movieDescription = By.xpath("//p[@class='movie-overview']");
    private By watchButton = By.className("play-button");
    public MovieDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void testUIElements() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(movieTitle));
        Assert.assertTrue(titleElement.isDisplayed(), "Movie Title is not displayed");

        WebElement descriptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(movieDescription));
        Assert.assertTrue(descriptionElement.isDisplayed(), "Movie Description is not displayed");

        WebElement watchButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(watchButton));
        Assert.assertTrue(watchButtonElement.isDisplayed(), "Watch Button is not displayed");
    }
}

