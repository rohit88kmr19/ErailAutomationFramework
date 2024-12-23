package erailOrange.com.ErailTestCases;

import erailOrange.com.base.CommonToAllTests;
import erailOrange.com.driver.DriverManager;
import erailOrange.com.pages.PageObjectmodel.ErailHomePage;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class TC_classFilterDropdown extends CommonToAllTests {

        private static final Logger logger = LogManager.getLogger(TC_classFilterDropdown.class);

        @Description("Verifying that the Erail Home Page is Opened Successfully and User is able to select the class from dropdown")
        @Test
        public static void classFilterDropdown () {
            logger.info("Starting the TC and navigating on the Home Page");
            ErailHomePage erailHomePage = new ErailHomePage(DriverManager.getDriver());
            erailHomePage.ErailLogin();
            Select select = new Select(erailHomePage.classFilterDropdown());
            List<WebElement> options = select.getOptions();
            for (int i = 0; i < options.size(); i++) {
                WebElement reseOpt = options.get(i);
                System.out.println("The option text are--->" + (i + 1) + ":" + reseOpt.getText());
                select.selectByIndex(2);
            }
            WebElement selectedOption = select.getFirstSelectedOption();
            logger.info("The selected option for the Class Filter  is mentioned below:");
            System.out.println(selectedOption.getText());

        }


    }
