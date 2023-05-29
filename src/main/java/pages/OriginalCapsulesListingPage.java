package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OriginalCapsulesListingPage extends BasePage{

    public OriginalCapsulesListingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = ".//a[@alt='Jamaica Blue Mountain product URL']")
    private WebElement productChosen;

    public void clickOnCapsuleBy(String name){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//h3[contains(.,'" + name + "')]"))));
        driver.findElement(By.xpath("//h3[contains(.,'" + name + "')]")).click();
    }

    public void clickOnProduct(){
        waitElement(driver,20,productChosen);
        productChosen.click();
        handleCookiePopup();
    }
}
