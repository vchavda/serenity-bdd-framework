package Steps;

import Pages.Advanced;
import config.Appconfig;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import utilities.SharedData;


import java.util.List;
import java.util.Map;

@ContextConfiguration(classes = {Appconfig.class})
public class AdvSteps {

    @Value("${user}")
    private String user;
    Advanced advanced;

    @Autowired
    SharedData sharedData;

    @Given("^user verifies data in table \"([^\"]*)\"")
    public void userverifiesTableData(String tableid, List<Map<String, String>> testData) throws InterruptedException {
        advanced.verifyTableData(tableid, testData);
    }


    @Given("^user switches frames to \"([^\"]*)\" and clicks on the H1 item \"([^\"]*)\"")
    public void userSwitchesFramesAndClicksOnH1Item(String framename, String item) throws Exception {
        advanced.clickOnH1itemWithinFrame(framename, item);
    }

    @Given("^user switches frames to \"([^\"]*)\" and clicks on the Li item \"([^\"]*)\" and selects \"([^\"]*)\"")
    public void userSwitchesFramesAndClicksOnLiItem(String framename, String item, String text) throws Exception {
        advanced.clickOnLiitemWithinFrame(framename, item, text);
    }


    @Given("^user clicks on menu item \"([^\"]*)\"")
    public void userClickMenuItem(String item) {
        System.out.println("property user: " + this.user);
        sharedData.setSomeSharedData("my data");
        System.out.println("shared data : " + sharedData.getSomeSharedData());
        advanced.clickOnMenuItem(item);
    }


}

