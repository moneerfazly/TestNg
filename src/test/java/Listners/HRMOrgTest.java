package Listners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class HRMOrgTest {

    WebDriver driver;
    @BeforeClass
    void setUP(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    void logoDisplay(){
        boolean logoIsdisplayed=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
        Assert.assertEquals(logoIsdisplayed, true);
    }
    @Test(priority = 2)
    void titleValidation(){
        Assert.assertEquals(driver.getTitle(), "HRMOrg");
    }
    @Test(priority = 3, dependsOnMethods = "titleValidation")
    void url(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @AfterClass
    void tearDown(){
        driver.close();
    }
}
