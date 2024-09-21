package pages.base;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class BasePage {

    protected AndroidDriver androidDriver;


    public BasePage(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
    }

    public void clickTextViewByText(String title){
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + title + "']")).click();
    }

}
