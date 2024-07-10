package Grouping;

import org.testng.annotations.Test;

public class PaymentTest {

    @Test(priority = 1, groups = {"sanity", "regression", "functional"})
    public void paymentRupees(){
        System.out.println("Payment in rupees");
    }
    @Test(priority = 2, groups = {"sanity", "regression", "functional"})
    public void paymentUSD(){
        System.out.println("Payment in USD");
    }

}
