package tests;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.*;
import utilities.PropertyReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BaseCloud {
    public static String userName;
    public static String accessKey;
    public static String URL;
    public WebDriver driver;
    public BasePage basePage;
    public HomePage homePage;
    public OriginalCapsulesListingPage capsuleOriginal;
    public CapsuleDetailPage capsuleDetailPage;
    public Cart cart;
    public LoginPage login;
    public MachineDetailPage machinesVertuo;
    public OriginalCapsuleDetailPage originalCapsuleDetailPage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        PropertyReader propertyReader = new PropertyReader("src/main/resources/config.properties");
        userName = propertyReader.getProperty("userName");
        accessKey = propertyReader.getProperty("accessKey");

        URL = constructURL(userName, accessKey);

        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("os", "Windows");
        browserstackOptions.put("osVersion", "10");
        browserstackOptions.put("browserVersion", "latest");
        browserstackOptions.put("local", "false");
        browserstackOptions.put("seleniumVersion", "3.141.59");
        capabilities.setCapability("bstack:options", browserstackOptions);

        WebDriver driver = new RemoteWebDriver(new URL(URL), capabilities);
        driver.manage().window().maximize();
        driver.get("https://www.nespresso.com/fr/fr");
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        capsuleOriginal = new OriginalCapsulesListingPage(driver);
        capsuleDetailPage = new CapsuleDetailPage(driver);
        cart=new Cart(driver);
        login=new LoginPage(driver);
        machinesVertuo = new MachineDetailPage(driver);
        originalCapsuleDetailPage = new OriginalCapsuleDetailPage(driver);
    }

    private String constructURL(String userName, String accessKey) {
        return "https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

