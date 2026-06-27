package listeners;


import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("Test Failed: " + result.getName());

        String path = ScreenshotUtil.captureScreenshot(result.getName());

        System.out.println("Screenshot saved at: " + path);
    }
}