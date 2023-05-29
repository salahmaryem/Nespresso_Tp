package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CapsuleDetailPage extends BasePage{

    @FindBy(id = "ta-product-details__add-to-bag-button")
    private WebElement addToBasketButton;

    @FindBy(xpath = ".//button/span[contains(@class,'notranslate') and text() = '10']")
    private WebElement productQuantity;


    public CapsuleDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public String addToCart(){
        waitElement(driver,20,addToBasketButton);
        addToBasketButton.click();
        String Quantity = productQuantity.getText();
        productQuantity.click();
        try {
            Thread.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }return Quantity;
    }
}
