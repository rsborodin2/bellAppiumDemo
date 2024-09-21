package pages.views;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ViewsPage {

    AndroidDriver androidDriver;
    String listViewXpath = "//android.widget.ListView";

    WebElement listView;
    public ViewsPage(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
        this.listView = androidDriver.findElement(By.xpath(listViewXpath));
    }



    public void clickTextView( String title){
        listView.findElement(By.xpath("//android.widget.TextView[@text='" + title + "']")).click();

    }
}
