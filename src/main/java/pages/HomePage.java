package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    @FindBy(xpath = "//a[contains(@href,'capsules')]")
    private WebElement headerMenuCapsules;

    @FindBy(xpath = "//*[contains(@class,'links-item')]/a[contains(@href,'capsules/original')]")
    private WebElement subMenuCapsulesOriginal;

    @FindBy(xpath = "//a[contains(@href,'machines')]")
    private WebElement headerMenuMachines;

    @FindBy(xpath = "//*[contains(@class,'links-item')]/a[contains(@href,'machines/vertuo')]")
    private WebElement subMenuMachineVertuo;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void navigateToOriginalCapsules(){
        headerMenuCapsules.click();
        handleCookiePopup();
    }
    public void navigateToVertuoMachines(){
        Actions actions = new Actions(driver);
        actions.moveToElement(headerMenuMachines).perform();
        waitElement(driver,5,subMenuMachineVertuo);
        subMenuMachineVertuo.click();
        handleCookiePopup();
    }

}
