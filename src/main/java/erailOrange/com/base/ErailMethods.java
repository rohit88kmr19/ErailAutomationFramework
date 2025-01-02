package erailOrange.com.base;

import erailOrange.com.utils.PropertyReader;

import static erailOrange.com.driver.DriverManagerTL.getDriver1;


public class ErailMethods {

    public void openErailURL() {
        getDriver1().get(PropertyReader.readKey("eurl"));
    }


}
