package webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class menuItems
{
    protected WebDriver driver;

    public menuItems(WebDriver driver)
    {
        this.driver = driver;

        PageFactory.initElements(driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 10), this);
    }

    @FindBy(xpath = "//*[@id=\"menu-item-1373\"]")
    public WebElement careerBtn;
}
