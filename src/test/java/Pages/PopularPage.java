package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PopularPage {
    WebDriver driver;
    WebDriverWait wait;

    public PopularPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By popularmovies = By.xpath("//li[@class='movie-icon-item']");

    By nav_popular = By.linkText("Popular");

    public boolean PopularMoviesui() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nav_popular));
        driver.findElement(nav_popular).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(popularmovies));
        return  driver.findElement(popularmovies).isDisplayed();
    }

    public void clickOnAnyMovie() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[1]/li[2]/a/img")));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/li[2]/a/img")).click();
    }

    public void navigateToPopularPage() {
        driver.findElement(nav_popular).click();
    }
}

