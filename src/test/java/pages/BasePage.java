package pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class BasePage {
    //!En este caso creamos de manera estatica el driver
    //!Para que todas las clases compartan el mismo
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions actions;

    static {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    //Estamos creando el constructor para inicializar nuestro driver
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    //Creamos de manera estatica para pasarlo a todas las clases sin necesidad
    //de declararlo
    public static void navigateTo(String url){
        driver.get(url);
    }

    //Metodo para cerrar el navegador y todas las vantanas que se abrieron en su ejecucion
    public static void closeBrowser(){
        driver.quit();
    }

    //Este metodo nos permite buscar un WebElement y esperar el tiempo
    // que le hemos asignado en el wait, si en ese tiempo no se encunetra
    // arroja una excepcion, sino devuelve el WebElement
    private WebElement find (String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    //metodo para dar clic sobre un elemento
    public void clickElement (String locator){
        find(locator).click();
    }

    //Metodo para escribir en un cuadro de texto
    public void write(String locator, String textToWrite){
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }

    //Metodo para seleccionar una opcion de un select, por medio del
    //valor que contiene la propiedad value
    public void selectFromDropDownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    //Metodo para seleccionar una opción de un select, por medio
    // de la posición en la lista de opciones
    public void selectFromDropDownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select(find(locator));
        dropdown.selectByIndex(valueToSelect);
    }

    //Metodo para seleccionar una opción de un select, por medio del texto visible
    public void selectFromDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select(find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }

    //Metodo para posicionar el mouse sobre un elemento (Actions)
    public void hoverOverElement(String locator){
        actions.moveToElement(find(locator));
    }

    //Metodo para dar doble clic(Actions) en un elemento
    public void doubleClick(String locator){
        actions.doubleClick(find(locator));
    }

    //Metodo para dar clic derecho sobre un elemento (Actions)
    public void rightClick(String locator){
        actions.contextClick(find(locator));
    }

    //Metodo para obtener el valor de una celda de una tabla
    public String getValueFromTable(String locator, int row, int column){
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        return find(cellINeed).getText();
    }

    //Metodo para poder agregar un texto en una celda de una tabla editable
    public void setValueOnTable(String locator, int row, int column, String stringToSend){
        String cellToFill = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        find(cellToFill).sendKeys(stringToSend);
    }

    //Metodo para cambiar de Frame, esto nos puede ayudar cuando un pop up o algo
    //nos esta tapando la vision a un WebElement
    public void switchToiFrame(int iFrameID){
        driver.switchTo().frame(iFrameID);
    }

    //Metodo para regresar al Frame padre, en el caso de que nos hayamos cambiado
    // de Frame
    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    //Metodo para cerrar una alerta
    public void didmissAlert(){
        try {
            driver.switchTo().alert().dismiss();
        }catch (NoAlertPresentException e){
            e.printStackTrace();
        }
    }

    //Metodo para obtener el texto de un WebElement
    public String textFromElement(String locator){
        return find(locator).getText();
    }

    //Metodo para indicarnos si el WebElement se encuentra dentro del DOM
    public boolean elementIsDisplayed(String locator){
        return find(locator).isDisplayed();
    }

    //Metodo para obtener todos los WebElements que coincidan con el xpath
    public List<WebElement> bringMeAllElements(String locator){
        return driver.findElements(By.xpath(locator));
    }



}
