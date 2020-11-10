package PageObjects;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sun.security.krb5.internal.ASRep;
import utilities.Constants;
import utilities.DataProviderFactory;
import utilities.Fakers;
import utilities.GetProperties;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Prueba_Booking {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        GetProperties prop = new GetProperties();
        System.setProperty("webdriver.chrome.driver", prop.getString("CHROMEDRIVER_PATH"));
        driver = new ChromeDriver();
        driver.get(Constants.URL_BOOKING);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void validarTituloTest(){

        Assert.assertEquals(driver.getTitle(), "Booking.com | Web oficial | Los mejores hoteles y alojamientos");
    }

    @Test
    public void mostarLinksTest(){
        List<WebElement> links = driver.findElements(By.tagName("a"));

        if(!links.isEmpty()){
            for (WebElement link: links){
                System.out.println(link.getText());
            }
        }
    }

    @Test
    public void mostarH1sTest(){
        List<WebElement> listH1 = driver.findElements(By.tagName("h1"));

        System.out.println("********************************************");
        if(!listH1.isEmpty()){
            for (WebElement h1: listH1){
                System.out.println("Elemento h1: " + h1.getText());
            }
        }
    }

    @Test
    public void buscarGenteViajeraTest(){
        String expected = "Conecta con gente viajera";

        List<WebElement> listH2 = driver.findElements(By.tagName("h2"));

        if(!listH2.isEmpty()){
            for (WebElement h2: listH2){
                if(h2.getText().equals("Conecta con gente viajera")){
                    Assert.assertEquals(h2.getText(), expected);
                }
            }
        }
    }

    @Test
    public void registroUsuarioTests(){
        String errExpected = "Parece que no existe ninguna cuenta vinculada a este e-mail. Puedes crear una cuenta para utilizar nuestros servicios.";
        String errPassExpected = "Las contraseñas no coinciden. Inténtalo de nuevo.";

        driver.findElement(By.xpath("(//div[@class='sign_in_wrapper'])[2]")).click();
        driver.findElement(By.id("username")).sendKeys(Fakers.getEmail());
        driver.findElement(By.xpath("//button[@class='bui-button bui-button--large bui-button--wide']")).click();

        Assert.assertEquals(driver.findElement(By.id("username-description")).getText(), errExpected);

        driver.findElement(By.xpath("//a[contains(text(), 'Regístrate')]")).click();
        driver.findElement(By.id("username")).sendKeys(Fakers.getEmail());
        driver.findElement(By.xpath("//span[contains(text(), 'Empezar')]")).click();
        driver.findElement(By.id("password")).sendKeys(Fakers.getPassword());
        driver.findElement(By.id("confirmed_password")).sendKeys(Fakers.getPassword());
        driver.findElement(By.xpath("//span[contains(text(), 'Crear una cuenta')]")).click();

        Assert.assertEquals(driver.findElement(By.id("confirmed_password-description")).getText(), errPassExpected);
    }

    @Test
    public void crearCuentaTest(){
        String errExpected = "Ya tienes una cuenta de Booking.com registrada con la dirección de e-mail test@test.com. Puedes iniciar sesión directamente.";

        driver.findElement(By.xpath("(//div[@class='sign_in_wrapper'])[2]")).click();
        driver.findElement(By.id("username")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//a[contains(text(), 'Regístrate')]")).click();
        driver.findElement(By.id("login_name_register")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//span[contains(text(), 'Empezar')]")).click();

        Assert.assertEquals(driver.findElement(By.id("login_name_register-description")).getText(), errExpected);
    }

    @Test(dataProvider = "emails", dataProviderClass = DataProviderFactory.class)
    public void iniciarSesion(String email){
        driver.findElement(By.xpath("(//div[@class='sign_in_wrapper'])[2]")).click();
        driver.findElement(By.id("username")).sendKeys(email);
        driver.findElement(By.xpath("//span[contains(text(), 'Siguiente')]")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id = 'username-description']")).getText(), "Comprueba si el e-mail que has introducido es correcto");
    }

    @AfterMethod
    public  void cerrar(){
        driver.close();
    }
}
