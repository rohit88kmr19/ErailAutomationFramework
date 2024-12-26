package erailOrange.com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static erailOrange.com.driver.DriverManager.driver;

public class waitUtils {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    public void elementToBeClickable(By element) {
            // Wait until the element is visible and clickable
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }

    public void visibilityOf(WebDriver driver , WebElement element)
    {

        wait.until(ExpectedConditions.visibilityOf(element));

    }

}

