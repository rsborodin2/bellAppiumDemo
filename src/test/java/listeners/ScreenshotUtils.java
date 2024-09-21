package listeners;

import com.google.common.io.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;

public class ScreenshotUtils {
    @Attachment(type = "image/png")
    public static void screenshot(AndroidDriver driver) throws IOException{
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.toByteArray(screen);
    }
}