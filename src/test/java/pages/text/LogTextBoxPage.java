package pages.text;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class LogTextBoxPage {

    AndroidDriver androidDriver;
    By addButtonSelector = new By.ById("io.appium.android.apis:id/add");
    By textBoxSelector = new By.ById("io.appium.android.apis:id/text");
    public WebElement addButton;
    public WebElement textBox;


    public LogTextBoxPage(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
        this.addButton = this.androidDriver.findElement(addButtonSelector);
        this.textBox = this.androidDriver.findElement(textBoxSelector);
    }

    public WebElement getTextBox() {
        return androidDriver.findElement(textBoxSelector);
    }
}
