package erailOrange.com.ErailTestCases;

import erailOrange.com.Listeners.RetryAnalyzer;
import erailOrange.com.base.CommonToAllTests;
import erailOrange.com.driver.DriverManagerTL;
import erailOrange.com.pages.PageObjectmodel.ErailHomePage;
import erailOrange.com.utils.waitUtils;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class TC_dateField extends CommonToAllTests {

    static waitUtils waitUtils = new waitUtils();
    private static final Logger logger = LogManager.getLogger(TC_fromField.class);

    @Test
    @Description("Verify the date is selected from the Home Page")
    public static void dateField() throws InterruptedException {
        logger.info("Date Entered Successfully");
        ErailHomePage erailHomePage = new ErailHomePage(DriverManagerTL.getDriver1());
        erailHomePage.ErailLogin();
        erailHomePage.sortDateField();
        ((JavascriptExecutor) DriverManagerTL.getDriver1()).executeScript("arguments[0].click();", erailHomePage.dateSelect());
        Thread.sleep(4000);// Using this Thread so that , we could see if the date selected or not .
    }


}



