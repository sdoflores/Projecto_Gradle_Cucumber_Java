package pages;

import org.openqa.selenium.WebDriver;

public class GooglePage extends BasePage {

    private String  searchButton = "//div[@class='lJ9FBc']//input[@name='btnK']";
    private String  searchTextField = "//input[@title='Buscar']";

    private String firstResult = "";
    public GooglePage() {
        //Con esto estaremos utilizando el driver de la clase BasePage
        super(driver);
    }
    
    public void navigateToGoogle(){
        BasePage.navigateTo("https://www.google.com");
    }

    public void clickGoogleSearch(){
        clickElement(searchButton);
    }

    public void enterSearchCriteria(String criteria){
        write(searchTextField,criteria);
    }

    public String firstResult(){
        return textFromElement(firstResult);
    }

}
