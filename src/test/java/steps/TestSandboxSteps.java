package steps;
import io.cucumber.java.en.*;
import pages.TestSandBoxPage;

public class TestSandboxSteps {

    TestSandBoxPage testSandBoxPage = new TestSandBoxPage();

   @Given("^I navigate to the sandbox page$")
    public void navigateToTheSandboxSite(){
        testSandBoxPage.navigateToSandbox();
    }
    @And("^Select a value from the dropdown$")
    public void selectCategory(){
        testSandBoxPage.selectCategory();
    }

}
