package AlertsTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandleAertsTest {

    WebDriver driver;

    @Test(priority = 1)
    void openSite(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.manage().window().maximize();
    }
    @Test(priority = 2)
    void handleAlert(){
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Alert windowAlert=driver.switchTo().alert();
        System.out.println(windowAlert.getText());
        windowAlert.accept();
    }
    @Test(priority = 3)
    void closeWind() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();

    }
}
