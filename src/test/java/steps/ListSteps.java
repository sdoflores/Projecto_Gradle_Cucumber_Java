package steps;
import io.cucumber.java.en.*;
import pages.ListPage;

import java.util.List;

public class ListSteps {

    ListPage listPage = new ListPage();

    @Given("^I navigate to the list page$")
    public void navigateToListPage(){
        listPage.navigateToListPage();
    }

    @When("^I search the list$")
    public void searchTheList() {
        listPage.enterSearchCriteria();
    }

    @Then("^I can find the text in the list$")
    public void theTableIsThere(){
        //Creamos una lista de Strings y la llamamos "lista"
        //aquí asignamos la lista de WebElements que anteriormente
        //convertimos a Strings
        List<String> lista = listPage.getAllSearchResults();
        //Creamos un booleano en donde se evalua si el texto:
        //"Google - Wikipedia, la enciclopedia libre" se encuentra
        //en la lista de Strings
        boolean textIsThere = lista.contains("Google - Wikipedia, la enciclopedia libre");

        if(textIsThere){
            //Si se encuentra el texto, mostrara el siguiente mensaje:
            System.out.println("The text is on the list: PASSED.");
        }else {
            //Si no se encuentra, mostrara el siguiente mensaje
            throw new Error("The text is not on the list: FAILED!");
        }

    }

}
