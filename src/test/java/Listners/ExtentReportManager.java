package Listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;// UI of the report
    public ExtentReports extent; //populate common info on the report
    public ExtentTest test; // creating test case entries in the report and update status of the test methods

    public void onStart(ITestContext context) {

        sparkReporter =new ExtentSparkReporter("/Users/macbook/eclipse-workspace/TestNG-Project/src/test/java/AllReports/HRMOrgReport.html");

        sparkReporter.config().setDocumentTitle("Automation Report");//Title of report
        sparkReporter.config().setReportName("Functional Testing");// Name of the report
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent=new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Laptop Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester Name", "Moneer");
        extent.setSystemInfo("ISO", "MacBook Pro");
        extent.setSystemInfo("Browser name", "Chrome");
    }
    public void onTestSuccess(ITestResult result) {

        test= extent.createTest(result.getName());//create a new entry in the report
        test.log(Status.PASS, "Test case PASSED is:"+result.getName()); // update status p/f/s
    }

    public void onTestFailure(ITestResult result) {

        test=extent.createTest(result.getName());
        test.log(Status.FAIL, "Test cae FAILED is: "+result.getName());
        test.log(Status.FAIL, "Test case FAILED cause is: "+result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {

        test=extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case SKIPPED is: "+result.getName());
    }

    public void onFinish(ITestContext context) {

        extent.flush();
    }

}
