package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart extends BasePage{

    @FindBy(id = "ta-mini-basket__open")
    private WebElement openCart;

    @FindBy(className = "MiniBasketDropdown__header__title")
    private WebElement cartTitle;

    @FindBy(id = "ta-mini-basket__checkout")
    private WebElement proceedToCheckout;

    @FindBy(xpath = "//td[contains(@class,'MiniBasketItem__title')]/span[contains(.,'Vertuo Next')]")
    private WebElement nameMachineVertuo;

    @FindBy(className = "MiniBasketItemCategory__item-count")
    private WebElement infoMachineVertuo;

    @FindBy(xpath = "//td/span[contains(.,'Venezia')]")
    private WebElement veneziaNameInCart;

    @FindBy(xpath = "//tr/th[@id ='capsules_original']/span")
    private WebElement capsuleOriginalQuantity;

    @FindBy(id = "ta-mini-basket__close")
    private WebElement closeCart;

    public Cart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public void openAndCheckCart(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        openCart.click();
        waitElement(driver,10,cartTitle);

    }
    public void validateBasket(){
        proceedToCheckout.click();
        handleCookiePopup();
    }

    public String getProductNameFromCart(){
        return nameMachineVertuo.getText();
    }
    public String getCapsuleNameFromCart(){
        return veneziaNameInCart.getText();
    }
    public String getProductQuantity(){
        return infoMachineVertuo.getText();
    }
    public String getVeneziaQuantity(){
      return capsuleOriginalQuantity.getText();
    }
    public String getJamaicaBlueQuantity(){
        return capsuleOriginalQuantity.getText();
    }
    public void closeCart(){
        waitElement(driver,5,closeCart);
        closeCart.click();
    }
}
