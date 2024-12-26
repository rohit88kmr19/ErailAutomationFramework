package erailOrange.com.pages.PageObjectmodel;

import erailOrange.com.base.ErailMethods;
import erailOrange.com.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ErailHomePage extends ErailMethods {

    WebDriver driver;
    public ErailHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Page Locator Erail Home Page

    public static By fromDropdownList = By.xpath("//div[@class='autocomplete-w1'][1]//div[@class='autocomplete']/div");
    public static By toDropdownList = By.cssSelector("div.autocomplete-w1>div.autocomplete>div[title*='Vi']");
    private By fromField = By.xpath("//tbody/tr/td/input[@id='txtStationFrom']");
    private By toField = By.xpath("//tbody/tr/td/input[@id='txtStationTo']");
    private By sortOnDate = By.xpath("//input[@title='Select Departure date for availability']");
    public By dateElement = By.xpath("//td[@onclick='DoDateSelect(1745001000000)']");
    private static By reserveQuota = By.xpath("//select[@id='cmbQuota']");
    public By classFilter = By.xpath("//select[@id='selectClassFilter']");
    public static By getTrainsButton=By.xpath("//input[@id=\"buttonFromTo\"]");

    // Page Actions Erail Home Page

    public void clickFromField() {
        driver.findElement(fromField).click();
    }

    public void clearFromField() {
        driver.findElement(fromField).clear();
    }

    public void insertDataInFromField() {
        driver.findElement(fromField).sendKeys("DEL");
    }

    public void clickToField() {
        driver.findElement(toField).click();
    }

    public void clearToField() {
        driver.findElement(toField).clear();
    }

    public void insertDataToField() {
        driver.findElement(toField).sendKeys("Vi");
    }

    public void ErailLogin() {
        driver.get(PropertyReader.readKey("eurl"));
    }

    public void sortDateField() {
        driver.findElement(sortOnDate).click();
    }

    public WebElement dateSelect() {
        return driver.findElement(dateElement);
    }

    public WebElement reservationQuota() {
        return driver.findElement(reserveQuota);
    }

    public WebElement classFilterDropdown() {
        return driver.findElement(classFilter);
    }

    public void getTrainsClick()
    {
        driver.findElement(getTrainsButton).click();
    }
}
