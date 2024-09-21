package pages.views;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ExpandableListsSimpleAdapterPage {

    AndroidDriver androidDriver;
    String listViewXpath = "//android.widget.ExpandableListView";

    WebElement listView;
    public ExpandableListsSimpleAdapterPage(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
        this.listView = androidDriver.findElement(By.xpath(listViewXpath));
    }



    public void clickTextViewContainsText( String title){
        listView.findElement(By.xpath("//android.widget.TextView[contains(@text, '" + title + "')]")).click();

    }

    public ExpandableListsSimpleAdapterPage clickGroupFromList(String group) {
        androidDriver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\""+group+"\"));"))
                .click();

        return this;

    }

    public List<WebElement> collectChildInGroup(int lastIndex) {
        List<WebElement> elements = new ArrayList<>();
        for(int i = 0; i < lastIndex; i++){
        WebElement webElement = androidDriver
                .findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable" +
                                "(new UiSelector()" +
                                ".scrollable(true)" +
                                ".instance(0))" +
                                ".scrollIntoView(new UiSelector()" +
                                ".textContains(\"Child "+i+"\"))"));
            System.out.println(webElement.getText());
        elements.add(webElement);
        }

        return elements;
    }
}
