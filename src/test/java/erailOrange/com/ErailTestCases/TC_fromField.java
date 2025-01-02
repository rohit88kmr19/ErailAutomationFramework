package erailOrange.com.ErailTestCases;

import erailOrange.com.base.CommonToAllTests;
import erailOrange.com.driver.DriverManagerTL;
import erailOrange.com.pages.PageObjectmodel.ErailHomePage;
import erailOrange.com.utils.ExcelUtility;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TC_fromField extends CommonToAllTests {

    private static final Logger logger = LogManager.getLogger(TC_fromField.class);

    @Description("Verifying that the Erail Home Page is Opened Successfully and User is able to select the value from dropdown")
    @Test(dataProvider = "", dataProviderClass = ExcelUtility.class)
    public static void fromField() throws InterruptedException, IOException {

        logger.info("Starting the TC and navigating on the Home Page");
        ErailHomePage erailHomePage = new ErailHomePage(DriverManagerTL.getDriver1());
        erailHomePage.ErailLogin();
        logger.info("Clicking in From Dropdown field");
        erailHomePage.clickFromField();
        logger.info("Clearing the data From Dropdown field");
        erailHomePage.clearFromField();
        logger.info("Entering the data in From Dropdown field");
        erailHomePage.insertDataInFromField();
        logger.info("Selecting the value form the dropdown");
        List<WebElement> fromDropdownOptions = DriverManagerTL.getDriver1().findElements(ErailHomePage.fromDropdownList);
        List<String> fromDropdownData = new ArrayList<>();
        boolean isOptionFound = false;
        for (WebElement fromDropdown : fromDropdownOptions) {
            String optionText = fromDropdown.getText();
            fromDropdownData.add(optionText);// Adding the data in the dropdown list
            //System.out.println(optionText); // Print each option for debugging
            if (fromDropdown.getText().equals("Delhi Azadpur" + "\n" + "DAZ")) {
                fromDropdown.click(); // Click the desired option
                System.out.println("Selected: " + optionText);
                isOptionFound = true;
                break; // Exit the loop once the desired option is clicked
            }
        }
        // Handle the case where the option was not found
        if (!isOptionFound) {
            System.out.println("Option not found in the dropdown.");
        }

        String excelFilePath = "src/main/resources/stations.xlsx";
        ExcelUtility.writeToExcel(excelFilePath, "Stations", fromDropdownData);

        // Read expected station names from another Excel file
        List<String> expectedStations = ExcelUtility.readFromExcel("src/main/resources/ExpectedStations.xlsx", "Expected");
        if (expectedStations.equals(fromDropdownData)) {
            Assert.assertTrue(fromDropdownData.equals(expectedStations), "Dropdown data does not match expected stations!");
        }
        System.out.println("Option found matched in the excel sheet");
    }
}