package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class CloudAddProductToCart extends BaseCloud{
    @Test
    public void addAndVerify(){
        //Steps
        basePage.handleCookiePopup();
        homePage.navigateToOriginalCapsules();
        capsuleOriginal.clickOnProduct();
        String expected=capsuleDetailPage.addToCart();
        System.out.println(expected);
        cart.openAndCheckCart();
        String result = cart.getJamaicaBlueQuantity();
        System.out.println(result);
        cart.validateBasket();
        login.getLoginPageURL();
        //Assertions
        assertTrue(login.getLoginPageURL().contains("secure/login?destination-redirect"));
        Assert.assertTrue(result.contains(expected));
    }
}
