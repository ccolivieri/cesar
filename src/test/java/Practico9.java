import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.GetProperties;

import java.util.List;

public class Practico9 {

    private GetProperties prop = new GetProperties();
    private WebDriver driver;

    @Test
    public void abrirBrowser(){

        abrirPagina("http://www.google.com.ar");
    }

    @Test
    public void mostrarTitulo(){

    }

    @Test
    public void bbcMundo(){
        int contadorH1 = 0;
        int contadorH2 = 0;
        int contadorH3 = 0;

        abrirPagina("https://www.bbc.com/mundo");

        List<WebElement> listaH1 = driver.findElements(By.tagName("h1"));

        for(WebElement e: listaH1){
            contadorH1++;
        }
        System.out.println("Cantidad de H1: " + contadorH1);

        List<WebElement> listaH2 = driver.findElements(By.tagName("h2"));

        for(WebElement e: listaH2){
            contadorH2++;
            if(contadorH2 <=3){
                System.out.println(e.getText());
            }
        }

        System.out.println("Cantidad de H2: " + contadorH2);

        List<WebElement> listaH3 = driver.findElements(By.tagName("h3"));

        for(WebElement e: listaH3){
            contadorH3++;
            if(contadorH3 <= 3){
                System.out.println(e.getText());
            }
        }
    }

    @Test
    public void bbcMundoLinks(){
        int cant_parrafos = 0;

        abrirPagina("https://www.bbc.com/mundo");
        List<WebElement> listaLinks = driver.findElements(By.tagName("a"));

        System.out.println("Cantidad de links: " + listaLinks.size());
        System.out.println("Links y sus textos:");
        for (WebElement e: listaLinks){
            System.out.println(e.getText());
        }

        List<WebElement> listaParrafos = driver.findElements(By.tagName("p"));
        for (WebElement e: listaParrafos){
            cant_parrafos++;
        }
        System.out.println("Cantidad de párrafos del sitio: " + cant_parrafos);
        driver.navigate().refresh();
        driver.quit();
    }

    @Test
    public void bbcMundoListas(){
        abrirPagina("https://www.bbc.com/mundo");
        List<WebElement> listaLi = driver.findElements(By.tagName("li"));

        System.out.println("Elementos li y su texto:");
        for (WebElement e: listaLi){
            System.out.println(e.getText());
        }

        driver.navigate().refresh();
        driver.quit();
    }

    @Test
    public void getTileTest(){
        abrirPagina("https://google.com");
        String titulo = driver.getTitle();

        if(titulo.contentEquals("Google")){
            System.out.println("Test Passed!!");
        }else {
            System.out.println("Test Failed");
        }
        driver.quit();
    }

    @Test
    public void getWindowsSizeTest(){
        abrirPagina("https://google.com");
        int anchoActual = driver.manage().window().getSize().getWidth();
        int altoActual = driver.manage().window().getSize().getHeight();
        int anchoEsperado;
        int altoEsperdado;

        System.out.println("Ancho: " + anchoActual);
        System.out.println("Alto: " + altoActual);
        anchoEsperado = 1024;
        altoEsperdado = 768;
        Dimension dimension = new Dimension(anchoEsperado, altoEsperdado);
        driver.manage().window().setSize(dimension);


        if(driver.manage().window().getSize().getHeight() == altoEsperdado && driver.manage().window().getSize().getWidth() == anchoEsperado){
            System.out.println("Test passed!!");
        }else {
            System.out.println("Test Failed");
        }
    }

    public WebDriver getGoogleDriver(){
        String chromerDriverUrl = prop.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromerDriverUrl);
        WebDriver googleDriver = new ChromeDriver();
        googleDriver.get("www.google.com");
        return googleDriver;
    }

    public WebDriver getDriver(String url){
        String chromerDriverUrl = prop.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromerDriverUrl);
        WebDriver sitioDriver = new ChromeDriver();
        sitioDriver.get(url);
        return sitioDriver;
    }

    @Test
    public void searchInGoogle(){
        WebDriver driver = getDriver("https://google.com");
        WebElement search = driver.findElement(By.cssSelector("[name='q'"));
        search.sendKeys("WebElement" + Keys.ENTER);
    }

    @Test
    public void searchInGoogleAndGoBack(){
        abrirPagina("https://google.com");
        System.out.println(getTitle());
        search("Selenium Driver");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
    }

    @Test
    public void getBrowserSizes(){
        abrirPagina("https://www.facebook.com");
        int anchoActual = driver.manage().window().getSize().getWidth();
        int altoActual = driver.manage().window().getSize().getHeight();
        System.out.println("Ancho: " + anchoActual);
        System.out.println("Alto: " + altoActual);
        driver.manage().window().maximize();
        anchoActual = driver.manage().window().getSize().getWidth();
        altoActual = driver.manage().window().getSize().getWidth();
        System.out.println("Ancho: " + anchoActual);
        System.out.println("Alto: " + altoActual);
    }

    @Test
    public void facebookPageTest(){
        abrirPagina("https://www.facebook.com");
        List<WebElement> divs = driver.findElements(By.tagName("div"));
        List<WebElement> archors = driver.findElements(By.tagName("a"));
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        System.out.println("Cantidad de div: " + divs.size());
        System.out.println("Cantidad de botones: " + buttons.size());

        for (WebElement button: buttons){
            System.out.println(button.getText());
        }

        driver.quit();
    }

    @Test
    public void netflixPageTest(){
        abrirPagina("https://www.netflix.com/uy/");
        List<WebElement> h1 = driver.findElements(By.tagName("h1"));
        List<WebElement> h2 = driver.findElements(By.tagName("h2"));
        List<WebElement> h3 = driver.findElements(By.tagName("h3"));
        List<WebElement> buttons = driver.findElements(By.tagName("buttons"));
        List<WebElement> divs = driver.findElements(By.tagName("div"));
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        List<WebElement> links = driver.findElements(By.tagName("link"));
        WebElement elementoMasRepetido;

        if(h1.size() < h2.size() && h1.size() < h3.size()){
            for (WebElement e: h1){
                System.out.println(e.getText());
            }
        }else if(h2.size() < h3.size()){
            for (WebElement e: h2){
                System.out.println(e.getText());
            }
        }else {
            for (WebElement e: h3){
                System.out.println(e.getText());
            }
        }

        driver.navigate().refresh();

        for (WebElement button: buttons){
            System.out.println(button.getText());
        }

        driver.manage().window().maximize();
        System.out.println("Cantidad de elementos div: " + divs.size());
        System.out.println("Título: " + driver.getTitle());
        System.out.println("Cantidad de elementos de tipo input: " + inputs.size());
        System.out.println("Cantidad de elementos de tipo link: " + links.size());
        elementoMasRepetido = elementoMasRepetido();
        System.out.println("Elemento que más se repite en el sitio: " + elementoMasRepetido.getTagName() + " Cantidad de veces: " + cantidadVecesRepetidoElemento(elementoMasRepetido));
        driver.quit();
    }

    @Test
    public void netflixIniciarSesionTest(){
        abrirPagina("https://www.netflix.com/uy/");
        WebElement botonIniciarSesion = driver.findElement(By.tagName("a"));
        List<WebElement> h1 = driver.findElements(By.tagName("h1"));
        List<WebElement> h2 = driver.findElements(By.tagName("h2"));
        botonIniciarSesion.click();

        for (WebElement e: h1){
            System.out.println(e.getText());
        }

        for (WebElement e: h2){
            System.out.println(e.getText());
        }
        driver.navigate().back();
        driver.navigate().refresh();
        List<WebElement> divs = driver.findElements(By.tagName("div"));

        for (WebElement e: divs){
            System.out.println(e.getText());
        }

        String titulo = driver.getTitle();
        System.out.println("Título: " + titulo);

        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        List<WebElement> links = driver.findElements(By.tagName("link"));
        System.out.println("Cantidad de inputs: " + inputs.size());
        System.out.println("Cantidad de links: " + links.size());

        WebElement elementoMasRepetido = elementoMasRepetido();
        System.out.println("Elemento que más se repite en el sitio: " + elementoMasRepetido.getTagName() + " Cantidad de veces: " + cantidadVecesRepetidoElemento(elementoMasRepetido));
    }

    @Test
    public void spotifyPageTest(){
        abrirPagina("https://www.spotify.com/uy/");
        String titulo = driver.getTitle();
        List<WebElement> parrafos = driver.findElements(By.tagName("p"));
        List<WebElement> a = driver.findElements(By.tagName("a"));
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        WebElement ayuda = driver.findElement(By.linkText("Ayuda"));
        WebElement textoSeccionPrincipal = driver.findElement(By.tagName("h1"));
        List<WebElement> menu = driver.findElements(By.className("a"));

        Assert.assertEquals(titulo, "Escuchar es todo - Spotify");
        System.out.println("Cantidad de párrafos: " + parrafos.size());
        System.out.println("Cantidad de links <a>: " + a.size());

        System.out.println("Texto de botones del sitio");
        for (WebElement e: buttons){
            System.out.println(e.getText());
        }

        ayuda.click();

        for (WebElement e: menu){
            System.out.println(e.getText());
        }

        driver.navigate().back();
    }

    @Test
    public void sendKeysToFacebook(){
        abrirPagina("https://www.facebook.com");
        WebElement correo = driver.findElement(By.id("email"));
        WebElement pass = driver.findElement(By.id("pass"));
        WebElement botonEntrar = driver.findElement(By.name("login"));

        correo.sendKeys("test@test.com");
        pass.sendKeys("holamundo");
        botonEntrar.click();

        WebElement mje = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(mje.getText(), "Sorry, something went wrong.");
    }

    private WebElement elementoMasRepetido(){
        List<WebElement> h1 = driver.findElements(By.tagName("h1"));
        List<WebElement> h2 = driver.findElements(By.tagName("h2"));
        List<WebElement> h3 = driver.findElements(By.tagName("h3"));
        List<WebElement> buttons = driver.findElements(By.tagName("buttons"));
        List<WebElement> divs = driver.findElements(By.tagName("div"));
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        List<WebElement> links = driver.findElements(By.tagName("link"));
        int cantRepetido = 0;
        WebElement e = driver.findElement(By.tagName("div"));

        if(h1.size() > h2.size() &&
                h1.size() > h3.size() &&
                h1.size() > buttons.size() &&
                h1.size() > divs.size() &&
                h1.size() > inputs.size()
                && h1.size() > links.size()){

            e = driver.findElement(By.tagName("h1"));
        }else if(h2.size() > h3.size() &&
                 h2.size() > buttons.size() &&
                 h2.size() > divs.size() &&
                 h2.size() > inputs.size() &&
                 h2.size() > links.size()){

            e = driver.findElement(By.tagName("h2"));
        }else if(h3.size() > buttons.size() &&
                 h3.size() > divs.size() &&
                 h3.size() > inputs.size() &&
                 h3.size() > links.size()){

            e = driver.findElement(By.tagName("h3"));
        }else if(buttons.size() > divs.size() &&
                 buttons.size() > inputs.size() &&
                 buttons.size() > links.size()){

            e = driver.findElement(By.tagName("buttons"));
        }else if(divs.size() > inputs.size() &&
                 divs.size() > links.size()){

            e = driver.findElement(By.tagName("div"));
        }else if(inputs.size() > links.size()){
            e = driver.findElement(By.tagName("input"));
        }else {
            e = driver.findElement(By.tagName("link"));
        }
        return e;
    }

    private int cantidadVecesRepetidoElemento(WebElement elemento){
        List<WebElement> listaElemento = driver.findElements(By.tagName(elemento.getTagName()));
        return listaElemento.size();
    }

    private void abrirPagina(String url){
        String chromerDriverUrl = prop.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromerDriverUrl);
        driver = new ChromeDriver();
        driver.get(url);
        //driver.manage().window().maximize();
    }

    private String getTitle(){
        return driver.getTitle();
    }

    private void search(String cadenaBuscar){
        WebElement search = driver.findElement(By.cssSelector("[name='q'"));
        search.sendKeys(cadenaBuscar + Keys.ENTER);
    }
}
