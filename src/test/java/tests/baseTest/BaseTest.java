package tests.baseTest;

import com.gurock.testrail.APIException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import testRailManager.TestRailManager;

import java.io.IOException;
import java.time.Duration;

public abstract class BaseTest {

    public String testCaseID;
    public WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws APIException, IOException {
        if(result.getStatus()==ITestResult.SUCCESS)
        {
            TestRailManager.addTestCaseResult(testCaseID,TestRailManager.TEST_CASE_PASS,"");
        } else if (result.getStatus()==ITestResult.FAILURE)
        {
            TestRailManager.addTestCaseResult(testCaseID,TestRailManager.TEST_CASE_FAIL," Test " + result.getTestName() + " is failed");
        }

        driver.close();

    }

}
