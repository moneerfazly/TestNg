package Parametarization;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethod {

    @Test(priority = 1)
    void openApp(){
        Assert.assertTrue(true);
    }
    @Test(priority = 2, dependsOnMethods={"openApp"})
    void logIn(){
        Assert.assertTrue(true);
    }
    @Test(priority = 3, dependsOnMethods ={"logIn"})
    void search(){
        Assert.assertTrue(true);
    }
    @Test(priority = 4, dependsOnMethods = {"logIn", "search"})
    void advSearch(){
        Assert.assertTrue(false);
    }
    @Test(priority = 5, dependsOnMethods = {"logIn", "advSearch"})
    void closeApp(){
        Assert.assertTrue(true);
    }
}
