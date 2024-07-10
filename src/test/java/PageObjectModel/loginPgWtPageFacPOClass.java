package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class loginPgWtPageFacPOClass {

    //Page Object Class Without PageFactory
    //Constructor
    //Locators
    //Actions

    WebDriver driver;
    //Constructor
    loginPgWtPageFacPOClass(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);//Mandatory required 2
    }
    //Locators
    @FindBy(xpath = "//input[@name='username']")
    //@FindBy(how= How.XPATH, using = "//input[@name='username']") Another approach of locators
    WebElement UserNameloc;
    @FindBy(xpath = "//input[@name='password']")
    WebElement PassLoc;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement ButtonLoc;

    //Group of Elements
    @FindBy(tagName = "a")
    List<WebElement>links;

    //Actions
   public void setUserName(String userName){
       UserNameloc.sendKeys(userName);
    }
    public void setUserPass(String userPass){
       PassLoc.sendKeys(userPass);
    }
    public void clickLogin(){
        UserNameloc.click();
    }



}
