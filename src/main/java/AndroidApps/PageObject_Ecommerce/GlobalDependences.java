package AndroidApps.PageObject_Ecommerce;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

public class GlobalDependences {
    public static AndroidDriver<AndroidElement> driver;
    public AppiumDriverLocalService service; //<------object of appium local services------->

    public AppiumDriverLocalService AppiumStartServer() {         //Method created to start Appium services
        boolean flag = checkIfServerIsRunning(4723);
        if (!flag) {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }

        return service;
    }

    public static boolean checkIfServerIsRunning(int port) {       //Method created to check if Appium is already in running state

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public static void StartEmulator() throws IOException, InterruptedException {       //Method to start Emulator

        Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\StartEmulator.bat"); // bat file create to invoke emulator automatically
        Thread.sleep(40000);
    }

    public static AndroidDriver<AndroidElement> setup(String appName) throws Exception {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        File f = new File("src");
        File fs;
        fs = new File(f, (String) prop.get(appName));
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
       // String device = (String) prop.get("device");
        String device =System.getProperty("deviceName");
        if (device.contains("emulator")) ;
        {
            StartEmulator();
        }
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "device");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
//          <--capability stored in project-->
        cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
//          cap.setCapability(MobileCapabilityType.APP,"D:\\TestNG Learing\\generalstore.apk");  //<--capabilitity for app stored in drives-->
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<AndroidElement>(url, cap);
        System.out.println("Application started");
        return driver;
    }

    public static void Screenshot(String s) throws IOException {
        File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + "\\" + s + ".png"));
    }

    @Test
    public void SampleTest() {
        System.out.println("I am inSide test");
    }
}
