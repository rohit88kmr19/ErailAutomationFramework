package erailOrange.com.utils;

import erailOrange.com.driver.DriverManagerTL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class waitUtils {
    WebDriverWait wait = new WebDriverWait(DriverManagerTL.getDriver1(), Duration.ofSeconds(6));
    public void elementToBeClickable(By element) {
            // Wait until the element is visible and clickable
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }

    public void visibilityOf(WebDriver driver , WebElement element)
    {

        wait.until(ExpectedConditions.visibilityOf(element));

    }

}

