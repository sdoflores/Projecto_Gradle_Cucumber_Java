package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.GooglePage;


public class GoogleSteps {
    GooglePage googlePage = new GooglePage ();

    @Given("^I am on the Google search page$")
    public void navigateToGoogle(){
        googlePage.navigateToGoogle();
    }

    @When("^I enter a search criteria$")
    public void enterSearchCriteria(){
        googlePage.enterSearchCriteria("google");
    }

    @And("^Click on the search button$")
    public void clickSearchButton(){
        googlePage.clickGoogleSearch();
    }

    @Then("^The results match the criteria$")
    public void validateResults(){
        Assert.assertEquals("Texto que esperamos",googlePage.firstResult());
    }

}
