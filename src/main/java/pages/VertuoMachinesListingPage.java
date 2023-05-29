package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VertuoMachinesListingPage extends BasePage{
    @FindBy(xpath = "//a[contains(.,'Vertuo Next')]")
    private WebElement productChosen;

    public VertuoMachinesListingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public void clickOnMachineBy(String name){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(.,'" + name + "')]"))));
        driver.findElement(By.xpath("//a[contains(.,'" + name + "')]")).click();
    }
    public void clickOnProduct(){
        waitElement(driver,20,productChosen);
        productChosen.click();
        handleCookiePopup();
    }
}
