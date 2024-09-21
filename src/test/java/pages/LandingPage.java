package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import pages.base.BasePage;
import tests.BaseTest;

public class LandingPage extends BasePage {

    AndroidDriver androidDriver;
    String listViewXpath = "//android.widget.ListView";

    WebElement listView;

    public LandingPage(AndroidDriver androidDriver){
        super(androidDriver);
        this.listView = androidDriver.findElement(By.xpath(listViewXpath));
    }

    public void clickTextViewByContentDesc( String title){
        listView.findElement(By.xpath("//android.widget.TextView[@content-desc='" + title + "']")).click();

    }
}
