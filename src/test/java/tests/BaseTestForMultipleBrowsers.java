package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.*;

public class BaseTestForMultipleBrowsers {
    public WebDriver driver;
    public BasePage basePage;
    public HomePage homePage;
    public MachineDetailPage machinesVertuo;
    public Cart cart;
    public OriginalCapsuleDetailPage originalCapsuleDetailPage;
    public ExtentReports extent;
    public ExtentTest test;
    public String browser;
    public By mainMenuCapsule= By.xpath("//*[contains(text(),'Café') and @class='HeaderNavigationBarItem__title']");

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        this.browser = browser;
        //Initializing ExtentHtmlReporter
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent_" + browser + ".html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        if (browser.equalsIgnoreCase("chrome")) {
            // Set up Chrome WebDriver
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            // Set up Firefox WebDriver
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.get("https://www.nespresso.com/fr/fr");
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        machinesVertuo = new MachineDetailPage(driver);
        originalCapsuleDetailPage = new OriginalCapsuleDetailPage(driver);
        cart=new Cart(driver);
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
        extent.flush();
    }

}
