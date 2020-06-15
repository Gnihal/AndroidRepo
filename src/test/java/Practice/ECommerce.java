package Practice;

import AndroidApps.PageObject_Ecommerce.CheckOutPage;
import AndroidApps.PageObject_Ecommerce.FormPage;
import Android_Apps.PageObject_ApiDemo.GlobalDependences;
import AndroidApps.PageObject_Ecommerce.Utilities;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class ECommerce extends GlobalDependences {


    @Test
    public void totalValidation() throws Exception {
        service=AppiumStartServer();
        AndroidDriver<AndroidElement> driver = setup("generalstore");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        FormPage f=new FormPage(driver);
        f.CountryTap.click();
        Utilities u=new Utilities(driver);
        u.ScrollToView("Bahamas");
        f.NameField.sendKeys("Nihal");
        driver.hideKeyboard();
        f.RadioButtonField.click();
        f.LetsShopButton.click();
        f.AddToCartList1.get(0).click();
        f.AddToCartList2.get(0).click();
        u.tap(driver,f.CartButton);
        Thread.sleep(4000);
        CheckOutPage Coutpg=new CheckOutPage(driver);

        int count = Coutpg.ProductPriceList.size();
        double sum = 0;
        for (int i = 0; i < count; i++) {
            String amount1 = Coutpg.ProductPriceList.get(i).getText();
            double amount = getAmount(amount1);
            sum = sum + amount;
        }
        System.out.println("SumofProduct" + sum);
        String totalamount = Coutpg.TotalAmount.getText();
        totalamount = totalamount.substring(1);
        double totalamountvalue = Double.parseDouble(totalamount);
        Assert.assertEquals(sum, totalamountvalue);
        WebElement checkbox = Coutpg.CheckBox;
        TouchAction t = new TouchAction(driver);
        t.tap(tapOptions().withElement(element(checkbox))).perform();
        WebElement tc = Coutpg.TermsConditions;
        t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();
        driver.findElement(By.id("android:id/button1")).click();
        service.stop();
  }
    public static double getAmount(String value) {
        value = value.substring(1);
        double amountvalue = Double.parseDouble(value);
        return amountvalue;
    }
    @BeforeTest
    public static void KillAllProcess() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(3000);
    }
}
