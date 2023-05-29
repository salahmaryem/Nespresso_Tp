package com.sqli.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class StepDefsAddToCartByType {
    public WebDriver driver;
    public HomePage homePage;
    private VertuoMachinesListingPage vertuoMachinesListingPage;
    private OriginalCapsulesListingPage originalCapsulesListingPage;
    private MachineDetailPage machineDetailPage;
    private OriginalCapsuleDetailPage originalCapsuleDetailPage;
    private Cart cart;
    String machineName;
    String capsuleName;

    @Given("The User is on the nespresso homePage site")
    public void the_user_is_on_the_nespresso_home_page_site() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.nespresso.com/fr/fr");
        homePage = new HomePage(driver);
        vertuoMachinesListingPage = new VertuoMachinesListingPage(driver);
        originalCapsulesListingPage = new OriginalCapsulesListingPage(driver);
        machineDetailPage = new MachineDetailPage(driver);
        originalCapsuleDetailPage = new OriginalCapsuleDetailPage(driver);
        cart = new Cart(driver);
        homePage.handleCookiePopup();
    }
    @And("The User clicks on a (.+) named (.+)$>")
    public void theUserClicksOnATypeNamedProductName(int arg0) {
    }

    @And("The User adds the <productType> to the cart with <quantity{int}>")
    public void theUserAddsTheProductTypeToTheCartWithQuantity(int arg0) {
    }

    @Then("The User should see the <productType> in the cart with quantity <quantity{int}>")
    public void theUserShouldSeeTheProductTypeInTheCartWithQuantityQuantity(int arg0) {
    }
}
