package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.OpencartDataFactory;

import java.util.List;

public class OpencartLandingPage extends OpencartBasePage{

    public OpencartLandingPage(WebDriver aDriver){
        super(aDriver);
        PageFactory.initElements(aDriver, this);
    }

    public String crearCuenta(String email, String password){

        driver.findElement(By.xpath("(//li[@class = 'dropdown'])[1]")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Register')]")).click();
        driver.findElement(By.id("input-firstname")).sendKeys(OpencartDataFactory.getFirstName());
        driver.findElement(By.id("input-lastname")).sendKeys(OpencartDataFactory.getLastName());
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-telephone")).sendKeys(OpencartDataFactory.getTelephone());
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-confirm")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        return driver.findElement(By.tagName("h1")).getText();
    }

    public void deslogearse(){

        driver.findElement(By.xpath("(//li[@class = 'dropdown'])[1]")).click();
        driver.findElement(By.xpath("(//a[contains(text(), 'Logout')])[1]")).click();
    }

    public boolean contarProductosMac(String producto){

        buscarProducto(producto);
        List<WebElement> productosMac = driver.findElements(By.cssSelector("div[class^='product-layout product-grid']"));

        if(productosMac.size() == 4){
            return true;
        }
        return false;
    }

    public String agregarProducto(String producto){

        buscarProducto(producto);

        for (int i = 0; i < 2; i++){
            driver.findElement(By.xpath("//*[contains(text(), 'Add to Cart')]")).click();
        }

        String success = driver.findElement(By.xpath("//div[@class = 'alert alert-success alert-dismissible']")).getText();
        String text = success.replaceAll("×", " ").trim();

        return text;
    }

    public String validarImporte(){

        driver.findElement(By.xpath("//a[@title = 'Shopping Cart']")).click();
        String importeTotal = driver.findElement(By.xpath("(//td[@class = 'text-right'])[10]")).getText();
        return importeTotal;
    }

    public String loginUsuarioNoRegistrado(){

        return driver.findElement(By.xpath("//div[@class = 'alert alert-danger alert-dismissible']")).getText();
    }
}
