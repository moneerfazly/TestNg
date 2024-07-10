package AlertsTest;

import org.testng.annotations.Test;

public class AcctClass {

    @Test(priority = 1)
    void acctRegistration(){
        System.out.println("Register an account");
    }
    @Test(priority = 2)
    void logIn(){
        System.out.println("Login into your account");
    }
    @Test(priority = 3)
    void addFund(){
        System.out.println("Add fund into your account to avoid account deactivation");
    }
}
