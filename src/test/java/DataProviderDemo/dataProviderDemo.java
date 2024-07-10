package DataProviderDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class dataProviderDemo {

    WebDriver driver;
    @BeforeClass
    void setUp(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test(dataProvider = "dp")
    void logIn(String email, String pwd){

        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        boolean status=driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();

        if(status==true){
            driver.findElement(By.xpath("//a[@class='list-group-item' and normalize-space()='Logout']")).click();
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }

    }

    @AfterClass
    void closeWind(){
        driver.close();
    }

    //To implement selective data, we can use indices parameters based on index
    @DataProvider(name="dp", indices = {0, 3})
    Object [][] loginData() {
        Object data[][] = {
                {"abc@gmail.com", "test123"},
                {"xyz@gmail.com", "test5432"},
                {"david@gmail.com", "dav123"},
                {"sohail.fazli2016@gmail.com", "sohail@12345"},
                {"ahmad@gmail.com", "ahmad1234"}
                };

        return data;
    }
}
