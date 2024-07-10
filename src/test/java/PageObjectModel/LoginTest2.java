package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest2 {

    WebDriver driver;
    @BeforeClass
    void setUp(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test
    void testLogin(){
        loginPgWtPageFacPOClass lp=new loginPgWtPageFacPOClass(driver);
        lp.setUserName("Admin");
        lp.setUserPass("admin123");
        lp.clickLogin();

        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }

    @AfterClass
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
    driver.close();
    }
}
