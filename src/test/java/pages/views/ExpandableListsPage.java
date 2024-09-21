package pages.views;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ExpandableListsPage {

    AndroidDriver androidDriver;
    String listViewXpath = "//android.widget.ListView";

    WebElement listView;
    public ExpandableListsPage(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
        this.listView = androidDriver.findElement(By.xpath(listViewXpath));
    }



    public void clickTextViewContainsText( String title){
        listView.findElement(By.xpath("//android.widget.TextView[contains(@text, '" + title + "')]")).click();

    }
}
