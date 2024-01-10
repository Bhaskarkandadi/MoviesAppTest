package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import static org.testng.Assert.*;


public class HeaderSectionPage {
    WebDriver driver;
    WebDriverWait wait;
    public HeaderSectionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    By website_logo = By.className("website-logo");
    By nav_home = By.linkText("Home");
    By nav_popular = By.linkText("Popular");
    By search_button = By.className("search-empty-button");
    By usernameInput = By.id("usernameInput");
    By passwordInput = By.id("passwordInput");
    By loginButton = By.className("login-button");
    By avatar_button = By.className("avatar-button");


    public boolean WebsiteLogocheck() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(website_logo)).isDisplayed();
    }
    public boolean nav_Home_check() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nav_home)).isDisplayed();
    }
    public boolean nav_Popular_check() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nav_popular)).isDisplayed();
    }
    public boolean searchButton_check() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(search_button)).isDisplayed();
    }
    public boolean avatarButton_check() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(avatar_button)).isDisplayed();
    }


    public void navHomeCheck() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nav_home));
        driver.findElement(nav_home).click();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        String currenturl = driver.getCurrentUrl();
        String expectedurl = "https://qamoviesapp.ccbp.tech/";
        Assert.assertEquals(currenturl,expectedurl,"urls do not match");
    }

    public boolean nav_popular_check() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nav_popular));
        driver.findElement(nav_popular).click();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/popular"));
        String currenturl = driver.getCurrentUrl();
        String expectedurl = "https://qamoviesapp.ccbp.tech/popular";
        assertTrue(currenturl.equals(expectedurl), "Assertion failed: URLs do not match");
        return true;
    }
    public boolean nav_Accounts_check() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(avatar_button));
        driver.findElement(avatar_button).click();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/account"));
        String currenturl = driver.getCurrentUrl();
        String expectedurl = "https://qamoviesapp.ccbp.tech/account";
        assertTrue(currenturl.equals(expectedurl), "Assertion failed: URLs do not match");
        return true;
    }



}
