package erailOrange.com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Objects;

public class DriverManagerTL {

    public static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();


    public static void setDriver(WebDriver driverRef) {
        dr.set(driverRef);
    }

    public static WebDriver getDriver1() {
        return dr.get();
    }

    // Unload
    public static void unload() {
        dr.remove();
    }

    public static void down() {
        if (Objects.nonNull(DriverManagerTL.getDriver1())) {
            getDriver1().quit();
            unload();
        }
    }

    public static void init1()  {
        if (Objects.isNull(DriverManagerTL.getDriver1())) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--guest");
            options.addArguments("--start-maximized");
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(options);
            setDriver(driver);
        }
    }
}
