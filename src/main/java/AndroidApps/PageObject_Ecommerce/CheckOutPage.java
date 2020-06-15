package AndroidApps.PageObject_Ecommerce;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckOutPage {

    public CheckOutPage(AndroidDriver driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    public List<WebElement> ProductPriceList;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    public WebElement TotalAmount;

    @AndroidFindBy(className = "android.widget.CheckBox")
    public WebElement CheckBox;

    @AndroidFindBy(xpath = "//*[@text='Please read our terms of conditions']")
    public WebElement TermsConditions;
}
