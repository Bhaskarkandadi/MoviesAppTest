package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By usernameInput = By.id("usernameInput");
    private By passwordInput = By.id("passwordInput");
    private By loginButton = By.className("login-button");
    private By moviesSection = By.className("slick-slide");
    private By playbutton = By.className("home-movie-play-button");
    private By contactsection = By.className("footer-container");
    private By mainheading = By.className("home-movie-heading");
    private By headingSection1 = By.xpath("//div[@class = 'home-bottom-container']/div[1]/h1");
    private By headingSection2 = By.xpath("//div[@class = 'home-bottom-container']/div[2]/h1");
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public boolean playbuttoncheck() {
        return driver.findElement(playbutton).isDisplayed();
    }
    public boolean contactSectioncheck() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactsection)).isDisplayed();
    }
    public String getHeadingText1() {
        WebElement headingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(headingSection1));
        return headingElement.getText();
    }
    public String getHeadingText2() {
        WebElement headingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(headingSection2));
        return headingElement.getText();
    }
    public String getMainheadingText() {
        WebElement headingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(mainheading));
        return headingElement.getText();
    }
    public boolean areMoviesDisplayedInSection(String sectionName) {
        // Assuming each movie section has a unique identifier
        return waitForVisibilityOfElement(moviesSection).isDisplayed() &&
                !driver.findElements(moviesSection).isEmpty();
    }
    private WebElement waitForVisibilityOfElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void clickOnAnyMovie() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='No Time to Die']")));
        driver.findElement(By.xpath("//img[@alt='No Time to Die']")).click();
    }
}
