package tests;

import static utils.DeviceHelper.executeBash;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import drivers.EmulatorDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.qameta.allure.Allure;
import listeners.ScreenshotUtils;

public class BaseTest {
    static AppiumDriverLocalService service;
    AndroidDriver driver;
    @BeforeAll
    public static void beforeAll() {
        //service = AppiumDriverLocalService.buildDefaultService();
        //service.start();
    }

    @AfterAll
    public static void afterAll(){
           // service.stop();

        }

    @AfterEach
    public void afterEach() throws IOException {
        ScreenshotUtils.screenshot(driver);
        Allure.addAttachment("screen dump",driver.getPageSource());
//        Allure.addAttachment("Логи logcat",driver.manage().logs().get("logcat").toJson().toString());
        try {
            driver.quit();
        } catch (Exception ignored) {}
    }

    @BeforeEach
    public void beforeEach() throws IOException, ExecutionException, InterruptedException {
//        UiAutomator2Options options = new UiAutomator2Options()
//                .setUdid("emulator-5554")
//                .setApp("src/test/resources/apk/ApiDemos-debug.apk");
//        File app = new File("apk/ApiDemos-debug.apk");
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("deviceName", "androidDevice");
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("automationName","UiAutomator2");
//        capabilities.setCapability("appPackage", "io.appium.android.apis");
//        capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
//        capabilities.setCapability("app", app.getAbsolutePath());
//
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver = EmulatorDriver.setUpEmulatorDriver();
        Allure.addAttachment("Время на устройстве",driver.getDeviceTime());
        Allure.addAttachment("Текущий пакет", Objects.requireNonNull(driver.getCurrentPackage()));
        Allure.addAttachment("Статус",driver.getStatus().toString());
        Allure.addAttachment("Размер экрана",driver.getDisplayDensity().toString());
       // Allure.addAttachment("Версия АПК", executeBash("adb shell dumpsys package io.appium.android.apis | grep versionName").split("=")[1]);
      //  disableAnimationOnEmulator();
    }

    /**
     * Отключение анимаций на эмуляторе чтобы не лагало
     */
    private static void disableAnimationOnEmulator() throws IOException, ExecutionException, InterruptedException {
        executeBash("adb -s shell settings put global transition_animation_scale 0.0");
        executeBash("adb -s shell settings put global window_animation_scale 0.0");
        executeBash("adb -s shell settings put global animator_duration_scale 0.0");
        executeBash("adb -s shell sdumpsys package io.appium.android.apis | grep version");

    }


}
