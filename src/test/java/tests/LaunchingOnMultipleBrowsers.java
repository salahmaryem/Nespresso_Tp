package tests;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utilities.DataMultipleBrowsers;

import java.util.List;

public class LaunchingOnMultipleBrowsers extends DataMultipleBrowsers {

    @Test(dataProvider = "dataUtil")
    public void testMethod(String type,String name, int quantity){
        System.out.println(driver.getTitle());
        // Create a new ExtentTest
        test = extent.createTest("Test Case: " + type + " - " + name);
        test.log(Status.INFO, "Browser: " + this.browser);
        test.log(Status.INFO, "URL: " + driver.getCurrentUrl());
        //Choose the type of product to apply certain code
        if(type.equals("machine")){
            //Logs
            test.log(Status.INFO, "Test Type: " + type);
            test.log(Status.INFO, "Product Name: " + name);
            test.log(Status.INFO, "Quantity: " + quantity);
            basePage.handleCookiePopup();
            homePage.navigateToVertuoMachines();
            List<WebElement> productLists = driver.findElements(By.xpath("//*/a[@class=\"AccessibleLink ProductListElement__link track-product-click\"]"));
            String elem;
            // Print the number of elements found to verify that the list is not empty
            System.out.println("Number of elements that represent a Vertuo Machine: " + productLists.size());
            for (WebElement elements : productLists) {
                elem = elements.getText();
                System.out.println(elem);
                if (elem.equals(name)){
                    elements.click();
                    break;
                }}
            basePage.handleCookiePopup();
            machinesVertuo.addProductByQuantity(quantity);
            cart.openAndCheckCart();
            //Assertions
            //Checking the name
            String actualProductName = cart.getProductNameFromCart().toUpperCase();
            try {
                if (actualProductName.contains(name)){
                    test.pass("Product name verification passed");
            }}catch(AssertionError e) {
                test.fail("Product name not found in cart"+e.getMessage());
            }
            //Checking the quantity
            String actualQuantity= cart.getProductQuantity();
            try {
                if (actualQuantity.contains(String.valueOf(quantity))) {
                    test.pass("Product quantity verification passed");
                }}catch(AssertionError e) {
                test.fail("Product quantity not found in cart"+e.getMessage());
            }
            cart.closeCart();
            return;
        }
         if (type.equals("capsule")) {
            System.out.println(name);
             WebDriverWait wait = new WebDriverWait(driver, 10);
             wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("Overlay__transition-exit-active")));
             WebElement element = driver.findElement(mainMenuCapsule);
             element.click();
             homePage.handleCookiePopup();
            List<WebElement> capsulesList = driver.findElements(By.xpath("//*[@class=\"ProductCard__footer\"]/h3"));
            String item;
            // Print the number of elements found to verify that the list is not empty
            System.out.println("List of items that represent Original Capsules : "+ capsulesList.size());
            for (WebElement items : capsulesList) {
                item = items.getText();
                System.out.println(item);
                if (item.equals(name)){
                    items.click();
                    break;
                }}
            basePage.handleCookiePopup();
             originalCapsuleDetailPage.addProductBy(quantity);
             cart.openAndCheckCart();;
        }

    }
}
