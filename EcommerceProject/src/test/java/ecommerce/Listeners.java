package ecommerce;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.UtilitiesFunction;

public class Listeners extends UtilitiesFunction implements ITestListener {
	ExtentReports extentObj;
	ExtentTest testObj;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		extentObj = reportObject();
		testObj = extentObj.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		testObj.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		// Screenshot Code
		testObj.fail(result.getThrowable());
		String nameOfMethod = result.getMethod().getMethodName();
		try {
			testObj.addScreenCaptureFromPath(takeScreenshot(nameOfMethod, driverObject), nameOfMethod);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentObj.flush();
	}

}
