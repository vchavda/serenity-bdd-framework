package Pages;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BasePageObject;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SerenityRunner.class)
public class Advanced extends BasePageObject {


    public void verifyTableData(String tableId, List<Map<String, String>> testData) throws InterruptedException {

        //get the table
        WebElement simpleTable = getDriver().findElement(By.id(tableId));

        //Get all rows
        List<WebElement> rows = simpleTable.findElements(By.tagName("tr"));
        assertEquals(3, rows.size());
        assertTrue(verifyvalue(rows,testData));
    }

    public boolean verifyvalue ( List<WebElement> rows, List<Map<String, String>> testData) {
        int status = 0;

        for (int i = 0; i < testData.size(); i++) {
            for (WebElement row : rows) {
                List<WebElement> cols = row.findElements(By.tagName("td"));
                for (WebElement col : cols) {
                    System.out.println("col = " + col.getText());
                    if ((testData.get(i).get("name").equals(col.getText())) | (testData.get(i).get("age").equals(col.getText()))) {
                        status++;
                    }
                }
            }
        }
        return (status==testData.size()*2);
    }


    public void clickOnH1itemWithinFrame(String framename, String item) throws Exception {
        getDriver().switchTo().defaultContent();
        waitUntilTheFrameIsVisibleAndSwitch("//*[@id=\""+framename+"\"]");
        getDriver().findElement(By.xpath("//h1[contains(text(),\"" + item + "\")]")).click();
    }


    public void clickOnLiitemWithinFrame(String framename, String item, String text) throws Exception {
        getDriver().switchTo().defaultContent();
        waitUntilTheFrameIsVisibleAndSwitch("//*[@id=\""+framename+"\"]");
        WebElement el = getDriver().findElement(By.xpath("//li[@id=\"" + item + "\"]"));
        System.out.println("li text is: " + el.getText());
        assertEquals(el.getText(), text);
    }

    public void clickOnMenuItem(String item) {
        getDriver().findElement(By.xpath("//*[@id=\""+item+"\"]")).click();
    }
}

