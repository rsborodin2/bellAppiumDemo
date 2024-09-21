package drivers;

import static org.junit.jupiter.api.Assertions.assertTrue;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import javax.annotation.Nonnull;


import Config.Properties;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

/**
 * Класс для инициализации AndroidDriver
 */
public class EmulatorDriver {
    public static AndroidDriver driver;

    public static AndroidDriver setUpEmulatorDriver(){
        File app = new File(Properties.apiDemosProperties.apkPath());

        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid(Properties.emulatorProperties.udid())
                .setApp(Properties.apiDemosProperties.apkPath());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", Properties.emulatorProperties.deviceName());
        capabilities.setCapability("platformName", Platform.ANDROID);
        capabilities.setCapability("automationName", AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability("appPackage", Properties.apiDemosProperties.appPackage());
        capabilities.setCapability("appActivity", Properties.apiDemosProperties.appActivity());
        capabilities.setCapability("app", app.getAbsolutePath());

        // it uninstalls the app and re-installs each time you re-run your suite
        capabilities.setCapability("noResetValue","false");
        capabilities.setCapability("clearDeviceLogsOnStart", true);

        driver = new AndroidDriver(getUrl(Properties.appiumServerProperties.remoteAddress()), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    /**
     * Валидация URL ссылки из пропертей
     * @return
     */
    public static URL getUrl(String URL) {
        try {
            return new URL(URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


}
