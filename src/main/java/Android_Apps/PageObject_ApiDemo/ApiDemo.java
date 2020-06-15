package Android_Apps.PageObject_ApiDemo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;

public class ApiDemo extends GlobalDependences {

@Test(dataProvider = "InputData",dataProviderClass = TestData.class)
public void ApiDemo(String input) throws Exception {
  service=AppiumStartServer();
  AndroidDriver<AndroidElement> driver= setup("ApiDemo");
  HomePage h=new HomePage(driver);
  h.Preferences.click();
  Preferences p=new Preferences(driver);
  p.PreferenceDependencies.click();
//    driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
//    driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
    driver.findElementById("android:id/checkbox").click();
    driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
    driver.findElementByClassName("android.widget.EditText").sendKeys(input);
    driver.findElementsByClassName("android.widget.Button").get(1).click();
    service.stop();
}

}
