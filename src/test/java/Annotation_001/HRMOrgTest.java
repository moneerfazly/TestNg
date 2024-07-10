package Annotation_001;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class HRMOrgTest {

    WebDriver driver;


    @Test(priority = 1)
    void openApp() throws InterruptedException {

        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test(priority = 2)

    void LogoPresence(){

        WebElement logoDisplay =driver.findElement(By.xpath("//img[@alt='company-branding']"));

        if(logoDisplay.isDisplayed()){
            System.out.println("Logo is displayed...");
        }else{
            System.out.println("Logo is not displayed...");
        }
    }

    @Test(priority = 3)

    void logIn() throws InterruptedException {

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 4)

    void logOut() throws InterruptedException {

        driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 5)

    void closeWind(){
        driver.close();
    }

}
