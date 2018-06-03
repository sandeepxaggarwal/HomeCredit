package DD_TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import DD_Core.Page;
import DD_Util.Commons;

public class LoginTest extends Page
{

   
   @BeforeTest
   public void isSkip()
   {
      if (!Commons.isExecutable("LoginTest"))
      {
         throw new SkipException("Skipping testcase as Run Mode is No");
      }
   }

   @Test(dataProvider = "getData")
   public void doLogin(String username, String password)
   {
      test = extent.startTest("Execution of doLogin Test");
      driver.get(Config.getProperty("testsiteurl"));
      driver.findElement(By.xpath(OR.getProperty("username"))).sendKeys(username);;
      driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys(password);;
      driver.findElement(By.xpath(OR.getProperty("login")));
      Assert.fail();
      

   }

   @AfterMethod
   public void afterTest(ITestResult result) throws IOException
   {
      if (ITestResult.SUCCESS == result.getStatus())
      {
         test.log(LogStatus.PASS, "Test Case doLogin is passed");
      }
      else if (ITestResult.FAILURE == result.getStatus())
      {
         String methodname = result.getName();
         test.log(LogStatus.FAIL, "Test Case doLogin is failed" + test.addScreenCapture(Commons.captureScreenshot(methodname)));
         
      }
      extent.endTest(test);
   }

   @DataProvider
   public Object[][] getData()
   {

      return Commons.getData("LoginTest");

   }

}
