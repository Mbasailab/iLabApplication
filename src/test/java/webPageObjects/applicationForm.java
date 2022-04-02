package webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class applicationForm {

    protected WebDriver driver;
    public applicationForm(WebDriver driver)
    {
        this.driver = driver;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 10), this);
    }

    @FindBy(xpath ="//*[@id=\"applicant_name\"]")
    public WebElement AppliName;

    @FindBy(xpath ="//*[@id=\"email\"]")
    public WebElement EmailAddress;

    @FindBy(xpath ="//*[@id=\"phone\"]")
    public WebElement PhoneNum;

    @FindBy(xpath ="//*[@id=\"message\"]")
    public WebElement message;

    @FindBy(xpath ="//*[@id=\"wpjb_submit\"]")
    public WebElement submitApp;

    @FindBy(xpath ="//*[@id=\"wpjb-form-job-apply\"]/div")
    public WebElement error_message;
}
