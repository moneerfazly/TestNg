package WebTableTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class StaticWebTableTest {

    WebDriver driver;

    @Test(priority = 1)
    void openWeb(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
    }
    @Test(priority = 2)
    void numRow(){
       int numRow= driver.findElements(By.xpath("//Table[@name='BookTable']//tbody//tr")).size();
        System.out.println("Number of row: "+numRow);
    }
    @Test(priority = 3)
    void numCol(){
        int numCol=driver.findElements(By.xpath("//Table[@name='BookTable']//tbody//tr//td")).size();
        System.out.println("Number of colum: "+numCol);
    }
    @Test(priority = 4)
    void webTableData(){
        List<WebElement> webTabData=driver.findElements(By.xpath("//Table[@name='BookTable']//tbody//tr//td"));

        for(int i=0; i<webTabData.size(); i++){
         String dataTable =webTabData.get(i).getText();
            System.out.print(dataTable);
            System.out.println();

        }
    }

    @Test(priority = 5)
    void closeWind(){
        driver.close();
    }

    }


