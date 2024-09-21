package pages.app.fragment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import pages.base.BasePage;

public class StackPage extends BasePage {

    By textBoxSelector = new By.ById("io.appium.android.apis:id/text");
    By newFragmentButtonSelector = new By.ById("io.appium.android.apis:id/new_fragment");
    By deleteFragmentButtonSelector = new By.ById("io.appium.android.apis:id/delete_fragment");

    public WebElement newFragmentButton;
    public WebElement deleteFragmentButton;
    public WebElement textBox;

    public StackPage(AndroidDriver androidDriver) {
        super(androidDriver);
        this.textBox = androidDriver.findElement(textBoxSelector);
        this.newFragmentButton = androidDriver.findElement(newFragmentButtonSelector);
        this.deleteFragmentButton = androidDriver.findElement(deleteFragmentButtonSelector);

    }

    public String getCurrentFragmentInStack() {
        return androidDriver.findElement(textBoxSelector).getText();
    }

    public StackPage addFragment(){
        androidDriver.findElement(newFragmentButtonSelector).click();
        return this;
    }

    public StackPage deleteFragment(){
        androidDriver.findElement(deleteFragmentButtonSelector).click();
        return this;
    }

}
