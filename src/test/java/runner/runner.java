package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
    //!Estamos indicando en que dirección se encuentran los features
    features = "src/test/resources/features",
    //!Estamos indicando donde estan las definiciones para los steps de esos features
    glue = "steps",
    tags = "@Test"
)

public class runner {
    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
}
