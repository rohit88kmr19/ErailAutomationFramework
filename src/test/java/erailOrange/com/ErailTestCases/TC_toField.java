package erailOrange.com.ErailTestCases;

import erailOrange.com.base.CommonToAllTests;
import erailOrange.com.pages.PageObjectmodel.ErailHomePage;
import erailOrange.com.utils.ExcelUtility;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static erailOrange.com.driver.DriverManagerTL.getDriver1;

public class TC_toField extends CommonToAllTests {

    private static final Logger logger = LogManager.getLogger(TC_toField.class);

    @Description("Verifying that the Erail Home Page is Opened Successfully and User is able to Select the value from To field")
    @Test(dataProvider = "", dataProviderClass = ExcelUtility.class)
    public static void toField() {

        logger.info("Starting the TC and navigating on the Home Page to select the Value from the To field dropwdown");
        ErailHomePage erailHomePage = new ErailHomePage(getDriver1());
        erailHomePage.ErailLogin();
        logger.info("Clicking in From Dropdown field");
        erailHomePage.clickToField();
        logger.info("Clearing the data From Dropdown field");
        erailHomePage.clearToField();
        logger.info("Entering the data in From Dropdown field");
        erailHomePage.insertDataToField();
        logger.info("Selecting the value from the to dropdown");
        List<WebElement> toDropdownOptions = getDriver1().findElements(ErailHomePage.toDropdownList);
        List<String> toDropdownData = new ArrayList<>();
        boolean isOptionFound = false;
        for (WebElement toDropdown : toDropdownOptions) {
            String optionText = toDropdown.getText();
            toDropdownData.add(optionText);// Adding the data in the dropdown list
            //System.out.println(optionText); // Print each option for debugging
            if (toDropdown.getText().equals("Vijayawada Jn" + "\n" + "BZA")) {
                toDropdown.click(); // Click the desired option
                System.out.println("Selected: " + optionText);
                isOptionFound = true;
                break; // Exit the loop once the desired option is clicked
            }
        }
        // Handle the case where the option was not found
        if (!isOptionFound) {
            System.out.println("Option not found in the dropdown.");
        }
    }


        //We can write this in the future to read and write the data into and from the excel!!
//        String excelFilePath = "src/main/resources/stations.xlsx";
//        ExcelUtility.writeToExcel(excelFilePath, "Stations", toDropdownOption.todropdownSelection());
//        logger.info("Dropdown data written to Excel path");
//
//        // Read expected station names from another Excel file
//        List<String> expectedStations = ExcelUtility.readFromExcel("src/main/resources/ExpectedStations.xlsx", "Expected");
//        if (expectedStations.equals(toDropdownOption.todropdownSelection())) {
//            Assert.assertTrue(toDropdownOption.todropdownSelection().equals(expectedStations), "Dropdown data does not match expected stations!");
//        }
//        System.out.println("Option found matched in the excel sheet");
    }