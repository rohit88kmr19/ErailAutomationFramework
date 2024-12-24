package erailOrange.com.ErailTestCases;

import erailOrange.com.Listeners.RetryAnalyzer;
import erailOrange.com.base.CommonToAllTests;
import erailOrange.com.driver.DriverManager;
import erailOrange.com.pages.PageObjectmodel.ErailHomePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class E2E extends CommonToAllTests {


    TC_fromField tcFromField = new TC_fromField();
    TC_toField tcToField = new TC_toField();
    TC_dateField tcDateField = new TC_dateField();
    TC_reservationQuota tcReservationQuota=new TC_reservationQuota();
    TC_classFilterDropdown tcClassFilterDropdown = new TC_classFilterDropdown();
    ErailHomePage erailHomePage=null;

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void EndToEndTest() throws IOException, InterruptedException {
        ErailHomePage erailHomePage=new ErailHomePage(DriverManager.getDriver());
        erailHomePage.ErailLogin();
        TC_fromField.fromField();
        TC_toField.toField();
        TC_dateField.dateField();
        TC_reservationQuota.fromResQuota();
        Thread.sleep(3000);
        TC_classFilterDropdown.classFilterDropdown();
        erailHomePage.getTrainsClick();
        Thread.sleep(4000);

    }
}
