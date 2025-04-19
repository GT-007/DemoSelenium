package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports summaryReport;
    private static ExtentReports detailedReport;
    
    public static ExtentReports fun_getSummaryReportInstance(String strSummaryReportName, String strBrowserType) {
        if (summaryReport == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("Report/"+strSummaryReportName+".html");
            summaryReport = new ExtentReports();
            summaryReport.attachReporter(reporter);
            summaryReport.setSystemInfo("Tester", "Gaurav Manral & Rachin Kumar");
            summaryReport.setSystemInfo("Browser Type", strBrowserType);
            summaryReport.setSystemInfo("Project","Demo Selenium");
        }
        return summaryReport;
    }
 
    public static ExtentReports fun_getIndividualReportInstance(String strTestReportName) {
        ExtentSparkReporter reporter = new ExtentSparkReporter("Report/TestCaseReports/"+strTestReportName+".html");
        detailedReport = new ExtentReports();
        detailedReport.attachReporter(reporter);

        return detailedReport;
    }
}
