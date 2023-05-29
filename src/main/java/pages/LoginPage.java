package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public String getLoginPageURL(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        WebElement pageLoad = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginContainer")));
        pageLoad.getText();
     return driver.getCurrentUrl();
    }
}
