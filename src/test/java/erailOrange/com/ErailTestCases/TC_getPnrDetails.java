package erailOrange.com.ErailTestCases;

import erailOrange.com.base.CommonToAllTests;
import erailOrange.com.driver.DriverManagerTL;
import erailOrange.com.pages.PageObjectmodel.ErailHomePage;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static erailOrange.com.driver.DriverManagerTL.getDriver1;

public class TC_getPnrDetails extends CommonToAllTests {

    private static final Logger logger = LogManager.getLogger(TC_getPnrDetails.class);

    @Description("Verify that user is able to see all the train details on the home page for the selected destinations")
    @Test
    public static void getPnrDetails() throws InterruptedException {
        logger.info("Getting the data of all Train Pnr number");
        ErailHomePage erailHomePage = new ErailHomePage(getDriver1());
        erailHomePage.ErailLogin();
        // erailHomePage.getTrainsPnrNo();
        logger.info("Get the data of all train number and printing on the screen");
        getDriver1().navigate().back();
        WebDriverWait wait = new WebDriverWait(getDriver1(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(erailHomePage.getTrainNumberDetails));
        List<WebElement> pnrNo = getDriver1().findElements(erailHomePage.getTrainNumberDetails);
        List<String> pnrData = new ArrayList<>();
        //getDriver1().manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        //boolean isOptionFound = false;
        boolean isOptionFound = false;
        for (WebElement pnrDetails : pnrNo) {
            String trainNo = pnrDetails.getText();
            pnrData.add(trainNo);// Adding the data in the dropdown list
            // Print each option for debugging
            System.out.println("All the train details are as:"+trainNo);
            if (pnrDetails.getText().equals("12642")) {
                pnrDetails.click(); // Click the desired option
                Thread.sleep(5000);
                JavascriptExecutor js = (JavascriptExecutor) DriverManagerTL.getDriver1();
                //js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                js.executeScript("window.scrollBy(0, 700);");
                logger.info("Printing the clicked option and verifying thr details of the train");
                System.out.println("Selected: " + pnrDetails.getText());
                isOptionFound = true;
                break; // Exit the loop once the desired option is clicked
            }
        }
        if (!isOptionFound) {
            System.out.println("Option not found in the dropdown.");
        }
    }
}