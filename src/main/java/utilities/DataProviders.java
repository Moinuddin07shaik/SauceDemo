package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders 
{

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            {"standard_user", "secret_sauce"}
           
        };
    }
}
