package AndroidApps.PageObject_Ecommerce;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class Utilities {
    AndroidDriver driver;
    FormPage f=new FormPage(driver);

    public Utilities(AndroidDriver driver) {
        this.driver = driver;
    }

    public void ScrollToView(String text) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));").click();
    }

    public void tap(AndroidDriver<AndroidElement> driver,String text)
    {

        new TouchAction<>(driver).tap(ElementOption.element(driver.findElement(By.id(text)))).release().perform();
    }



  //  public void LongPress(String text) {
//
//        driver.longPress(longPressOptions().withElement(element("text")).withDuration(ofSeconds(2))).release().perform();
//    }
}
