package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MachineDetailPage extends BasePage{
    @FindBy(id = "ta-product-details__add-to-bag-button")
    private WebElement productAddToCart;

    @FindBy(id = "ta-quantity-selector__custom-field")
    private WebElement quantityField;

    @FindBy(id = "ta-quantity-selector__custom-ok")
    private WebElement confirm;
    @FindBy(className = "ProductDetails__specs")
    private WebElement machineName;
    public MachineDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public void addProductByQuantity(int quantity){
        waitElement(driver,20,productAddToCart);
        productAddToCart.click();
        quantityField.sendKeys(String.valueOf(quantity));
        confirm.click();
    }
    public String getMachineName(){
       return machineName.getText();
    }

}
