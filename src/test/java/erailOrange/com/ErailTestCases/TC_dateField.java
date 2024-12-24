package erailOrange.com.ErailTestCases;

import erailOrange.com.Listeners.RetryAnalyzer;
import erailOrange.com.base.CommonToAllTests;
import erailOrange.com.driver.DriverManager;
import erailOrange.com.pages.PageObjectmodel.ErailHomePage;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static erailOrange.com.driver.DriverManager.driver;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class TC_dateField extends CommonToAllTests {

    private static final Logger logger = LogManager.getLogger(TC_fromField.class);

    @Test
    @Description("Verify the date is selected from the Home Page")
    public static void dateField() throws InterruptedException {
        logger.info("Date Entered Successfully");
        ErailHomePage erailHomePage = new ErailHomePage(DriverManager.getDriver());
        erailHomePage.ErailLogin();
        Thread.sleep(3000);
        //erailHomePage.sortDateField();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", erailHomePage.dateSelect());
        Thread.sleep(4000);// Using this Thread so that , we could see if the date selected or not .
    }


}



