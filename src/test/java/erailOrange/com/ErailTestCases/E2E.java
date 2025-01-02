package erailOrange.com.ErailTestCases;

import erailOrange.com.Listeners.RetryAnalyzer;
import erailOrange.com.base.CommonToAllTests;
import erailOrange.com.driver.DriverManagerTL;
import erailOrange.com.pages.PageObjectmodel.ErailHomePage;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static erailOrange.com.driver.DriverManagerTL.getDriver1;

public class E2E extends CommonToAllTests {


    TC_fromField tcFromField = new TC_fromField();
    TC_toField tcToField = new TC_toField();
    TC_dateField tcDateField = new TC_dateField();
    TC_reservationQuota tcReservationQuota=new TC_reservationQuota();
    TC_classFilterDropdown tcClassFilterDropdown = new TC_classFilterDropdown();
    //ErailHomePage erailHomePage=null;

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void EndToEndTest() throws IOException, InterruptedException {
        ErailHomePage erailHomePage=new ErailHomePage(getDriver1());
        erailHomePage.ErailLogin();
        TC_fromField.fromField();
        TC_toField.toField();
        DriverManagerTL.getDriver1().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        TC_dateField.dateField();
        TC_reservationQuota.fromResQuota();
        TC_classFilterDropdown.classFilterDropdown();
        erailHomePage.getTrainsClick();
        Thread.sleep(4000);//Waiting after clicking on the get Trains button.

    }
}
