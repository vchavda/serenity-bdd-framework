package Pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.jruby.RubyProcess;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BasePageObject;

@RunWith(SerenityRunner.class)
public class FormPage extends BasePageObject {

    // below demonstates to ways for the findby and two ways for wait until functions
    @FindBy(id = "firstname")
    WebElementFacade firstNameEl;

    @FindBy(xpath = "//*[@id='surname']")
    private WebElement surnameEl;

    @FindBy(xpath = "//*[@id='checkbox2']")
    private WebElement SMScheckbox;

    @FindBy(xpath = "//*[@id='checkbox1']")
    private WebElement Emailcheckbox;

    @FindBy(xpath = "//textarea[contains(@placeholder,'Tell us some')]")
    private WebElement textArea;

    @FindBy(id = "continent")
    private WebElementFacade continentDropDownEl;

    public void verifyFirstName(String firstName) {
        waitUntilTheElementIsPresent(By.xpath("//*[@id=\"firstname\"]"));
        firstNameEl.type(firstName);
        Assert.assertTrue(firstNameEl.getValue().equals(firstName));
    }

    public void verifySurnameName(String surname) throws InterruptedException {
        waitUntilTheElementIsVisible(surnameEl);
        surnameEl.sendKeys(surname);
        Assert.assertTrue($(By.id("surname")).getValue().equals(surname));
    }

    public void SelectFromDropdown(String dropDownItem, String dropDownType) {
        Select el =  new Select(getDriver().findElement(By.xpath("//*[@id=\"" + dropDownType + "\"]")));
        el.selectByVisibleText(dropDownItem);
    }

    public void SelectFromColourRadio(String colour) {
        // here we are using an and operator to ensure the value is from the radio button - make it less brittle
        WebElement el = getDriver().findElement(By.xpath("//*[@value=\"" + colour + "\" and @type='radio']"));
        el.click();
    }

    public void SelectFromContactCheckbox(String checkBoxValue) throws InterruptedException {
        switch (checkBoxValue) {
            case "Email":
                waitUntilTheElementIsVisible(Emailcheckbox);
                Emailcheckbox.click();
                break;

            default:
                waitUntilTheElementIsVisible(SMScheckbox);
                SMScheckbox.click();
                break;
        }
    }

    public void userEntersTextArea(String text) throws InterruptedException {
        waitUntilTheElementIsVisible(textArea);
        textArea.sendKeys(text);
    }

    public void SelectFromContinentDropdown(String dropDownItem) {
        continentDropDownEl.selectByVisibleText(dropDownItem);
    }
}

