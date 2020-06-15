package Android_Apps.PageObject_ApiDemo;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "InputData")
    public Object[][] InputDataForTextField() {
        Object[][] Obj = new Object[][]
                {

                {"abcd"}, {"!@#$"}
        };
        return Obj;
    }
}
