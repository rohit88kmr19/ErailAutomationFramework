package erailOrange.com.base;

import erailOrange.com.driver.DriverManagerTL;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTests {

    @BeforeMethod
    public void setUp(){
        DriverManagerTL.init1();
    }

    // Who will close the Webdriver
    @AfterMethod
    public void tearDown(){
        DriverManagerTL.down();
    }



}
