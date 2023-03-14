package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ListPage extends BasePage{
    private String searchField = "//input[@title='Buscar']";
    private String searchResults = "//h3[@class='LC20lb MBeuO DKV0Md']";

    private String searchButton = "//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']";

    public ListPage() {
        super(driver);
    }

   public void navigateToListPage(){
        navigateTo("https://google.com");
   }

   public void enterSearchCriteria(){
        write(searchField, "google");
        clickElement(searchButton);
   }

   public List<String> getAllSearchResults(){
      //Primero creamos una lista de WebElements
      List<WebElement> list = bringMeAllElements(searchResults);
      //Creamos una lista de Strings
      List<String> stringFromList = new ArrayList<String>();
      //Con el for vamos a recorrer la lista de WebElements, y
      //la pasaremos a lista se Strings
      for(WebElement e:list){
          stringFromList.add(e.getText());
      }
      return stringFromList;
   }

}
