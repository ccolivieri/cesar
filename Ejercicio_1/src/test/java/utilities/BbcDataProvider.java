package utilities;

import org.testng.annotations.DataProvider;

public class BbcDataProvider {

    @DataProvider(name = "emails")
    public static Object[][] getEmails(){
        return new Object[][]{
                {"pepe@yahoo.com.ar", "pepe736"},
                {"juan_35@gmail.com", "Y827J"},
                {"elena_land@hotmail.com", "El3n4Ig"}
        };
    }
}
