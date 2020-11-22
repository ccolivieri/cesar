package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpencartBasePage {
    
    protected WebDriver driver;

    public OpencartBasePage(WebDriver aDriver){
        driver = aDriver;
    }

    public void logearse(String email, String password){

        driver.findElement(By.xpath("(//li[@class = 'dropdown'])[1]")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Login')]")).click();
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    }

    public void buscarProducto(String producto){
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(producto);
        driver.findElement(By.xpath("//button[@type='button'][@class='btn btn-default btn-lg']")).click();
    }
}
