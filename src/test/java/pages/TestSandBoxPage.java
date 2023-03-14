package pages;

import org.openqa.selenium.WebDriver;

public class TestSandBoxPage extends BasePage {

    private String select = "//select[@id='oldSelectMenu']";
    private String categoryDropdown = "4";

    public TestSandBoxPage() {
        super(driver);
    }

    public void navigateToSandbox(){
        navigateTo("https://demoqa.com/select-menu");
    }

    public void selectCategory(){
        selectFromDropDownByValue(select,categoryDropdown);
    }

}
