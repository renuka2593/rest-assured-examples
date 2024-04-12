package in.reqress.dataproviders;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "pageNumbers")
    public static Object[][] pageNumbers() {
        return new Object[][]{
                {1}
        };
    }
}
