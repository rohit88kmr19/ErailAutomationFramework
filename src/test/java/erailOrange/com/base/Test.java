package erailOrange.com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();


//
//        private By username = By.xpath("//input[@name=\"username\"]");
//        private By password = By.xpath("//input[@name=\"password\"]");
//        private By login = By.cssSelector("button.orangehrm-login-button");
//        private  By errorMessage= By.xpath("//div[@class=\"oxd-alert-content oxd-alert-content--error\"]/p");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();

        Assert.assertEquals(driver.getTitle(),"OrangeHRM");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        WebElement icon=driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(icon).click().build().perform();
        Thread.sleep(2000);
        WebElement logout = driver.findElement(By.xpath("//ul[@class=\"oxd-dropdown-menu\"]/li[4]/a"));
        logout.click();

    }
}