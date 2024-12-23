package erailOrange.com.OrangeTestCases;

import erailOrange.com.ErailTestCases.TC_fromField;
import erailOrange.com.utils.UtilExcelOrangeDDT;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

import static erailOrange.com.driver.DriverManager.driver;

public class UseCase2 {

    private static final Logger logger = LogManager.getLogger(TC_fromField.class);

    @Description("Verifying that user is able to login into the home page with credentials picked from Sheet")
    @Test(dataProvider = "getData", dataProviderClass = UtilExcelOrangeDDT.class)
    public void OrangeTestUseCase2(String username, String password, String exp) throws InterruptedException {

        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
           // options.addArguments("--headless"); // Run without opening the browser
            driver = new ChromeDriver(options);
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        driver.findElement(By.xpath("//input[@name='username']")).clear();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).clear();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();

        // Validate credentials
        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();

        if (exp.equalsIgnoreCase("Valid")) {
            if (actualTitle.equals(expectedTitle)) {
                System.out.println("Login successful for valid credentials: " + username + " , " + password);
                WebElement icon = driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"));
                Actions actions = new Actions(driver);
                actions.moveToElement(icon).click().perform();
                Thread.sleep(2000);

                WebElement logout = driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]/a"));
                logout.click();
                Thread.sleep(2000);
            } else {
                System.out.println("Login failed for valid credentials: " + username + " " + password);
            }
        } else {
            WebElement errorElement = driver.findElement(By.xpath("//div[@class=\"oxd-alert-content oxd-alert-content--error\"]/p"));
            if (errorElement.isDisplayed()) {
                System.out.println("Login failed for invalid credentials as expected: " + username + " " + password);
            } else {
                System.out.println("Unexpected behavior for invalid credentials: " + username + " " + password);
            }
        }

        // Refresh the page for the next set of credentials
        driver.navigate().refresh();
        Thread.sleep(2000);
    }

    @Test(alwaysRun = true, dependsOnMethods = "OrangeTestUseCase2")
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}