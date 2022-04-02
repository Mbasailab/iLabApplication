package webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class location
{
    protected WebDriver driver;

    public location(WebDriver driver)
    {
        this.driver = driver;

        PageFactory.initElements(driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 10), this);
    }

    @FindBy(xpath = "//a[text()[contains(.,'South Africa')]]")
    public WebElement countryBtn;
}
