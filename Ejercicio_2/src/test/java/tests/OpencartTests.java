package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesObjects.OpencartLandingPage;
import utilities.Constants;
import utilities.OpencartDataFactory;
import utilities.GetProperties;
import utilities.OpencartDataProvider;

import java.util.concurrent.TimeUnit;

public class OpencartTests {

    private OpencartLandingPage opencartLandingPage;
    private WebDriver driver;
    private String email;
    private String password;

    @Test(groups = {"registration", "purchase"})

    @BeforeMethod(alwaysRun = true)
    public void setup(){

        GetProperties prop = new GetProperties();
        System.setProperty("webdriver.chrome.driver", prop.getString("CHROMEDRIVER_PATH"));
        driver = new ChromeDriver();
        driver.get(Constants.URL_OPENCART);
        driver.manage().window().maximize();
        opencartLandingPage = new OpencartLandingPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(groups = {"registration"})
    public void registrarUsuario(){

        email = OpencartDataFactory.getEmail();
        password = OpencartDataFactory.getPassword();

        Assert.assertEquals(opencartLandingPage.crearCuenta(email, password), "Your Store");
        opencartLandingPage.deslogearse();
        opencartLandingPage.logearse(email, password);
    }

    @Test(groups = {"purchase"}, priority = 2, enabled = false)
    public void contarProductosMac(){
        opencartLandingPage.deslogearse();
        opencartLandingPage.logearse(email, password);
        Assert.assertTrue(opencartLandingPage.contarProductosMac("Mac"));
    }

    @Test(groups = {"purchase"})
    public void agregarProductosSamsung(){

        opencartLandingPage.logearse("alitvits@yopmail.com", "abcdef");
        Assert.assertEquals(opencartLandingPage.agregarProducto("Samsung Galaxy Tab 10.1"), Constants.MESSAGE_SUCCESS);
    }

    @Test(groups = {"purchase"}, dependsOnMethods = {"agregarProductosSamsung"})
    public void validarImporte(){

        opencartLandingPage.logearse("alitvits@yopmail.com", "abcdef");
        Assert.assertEquals(opencartLandingPage.validarImporte(),"$483.98");
    }

    @Test(groups = {"purchase"}, dataProvider = "emailsNoRegistrados", dataProviderClass = OpencartDataProvider.class)
    public void loguearUsuarioNoRegistrado(String email, String password){

        opencartLandingPage.logearse(email, password);
        Assert.assertEquals(opencartLandingPage.loginUsuarioNoRegistrado(), Constants.MESSAGE_ERROR);
    }
}
