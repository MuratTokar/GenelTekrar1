package day_025_Scenario_Example.demoblazetsts.base;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        Basee.ScreenShort("Demo" + result.getTestName());

    }
}
