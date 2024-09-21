package pages.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class AppPage {

    AndroidDriver androidDriver;

    public AppPage(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
    }



    public void clickTextView( String title){
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + title + "']")).click();

    }
}
