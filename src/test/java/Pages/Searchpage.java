package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Searchpage {
    WebDriver driver;
    WebDriverWait wait;
    public Searchpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    By Search = By.id("search");
    By searchbutton = By.className("search-button");
    By Searchicon = By.className("search-empty-button");
    By moviesdetails = By.className("movie-icon-item");



    public void Searchrandom() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Searchicon));
        driver.findElement(Searchicon).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Search));
        driver.findElement(Search).sendKeys("venom");
        driver.findElement(searchbutton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(moviesdetails));

        List<WebElement> movies = driver.findElements(moviesdetails);
        if (movies.size() > 0) {
            int count = driver.findElements(moviesdetails).size();
            System.out.println(count);
        } else {
            System.out.println("no matches found");
        }

    }
}
