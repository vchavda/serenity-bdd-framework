package Steps;

import Pages.Advanced;
import Pages.FormPage;
import cucumber.api.java.en.Given;

import java.util.List;
import java.util.Map;

//@RunWith(SerenityRunner.class)
public class FormSteps {

    FormPage testpageFormPage;
    Advanced advanced;

    //open website
    @Given("user navigate to the website \"([^\"]*)\"")
    public void navigateToWebsite(String website) {
        if (website.equals("forms")) {
            testpageFormPage.open();
        }
        else {
            advanced.open();
        }
    }

    //text
    @Given("^user enters \"([^\"]*)\" as firstname")
    public void verifyFirstName(String firsName) {
        testpageFormPage.verifyFirstName(firsName);
    }

    //text
    @Given("^user enters \"([^\"]*)\" as surname")
    public void verifysurnameName(String surname) throws InterruptedException {
        testpageFormPage.verifySurnameName(surname);
    }

    //generic dropdown method
    @Given("user selects \"([^\"]*)\" from \"([^\"]*)\" dropdown")
    public void userSelectFromGenderDropDown(String dropDownItem, String dropDownType) {
        testpageFormPage.SelectFromDropdown(dropDownItem, dropDownType);
    }

    //single dropdown method (continent)
    @Given("user selects \"([^\"]*)\" from continent dropdown")
    public void userSelectFromContinentDropDown(String dropDownItem) {
        testpageFormPage.SelectFromContinentDropdown(dropDownItem);
    }

    //radio
    @Given("user selects \"([^\"]*)\" from colour radio")
    public void userSelectFromColourRadio(String colour) {
        testpageFormPage.SelectFromColourRadio(colour);
    }

    //checkbox
    @Given("user selects \"([^\"]*)\" from contact checkbox")
    public void userSelectFromContactCheckbox(String value) throws InterruptedException {
        testpageFormPage.SelectFromContactCheckbox(value);
    }

    //text area
    @Given("^user enters \"([^\"]*)\" as textarea")
    public void userEntersTextArea(String text) throws InterruptedException {
        testpageFormPage.userEntersTextArea(text);
    }



}

