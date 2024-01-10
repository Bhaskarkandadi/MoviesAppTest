package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountsPage {

    WebDriver driver;
    WebDriverWait wait;
    public AccountsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    By Accountspage = By.className("avatar-button");
    By accountheading = By.className("account-heading");
    By membershipheading = By.className("membership-heading");
    By membershipname = By.className("membership-username");
    By membershipPassword = By.className("membership-password");
    By planparagraph = By.className("plan-paragraph");
    By plandetails = By.className("plan-details");
    By logoutbutton = By.className("logout-button");
    By footersection = By.className("footer-container");

    public void clickaccountbutton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Accountspage));
        driver.findElement(Accountspage).click();
    }
    public boolean Accountheading() {
       return driver.findElement(accountheading).isDisplayed();
    }
    public boolean Membershipheading() {
        return driver.findElement(membershipheading).isDisplayed();
    }
    public boolean Membershipname() {
        return driver.findElement(membershipname).isDisplayed();
    }
    public boolean MembershipPassword() {
        return driver.findElement(membershipPassword).isDisplayed();
    }
    public boolean Plandetails() {
        return driver.findElement(plandetails).isDisplayed();
    }
    public boolean Planparagraph() {
        return driver.findElement(planparagraph).isDisplayed();
    }
    public boolean Logoutbutton() {
        return driver.findElement(logoutbutton).isDisplayed();
    }
    public boolean Footersection() {
        return driver.findElement(footersection).isDisplayed();
    }
    public void logout() {
        driver.findElement(logoutbutton).click();
    }



}
