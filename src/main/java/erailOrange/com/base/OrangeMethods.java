package erailOrange.com.base;

import erailOrange.com.utils.PropertyReader;

import static erailOrange.com.driver.DriverManager.getDriver;

public class OrangeMethods {


    public void openOrangeURL() {
        getDriver().get(PropertyReader.readKey("Orange_url"));
    }


}
