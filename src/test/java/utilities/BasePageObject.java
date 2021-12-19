package utilities;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject extends PageObject {


    public void waitUntilTheElementIsPresent(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30, 1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitUntilTheElementIsVisible(WebElement element) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 25, 1000);
        waitUntilTheElementIsVisibleBase(element, wait);
    }

    static void waitUntilTheElementIsVisibleBase(WebElement element, WebDriverWait wait) throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            if (e.getMessage().contains("Cannot find context with specified id")) {
                Thread.sleep(3000);
                wait.until(ExpectedConditions.visibilityOf(element));
            }
        }
    }
}
