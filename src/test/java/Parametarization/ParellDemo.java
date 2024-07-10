package Parametarization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Locale;

public class ParellDemo {

    WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    void setUp(String br) throws InterruptedException {

        switch (br.toLowerCase(Locale.ROOT)){
            case "chrome": driver=new ChromeDriver();break;
            case "firefox": driver=new FirefoxDriver(); break;
            case "safari": driver=new SafariDriver(); break;
            default:
                System.out.println("Invalid browser");return;
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(5000);

    }
    @Test(priority = 1)
    void testLogo(){

       boolean logoIsdisplayed= driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();

        Assert.assertEquals(logoIsdisplayed, true);
    }
    @Test(priority = 2)
    void testTitle(){

        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }
    @Test(priority = 3)
    void testUrl(){

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @AfterClass
    void tearDown(){
        driver.close();
    }
}
