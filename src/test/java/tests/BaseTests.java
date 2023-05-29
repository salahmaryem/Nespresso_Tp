package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import pages.*;;


public class BaseTests {
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
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.nespresso.com/fr/fr");
        //Instantiation of objects pages
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        capsuleOriginal = new OriginalCapsulesListingPage(driver);
        capsuleDetailPage = new CapsuleDetailPage(driver);
        cart=new Cart(driver);
        login=new LoginPage(driver);
        machinesVertuo = new MachineDetailPage(driver);
        originalCapsuleDetailPage = new OriginalCapsuleDetailPage(driver);
    }

    @AfterTest
    public void tearDown(){

        driver.quit();

    }
}
