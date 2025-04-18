package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance(String strTestName) {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("Report/"+strTestName+".html");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Gaurav Manral");
        }
        return extent;
    }
}
