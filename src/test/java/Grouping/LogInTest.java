package Grouping;

import org.testng.annotations.Test;

public class LogInTest {

    @Test(priority = 1, groups = {"sanity"})
    public void logInEmail(){
        System.out.println("Login to email");
    }
    @Test(priority = 2, groups = {"sanity"})
    public void logInFaceBook(){
        System.out.println("Login to facebook");
    }
    @Test(priority = 3, groups = {"sanity"})
    public void logInTwitter(){
        System.out.println("Login to twitter");
    }
}
