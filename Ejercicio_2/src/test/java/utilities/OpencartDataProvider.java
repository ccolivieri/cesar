package utilities;

import org.testng.annotations.DataProvider;

public class OpencartDataProvider {

    @DataProvider(name = "emailsNoRegistrados")
    public static Object[][] getEmailsNoRegister(){

        return new Object[][]{
                {"test1@test.com", "abcde"},
                {"test2@test.org", "fghij"},
                {"test3@test.com", "klmno"}
        };
    }
}
