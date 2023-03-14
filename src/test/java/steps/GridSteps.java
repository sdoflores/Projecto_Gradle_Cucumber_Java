package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.GridPage;

public class GridSteps {
    GridPage gridPage = new GridPage();

    @Given("^I navigate to the static table$")
    public void navigateToGridPage() {
        gridPage.navigateToGrid();
    }

    @Then("^I can return the value I wanted$")
    public void returnValue() {
        String value = gridPage.getValueFromGrid(2, 2);
        Assert.assertEquals("r: 2, c: 1", value);
    }

   @Then("^I can validate the table is displayed$")
    public void theTableIsThere() {
        Assert.assertTrue("No se muestra el WebElement", gridPage.cellStatus());
    }
}
