package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OriginalCapsuleDetailPage extends BasePage{
    @FindBy(className = "AddToBagButtonLarge__label")
    private WebElement productAddToCart;

    @FindBy(id = "ta-quantity-selector__custom-field")
    private WebElement quantityField;

    @FindBy(id = "ta-quantity-selector__custom-ok")
    private WebElement confirm;
    @FindBy(className = "ProductDetails__name")
    private WebElement capsuleName;

    public OriginalCapsuleDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addProductBy(int quantity) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(productAddToCart));
        productAddToCart.click();
        quantityField.sendKeys(String.valueOf(quantity));
        confirm.click();
    }
    public String getCapsuleName(){
        return capsuleName.getText();
    }
}
