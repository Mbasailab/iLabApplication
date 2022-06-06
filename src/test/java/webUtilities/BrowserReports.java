package webUtilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import report.extentReport;

public class BrowserReports
{
    public extentReport rt = new extentReport();
    ExtentReports reports;
    ExtentTest node;

    public void createBrowserReport(String sBrowser)
    {
        switch (sBrowser.toUpperCase())
        {
            case "CHROME" -> {
                reports = rt.initilizeExtentReporters("reports/iLabReport "+sBrowser+".html");
                ExtentTest test = reports.createTest("iLab Vacancy Application Chrome").assignAuthor("Mbasa Gwama");
                node = test.createNode("iLAB application test");
            }
            case "FIREFOX" -> {
                reports = rt.initilizeExtentReporters("reports/iLabReport "+sBrowser+".html");
                ExtentTest test = reports.createTest("iLab Vacancy Application Firefox").assignAuthor("Mbasa Gwama");
                node = test.createNode("iLAB application test");
            }
            case "IE" -> {
                reports = rt.initilizeExtentReporters("reports/iLabReport "+sBrowser+".html");
                ExtentTest test = reports.createTest("iLab Vacancy Application Microsoft Edge").assignAuthor("Mbasa Gwama");
                node = test.createNode("iLAB application test");
            }
        }

    }

    public ExtentTest getNode()
    {
        return node;
    }

    public ExtentReports getReports()
    {
        return reports;
    }
}
