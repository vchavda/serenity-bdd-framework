package Steps;

import Pages.Advanced;
import cucumber.api.java.en.Given;

import java.util.List;
import java.util.Map;

//@RunWith(SerenityRunner.class)
public class AdvSteps {

    Advanced advanced;

    @Given ("^user verifies data in table \"([^\"]*)\"")
    public void userverifiesTableData(String tableid, List<Map<String, String>> testData) throws InterruptedException {
        advanced.verifyTableData(tableid, testData);
    }


    @Given ("^user switches frames to \"([^\"]*)\" and clicks on the H1 item \"([^\"]*)\"")
    public void userSwitchesFramesAndClicksOnH1Item(String framename, String item) throws Exception {
        advanced.clickOnH1itemWithinFrame(framename,item);
    }

    @Given ("^user switches frames to \"([^\"]*)\" and clicks on the Li item \"([^\"]*)\" and selects \"([^\"]*)\"")
    public void userSwitchesFramesAndClicksOnLiItem(String framename, String item, String text) throws Exception {
        advanced.clickOnLiitemWithinFrame(framename,item, text);
    }


    @Given ("^user clicks on menu item \"([^\"]*)\"")
    public void userClickMenuItem(String item) {
       advanced.clickOnMenuItem(item);
    }




}

