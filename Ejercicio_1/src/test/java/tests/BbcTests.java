package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pagesObjects.BbcLandingPage;
import utilities.BbcDataProvider;
import utilities.Constants;
import utilities.GetProperties;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BbcTests {

    private static WebDriver driver;
    private BbcLandingPage bbcLandingPage;

    @Test(groups = {"escenarios_1234","escenarios_567"})

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        GetProperties prop = new GetProperties();
        System.setProperty("webdriver.chrome.driver", prop.getString("CHROMEDRIVER_PATH"));
        driver = new ChromeDriver();
        driver.get(Constants.URL_BBC);
        driver.manage().window().maximize();
        bbcLandingPage = new BbcLandingPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(groups = {"escenarios_1234"})
    public void validarTitulos(){
        int contador_links = 0;

        List<WebElement> listH1 = driver.findElements(By.tagName("h1"));
        List<WebElement> listLinks = driver.findElements(By.tagName("a"));

        System.out.println("Listado de H1:");
        for(WebElement h1: listH1){
            System.out.println(h1.getText());
        }

        System.out.println("Listado de hipervínculos:");
        for(WebElement link: listLinks){

            System.out.println(link.getText());

            if(contador_links == 5){
                break;
            }
            contador_links++;
        }

        Assert.assertEquals(driver.getTitle(), Constants.BBC_HOMEPAGE);

        driver.findElement(By.xpath("(//a[contains(text(), 'News')])[1]")).click();
        Assert.assertEquals(driver.getTitle(), Constants.BBC_NEWS);

        driver.findElement(By.xpath("//button[contains(text(), 'Maybe later')]")).click();
        driver.findElement(By.id("idcta-link")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Register now')]")).click();

        Assert.assertEquals(driver.getTitle(), Constants.BBC_SIGN_IN);
    }

    @Parameters({"opcionMenu"})
    @Test(groups = {"escenarios_1234"})
    public void ingresoOpcionMenu(@Optional("2") int opc){

        switch(opc){
            case 1: driver.findElement(By.xpath("//a[contains(text(), 'News')])[1]")).click();
                    Assert.assertTrue(driver.getCurrentUrl().contains("news"));
                    break;
            case 2: driver.findElement(By.xpath("(//a[contains(text(), 'Sport')])[1]")).click();
                    Assert.assertTrue(driver.getCurrentUrl().contains("sport"));
                    break;
            case 3: driver.findElement(By.xpath("(//a[contains(text(), 'Reel')])[1]")).click();
                    Assert.assertTrue(driver.getCurrentUrl().contains("reel"));
                    break;
            case 4: WebDriverWait wait = new WebDriverWait(driver, 5);
                    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[contains(text(), 'Worklife')])[1]")))).click();
                    Assert.assertTrue(driver.getCurrentUrl().contains("worklife"));
                    break;
            case 5: driver.findElement(By.xpath("(//a[contains(text(), 'Travel')])[1]")).click();
                    Assert.assertTrue(driver.getCurrentUrl().contains("travel"));
                    break;
        }
    }

    @Test(groups = {"escenarios_1234"})
    public void registrarUsuarioMenor(){
        boolean invisible = false;

        driver.findElement(By.id("idcta-link")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Register now')]")).click();

        WebDriverWait waitButton = new WebDriverWait(driver, 5);
        invisible = waitButton.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner spinner--fill']")));
        if(invisible){
            driver.findElement(By.xpath("(//a[@class='button'])[1]")).click();
        }

        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(), 'Sorry, only 16s and over can register outside the UK')]")).getText(), "Sorry, only 16s and over can register outside the UK");

        WebDriverWait waitButtonOk = new WebDriverWait(driver, 5);
        invisible =waitButtonOk.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner spinner--fill']")));
        if(invisible){
            driver.findElement(By.xpath("//span[contains(text(), 'OK')]")).click();
        }

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[contains(text(), 'Maybe later')]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.bbc.com/");
    }

    @Test(groups = {"escenarios_1234"})
    public void registrarUsuarioMayor(){
        String msgError = "Oops, that day and year don't look right. Make sure it's a real date written as DD-MM-YYYY e.g. the 5th of June 2009 is 05-06-2009.";

        driver.findElement(By.id("idcta-link")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Register now')]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner spinner--fill']")));
        if(invisible){
            driver.findElement(By.xpath("(//a[@class = 'button'])[2]")).click();
        }

        driver.findElement(By.id("month-input")).sendKeys("09");
        driver.findElement(By.id("submit-button")).click();

        Assert.assertEquals(driver.findElement(By.id("form-message-dateOfBirth")).getText(), msgError);
    }

    @Test(groups = {"escenarios_567"})
    public void registrarUsuarioMayorEdad(){
        String msgErr = bbcLandingPage.registrarUsuarioMayor();
        Assert.assertEquals(msgErr, "Sorry, you need to be 16 or over.");
    }

    @Test(groups = {"escenarios_567"})
    public void registrarUsuarioMayorEdadTaiwan(){
        boolean reg = bbcLandingPage.registrarUsuarioMayor("15", "2", "2000");
        Assert.assertTrue(reg);
    }

    @Test(groups = {"escenarios_567"}, dataProvider = "emails", dataProviderClass = BbcDataProvider.class)
    public void registrarUsuariosMayorEdad(String email, String password){
        boolean reg = bbcLandingPage.registrarUsuarioMayor("15", "2", "2000", email, password);
        Assert.assertTrue(reg);
    }
}
