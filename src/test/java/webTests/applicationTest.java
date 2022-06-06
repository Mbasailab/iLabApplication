package webTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import data.DBConnection;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.webFunctions;
import webUtilities.webUtilities;
import webUtilities.BrowserReports;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class applicationTest
{
    public webUtilities app = new webUtilities();

    public webFunctions web = new webFunctions();
    DBConnection datafile = new DBConnection();
    BrowserReports br  = new BrowserReports();
    ResultSet rs;
    String sUrl, sBrowser;
    ExtentReports reports;
    ExtentTest node;

    @Parameters({"iLabURL", "Browser"})
    @BeforeTest
    public void beforeMethod(String iLabURL, String Browser)
    {
        sUrl = iLabURL;
        sBrowser = Browser;
        app.setWebDriver(app.initializeWebDriver(Browser));
        br.createBrowserReport(sBrowser);
        node = br.getNode();
        reports = br.getReports();
        try{
            rs = datafile.ConnectAndQuerySQL("jdbc:mysql://127.0.0.1/ilabapplication", "root", "Mabasa126", "select * from ilabdata");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void apply_iLab() throws InterruptedException, SQLException, IOException {

        app.navigate(sUrl);
        web.SelectMenu(webUtilities.getWebDriver(), node);
        web.SelectCountry(webUtilities.getWebDriver(), node);
        web.SelectVacancy(webUtilities.getWebDriver(), node);
        web.ClickApply(webUtilities.getWebDriver(), node);

        //Filling Form
        while(rs.next())
        {
            web.applicationProcess(webUtilities.getWebDriver(), rs,node);
        }
    }

    @AfterTest
    public void closeUp() throws InterruptedException
    {

        reports.flush();
        Thread.sleep(3000);
        app.getWebDriver().quit();


    }
}
