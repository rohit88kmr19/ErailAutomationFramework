package erailOrange.com.pages.PageObjectmodel;

import erailOrange.com.base.OrangeMethods;
import erailOrange.com.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static erailOrange.com.driver.DriverManager.getDriver;

public class OrangeLoginPage extends OrangeMethods {


    WebDriver driver;

    public OrangeLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Page Locator Orange Login Page
    private By username = By.xpath("//input[@name=\"username\"]");
    private By password = By.xpath("//input[@name=\"password\"]");
    private By login = By.cssSelector("button.orangehrm-login-button");
    //private By dashboard= driver.findElement(By.xpath(""));
    private  By errorMessage= By.xpath("//div[@class=\"oxd-alert-content oxd-alert-content--error\"]/p");
    private By menuDropdown=By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");

    private By logout= By.xpath("//ul[@class=\"oxd-dropdown-menu\"]/li[4]/a");


    // Page Actions Erail Home Page

    public void usernameField(String username1) {
        driver.findElement(username).sendKeys("username");
    }

    public void clearUsername(String username2)
    {
        driver.findElement(username).clear();
    }

    public void passwordField(String password1) {
        driver.findElement(password).sendKeys("password");
    }
    public void clearPassword(String password2) {
        driver.findElement(password).clear();
    }
    public void loginButton() {
        driver.findElement(login).click();

    }
    public void setLogout()
    {
        driver.findElement(logout).click();
    }

    public WebElement setMenuDropdown()
    {
        driver.findElement(menuDropdown);
        return null;
    }

    public void OrangeLogin()  {
        driver.get(PropertyReader.readKey("Orange_url"));
    }

    public boolean getErrorMessage()
    {
        driver.findElement(errorMessage).isDisplayed();
        return true;
    }

    public WebElement visibilityOfElement(By elementLocation) {
       return new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
}

    public String getCurrentUrl()
    {
        return driver.getCurrentUrl();
    }
}
