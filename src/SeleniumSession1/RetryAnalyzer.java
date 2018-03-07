package SeleniumSession1;

// Overriding the IRetrynalyzer for re-executing the failed tests 

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer
{
	int counter = 0;
	int retrylimit = 2;
	

	@Override
	public boolean retry(ITestResult arg0)
	{
		// TODO Auto-generated method stub
		if (counter < retrylimit)
		{
			counter ++;
			return true;
		}
		return false;
	}

}
