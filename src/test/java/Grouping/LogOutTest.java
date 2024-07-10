package Grouping;

import org.testng.annotations.Test;

public class LogOutTest {

    @Test(priority = 1, groups = {"regression"})
    public void logOutEmail(){
        System.out.println("Logout from email");
    }
    @Test(priority = 2, groups = {"regression"})
    public void logOutFaceBook(){
        System.out.println("Logout from facebook");
    }
    @Test(priority = 3, groups = {"regression"})
    public void logOutTwitter(){
        System.out.println("Logout from twitter");
    }
}
