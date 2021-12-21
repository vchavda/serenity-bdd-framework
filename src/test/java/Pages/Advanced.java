package Pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BasePageObject;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SerenityRunner.class)
public class Advanced extends BasePageObject {


    public void verifyTableData(String tableId, List<Map<String, String>> testData) throws InterruptedException {
        //click on the menu option for dynamic table
        getDriver().findElement(By.xpath("//*[@id=\"dynamictablestest\"]")).click();

        //get the table
        WebElement simpleTable = getDriver().findElement(By.id(tableId));

        //Get all rows
        List<WebElement> rows = simpleTable.findElements(By.tagName("tr"));
        assertEquals(3, rows.size());

        // loop through each row
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.print(col.getText() + "\t");
            }
            System.out.println();
        }
    }


}

