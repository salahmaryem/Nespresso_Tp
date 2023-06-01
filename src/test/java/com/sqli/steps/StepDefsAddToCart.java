package com.sqli.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.*;

public class StepDefsAddToCart {
    public WebDriver driver;
    public HomePage homePage;
    private VertuoMachinesListingPage vertuoMachinesListingPage;
    private OriginalCapsulesListingPage originalCapsulesListingPage;
    private MachineDetailPage machineDetailPage;
    private OriginalCapsuleDetailPage originalCapsuleDetailPage;
    private Cart cart;
    String machineName;
    String capsuleName;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.nespresso.com/fr/fr");
    }
    @Given("The User is on the nespresso homePage site")
    public void the_user_is_on_the_nespresso_home_page_site() {
        homePage = new HomePage(driver);
        vertuoMachinesListingPage = new VertuoMachinesListingPage(driver);
        originalCapsulesListingPage = new OriginalCapsulesListingPage(driver);
        machineDetailPage = new MachineDetailPage(driver);
        originalCapsuleDetailPage = new OriginalCapsuleDetailPage(driver);
        cart = new Cart(driver);
        homePage.handleCookiePopup();
    }

    @And("The User clicks on the machineVertuo menu item")
    public void theUserClicksOnTheTypeMenuItem() {
        homePage.navigateToVertuoMachines();
    }

    @And("^The User clicks on a machine named (.+)$")
    public void the_user_clicks_on_a_machine_named(String productName) {
        vertuoMachinesListingPage.clickOnMachineBy(productName);
        homePage.handleCookiePopup();
    }

    @And("^The User adds the machine to the cart with (.+)$")
    public void the_user_adds_the_machine_to_the_cart_with(int quantity) {
        machineDetailPage.addProductByQuantity(quantity);
        machineName = machineDetailPage.getMachineName();
        cart.openAndCheckCart();
        cart.closeCart();
    }

    @And("The User clicks on the capsule menu item")
    public void theUserClicksOnTheCapsuleMenuItem() {
        homePage.navigateToOriginalCapsules();
    }

    @And("^The User clicks on a capsule named (.+)$")
    public void the_user_clicks_on_a_capsule_named(String productName) {
        originalCapsulesListingPage.clickOnCapsuleBy(productName);
        homePage.handleCookiePopup();
    }

    @And("^The User adds the capsule to the cart with (.+)$")
    public void the_user_adds_the_capsule_to_the_cart_with(int quantity) {
        originalCapsuleDetailPage.addProductBy(quantity);
        capsuleName=originalCapsuleDetailPage.getCapsuleName();
    }
    @When("The user opens the cart")
    public void theUserOpensTheCart() {
        cart.openAndCheckCart();
    }
    @Then("The the cart should display the machine and capsules and verify their quantities (.+) (.+)$")
    public void theTheCartShouldDisplayTheMachineAndCapsulesAndVerifyTheirQuantitiesQuantityQuantity(Integer quantity1, Integer quantity2) {
        Assert.assertTrue(cart.getProductNameFromCart().contains(machineName));
        Assert.assertTrue(cart.getCapsuleNameFromCart().contains(capsuleName));
        String quantityVertuo = String.valueOf(quantity1);
        String quantityVenezia = String.valueOf(quantity2);
        Assert.assertTrue(cart.getVeneziaQuantity().contains(quantityVenezia));
        Assert.assertTrue(cart.getProductQuantity().contains(quantityVertuo));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}


