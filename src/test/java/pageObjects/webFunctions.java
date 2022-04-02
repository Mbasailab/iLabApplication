package pageObjects;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import data.generateNumber;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import report.extentReport;
import webPageObjects.*;
import webUtilities.webActions;

import java.io.IOException;
import java.sql.ResultSet;


public class webFunctions extends webActions
{
    menuItems menu;
    location country;
    positionLink vacancy;
    extentReport repo = new extentReport();

    public void SelectMenu(WebDriver driver, ExtentTest node) throws IOException {
        String screenShot = repo.CaptureScreenShot(driver);

        menu = new menuItems(driver);
        clickObject(menu.careerBtn, driver);

        if (driver.getCurrentUrl().contains("careers"))
        {
            node.pass("Landing Page", MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
        }
        else
        {
            node.fail("Error message is not displayed",  MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
        }

    }

    public void SelectCountry(WebDriver driver, ExtentTest node) throws IOException
    {
        String screenShot = repo.CaptureScreenShot(driver);
        country = new location(driver);
        clickObject(country.countryBtn, driver);
        if (driver.getCurrentUrl().contains("careers"))
        {
            node.pass("Careers Page", MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
        }

        else
        {
            node.fail("Error message is not displayed",  MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
        }
    }

    public void SelectVacancy(WebDriver driver,  ExtentTest node) throws IOException {
        String screenShot = repo.CaptureScreenShot(driver);
        vacancy = new positionLink(driver);
        clickObject(vacancy.jobBtn, driver);

        if (driver.getCurrentUrl().contains("job"))
        {
            node.pass("Location Page", MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
        }

        else
        {
            node.fail("Error message is not displayed",  MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
        }
    }

    public void ClickApply(WebDriver driver, ExtentTest node) throws IOException {
        String screenShot = repo.CaptureScreenShot(driver);
        applyLink clickApply = new applyLink(driver);
        try{
            clickObject(clickApply.applyBtn, driver);
            String filename = repo.CaptureScreenShot(driver);

        }
        catch(Exception e)
        {
            System.out.print(" Error : " + e.getMessage());
            Assert.fail();
        }

        if (driver.getCurrentUrl().contains("job"))
        {
            node.pass("Vacancy Page", MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
        }

        else
        {
            node.fail("Error message is not displayed",  MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
        }

    }

    public void applicationProcess(WebDriver driver, ResultSet rs, ExtentTest node){

        applicationForm Apply = new applicationForm(driver);
        generateNumber phoneNo = new generateNumber();


        try{
            passData(Apply.AppliName, driver, rs.getString("ApplicantName"));
            passData(Apply.EmailAddress, driver, rs.getString("Email"));
            passData(Apply.PhoneNum, driver, phoneNo.PhoneNo());
            passData(Apply.message, driver, rs.getString("Message"));

            clickObject(Apply.submitApp,driver);

            String screenShot = repo.CaptureScreenShot(driver);

            if (Apply.error_message.isDisplayed())
            {
                node.pass("Application Page", MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());

            }
            else
            {
                node.fail("Error message is not displayed",  MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());

            }

        }
        catch(Exception e)
        {
            System.out.print(" Error : " + e.getMessage());
            Assert.fail();
        }



    }
}
