package webUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class webActions {

    public static void clickObject(WebElement element, WebDriver driver) {
        try
        {
            if (element.isDisplayed())
            {
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(5))
                        .pollingEvery(Duration.ofMillis(1000))
                        .ignoring(WebDriverException.class);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
            }
        } catch (Exception e){
            System.out.println(element + "Not found");
        }
    }

    public static void passData(WebElement element, WebDriver driver, String vValue) {
        try {
            if (element.isDisplayed()) {
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(5))
                        .pollingEvery(Duration.ofMillis(1000))
                        .ignoring(WebDriverException.class);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.clear();
                element.sendKeys(vValue);
            }
        } catch (Exception e) {
            System.out.println(element + "Not found");
        }
    }

    public static void selectObject(WebElement element, WebDriver driver, String x, Object oObject)
    {
        Select mySelect = new Select(element);
        try {
            if (element.isDisplayed()) {
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(5))
                        .pollingEvery(Duration.ofMillis(1000))
                        .ignoring(WebDriverException.class);
                wait.until(ExpectedConditions.elementToBeClickable(element));

                switch (x.toUpperCase()) {
                    case "INDEX":
                        mySelect.selectByIndex((Integer) oObject);
                        break;
                    case "SELECTBYVISIBLETEXT":
                        mySelect.selectByVisibleText((String) oObject);
                        break;
                    case "SELECTBYVALUE":
                        mySelect.selectByValue((String) oObject);
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(element + "Not found");
        }
    }
}
