package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPagePOClass {

    //Page Object Class Without PageFactory
    //Constructor
    //Locators
    //Actions

    WebDriver driver;
    //Constructor
    LoginPagePOClass(WebDriver driver){
        this.driver=driver;
    }
    //Locators
    By UserNameloc=By.xpath("//input[@name='username']");
    By PassLoc=By.xpath("//input[@name='password']");
    By ButtonLoc=By.xpath(" //button[@type='submit']");

    //Actions
    public void setUserName(String userName){
        driver.findElement(UserNameloc).sendKeys(userName);
    }
    public void setUserPass(String userPass){
        driver.findElement(PassLoc).sendKeys(userPass);
    }
    public void clickLogin(){
        driver.findElement(ButtonLoc).click();
    }

}
