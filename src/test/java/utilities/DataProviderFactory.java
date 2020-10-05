package utilities;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {

    @DataProvider(name = "emails")
    public static Object[][] getEmailsDataProvider(){
        return new Object[][]{
                {"juan_i7@@yahoo.com"},
                {"pedro@gmailcom.ar"},
                {"alicia_soto@gmail..com"}
        };
    }
}
