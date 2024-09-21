package pages.app.activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class CustomDialogPage {
    AndroidDriver androidDriver;
    By titleSelector = By.id("android:id/title");
    public WebElement title;

    public CustomDialogPage(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
        this.title = androidDriver.findElement(titleSelector);
    }

}
