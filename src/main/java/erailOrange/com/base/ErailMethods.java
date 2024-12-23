package erailOrange.com.base;

import erailOrange.com.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static erailOrange.com.driver.DriverManager.driver;
import static erailOrange.com.driver.DriverManager.getDriver;


public class ErailMethods {

    public void openErailURL() {
        getDriver().get(PropertyReader.readKey("eurl"));
    }


}
