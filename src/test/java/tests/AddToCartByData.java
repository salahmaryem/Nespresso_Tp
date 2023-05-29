package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DataUtil;
import java.util.List;

public class AddToCartByData extends DataUtil {
    private By capsulesListingPage = By.xpath("//*[@class='ProductCard__footer']/h3");
    private By MachinesVertuoListingPage = By.xpath("//*/a[@class='AccessibleLink ProductListElement__link track-product-click']");

    @Test(dataProvider = "data")
    public void addToCartBasedOnData(String type,String name, int quantity){
        //Choose the type of product to apply certain code
        if(type.equals("machine")){
            basePage.handleCookiePopup();
            homePage.navigateToVertuoMachines();
            List<WebElement> productLists = driver.findElements(MachinesVertuoListingPage);
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
            Assert.assertTrue(actualProductName.contains(name),"Product name not found in cart");
            System.out.println("Name verification passed");
                //Checking the quantity
           String actualQuantity= cart.getProductQuantity();
                Assert.assertTrue(actualQuantity.contains(String.valueOf(quantity)));
            System.out.println("Quantity Verification passed");
            cart.closeCart();
        }else if (type.equals("capsule")) {
            System.out.println(name);
            homePage.navigateToOriginalCapsules();
            List<WebElement> capsulesList = driver.findElements(capsulesListingPage);
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
            cart.openAndCheckCart();
        }

    }

}
