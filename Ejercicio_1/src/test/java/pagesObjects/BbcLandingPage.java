package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BbcLandingPage {

    private WebDriver driver;

    public BbcLandingPage(WebDriver aDriver){
        PageFactory.initElements(aDriver, this);
        this.driver = aDriver;
    }

    public String registrarUsuarioMayor(){

        driver.findElement(By.id("idcta-link")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Register now')]")).click();

        WebDriverWait waitButton = new WebDriverWait(driver, 10);
        boolean invisible =waitButton.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner spinner--fill']")));
        if(invisible){
            driver.findElement(By.xpath("(//a[@class = 'button'])[2]")).click();
        }

        WebDriverWait waitInput = new WebDriverWait(driver, 10);
        WebElement mes = driver.findElement(By.id("month-input"));
        waitInput.until(ExpectedConditions.visibilityOf(mes));
        mes.sendKeys("12");

        driver.findElement(By.id("day-input")).sendKeys("12");
        driver.findElement(By.id("year-input")).sendKeys("2019");
        driver.findElement(By.id("submit-button")).click();
        return driver.findElement(By.xpath("//p[@class='form-message__text']")).getText();
    }

    public boolean registrarUsuarioMayor(String dia, String mes, String año){
        driver.findElement(By.id("idcta-link")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Register now')]")).click();

        WebDriverWait waitButton = new WebDriverWait(driver, 10);
        boolean invisible =waitButton.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner spinner--fill']")));
        if(invisible){
            driver.findElement(By.xpath("(//a[@class = 'button'])[2]")).click();
        }

        driver.findElement(By.id("day-input")).sendKeys(dia);
        driver.findElement(By.id("month-input")).sendKeys(mes);
        driver.findElement(By.id("year-input")).sendKeys(año);
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("user-identifier-input")).sendKeys("test@test.com");
        driver.findElement(By.id("password-input")).sendKeys("holamundo123");
        Select paises =new Select(driver.findElement(By.id("location-select")));
        paises.selectByVisibleText("Taiwan");

        return true;
    }

    public boolean registrarUsuarioMayor(String dia, String mes, String año,String email, String password){
        driver.findElement(By.id("idcta-link")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Register now')]")).click();

        WebDriverWait waitButton = new WebDriverWait(driver, 10);
        boolean invisible =waitButton.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner spinner--fill']")));
        if(invisible){
            driver.findElement(By.xpath("(//a[@class = 'button'])[2]")).click();
        }

        driver.findElement(By.id("day-input")).sendKeys(dia);
        driver.findElement(By.id("month-input")).sendKeys(mes);
        driver.findElement(By.id("year-input")).sendKeys(año);
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("user-identifier-input")).sendKeys(email);
        driver.findElement(By.id("password-input")).sendKeys(password);
        Select paises =new Select(driver.findElement(By.id("location-select")));
        paises.selectByVisibleText("Argentina");

        return true;
    }
}
