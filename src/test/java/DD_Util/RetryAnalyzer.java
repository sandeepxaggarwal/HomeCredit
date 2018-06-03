package DD_Util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer
{
   int counter=0;
   int maxRetryCount=5;
   public boolean retry(ITestResult result)
   {
      // TODO Auto-generated method stub
      return false;
   }
   
   /*public boolean retry(ITestResult arg0)
   {
      if(counter<maxRetryCount){
         counter++;
         return true;
      }
      return false;
   }*/

}
