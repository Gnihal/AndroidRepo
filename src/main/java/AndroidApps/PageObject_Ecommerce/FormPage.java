package AndroidApps.PageObject_Ecommerce;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FormPage {

    public FormPage(AndroidDriver driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
     public WebElement CountryTap;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    public WebElement NameField;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
    public WebElement RadioButtonField;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    public WebElement LetsShopButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    public List<WebElement> AddToCartList1;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    public List<WebElement> AddToCartList2;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    public String CartButton;
}
