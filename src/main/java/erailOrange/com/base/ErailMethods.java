package erailOrange.com.base;

import erailOrange.com.utils.PropertyReader;

import static erailOrange.com.driver.DriverManager.getDriver;


public class ErailMethods {

    public void openErailURL() {
        getDriver().get(PropertyReader.readKey("eurl"));
    }


}
