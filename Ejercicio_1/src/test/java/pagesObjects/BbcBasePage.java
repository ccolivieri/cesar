package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BbcBasePage {

    protected WebDriver driver;

    public BbcBasePage(WebDriver aDriver){
        driver = aDriver;
    }

    public void clickOnRegisterNow(){
        driver.findElement(By.id("idcta-link")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Register now')]")).click();

        WebDriverWait waitButton = new WebDriverWait(driver, 10);
        boolean invisible =waitButton.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner spinner--fill']")));
        if(invisible){
            driver.findElement(By.xpath("(//a[@class = 'button'])[2]")).click();
        }
    }
}
