package SeleniumSession1;

import org.testng.IInvokedMethodListener;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener implements ITestListener
{

	@Override
	public void onFinish(ITestContext arg0)
	{
		// TODO Auto-generated method stub
		Reporter.log("OnFinish: Completed executing Test" + arg0.getName(), true);
	}

	@Override
	public void onStart(ITestContext arg0)
	{
		// TODO Auto-generated method stub
		Reporter.log("OnStart: About to start executing Test" + arg0.getName(), true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult arg0)
	{
		// TODO Auto-generated method stub
		printTestResults(arg0);
	}

	@Override
	public void onTestSkipped(ITestResult arg0)
	{
		// TODO Auto-generated method stub
		printTestResults(arg0);
	}

	@Override
	public void onTestStart(ITestResult arg0)
	{
		// TODO Auto-generated method stub
		Reporter.log("OnTestStart: Test Execution started " + arg0.getName(), true);
	}

	@Override
	public void onTestSuccess(ITestResult arg0)
	{
		// TODO Auto-generated method stub
		printTestResults(arg0);
	}

	private void printTestResults(ITestResult result)
	{

		Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);

		if (result.getParameters().length != 0)
		{
			String params = null;

			for (Object parameter : result.getParameters())
			{
				params += parameter.toString() + ",";
			}
			Reporter.log("Test Method had the following parameters : " + params, true);
		}

		String status = null;
		switch (result.getStatus())
		{
		case ITestResult.SUCCESS:
			status = "Pass";
			break;
		case ITestResult.FAILURE:
			status = "Failed";
			break;
		case ITestResult.SKIP:
			status = "Skipped";
		}
		Reporter.log("Test Status: " + status, true);
	}
}
