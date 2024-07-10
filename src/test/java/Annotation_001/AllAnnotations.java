package Annotation_001;

import org.testng.annotations.*;

public class AllAnnotations {

    @BeforeSuite
    void beforeSuite(){
        System.out.println("Before suite....");
    }
    @AfterSuite
    void afterSuite(){
        System.out.println("After suite......");
    }
    @BeforeTest
    void beforeTest(){
        System.out.println("Before test.......");
    }
    @AfterTest
    void afterTest(){
        System.out.println("After test........");
    }
    @BeforeClass
    void beforeClass()
    {
        System.out.println("Before class.....");
    }
    @AfterClass
    void afterClass(){
        System.out.println("After class......");
    }
    @BeforeMethod
    void beforeMethod(){
        System.out.println("Before method......");
    }
    @AfterMethod
    void afterMethod(){
        System.out.println("After method.....");
    }
    @Test(priority = 1)
    void logIn(){
        System.out.println("Login to the site");
    }
    @Test(priority = 2)
    void logOut(){
        System.out.println("Logout from the site");
    }
}
