package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By logoImage = By.className("login-website-logo");
    private By headingText = By.className("sign-in-heading");
    private By usernameLabel = By.xpath("//div[@class = 'login-form-container']//form//diV[1]/label");
    private By passwordLabel = By.xpath("//div[@class = 'login-form-container']//form//diV[2]/label");
    private By loginButton = By.className("login-button");
    private By usernameInput = By.id("usernameInput");
    private By passwordInput = By.id("passwordInput");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isLogoImageDisplayed() {
        return driver.findElement(logoImage).isDisplayed();
    }
    public String getHeadingText() {
        return driver.findElement(headingText).getText();
    }
    public String getUsernameLabelText() {
        return driver.findElement(usernameLabel).getText();
    }
    public String getPasswordLabelText() {
        return driver.findElement(passwordLabel).getText();
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public void login(String username, String password) {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        clickLoginButton();
    }
}