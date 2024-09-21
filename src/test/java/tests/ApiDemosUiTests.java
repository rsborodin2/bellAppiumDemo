package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import io.qameta.allure.Allure;
import pages.app.AppPage;
import pages.app.activity.ActivityPage;
import pages.app.activity.CustomDialogPage;
import pages.app.fragment.FragmentPage;
import pages.app.fragment.StackPage;
import pages.text.LogTextBoxPage;
import pages.text.TextPage;
import pages.views.ExpandableListsPage;
import pages.views.ExpandableListsSimpleAdapterPage;
import pages.LandingPage;
import pages.views.ViewsPage;

public class ApiDemosUiTests extends BaseTest {

    @Tag("SMOKE")
    @DisplayName("[Views][Expandable Lists] поворот экрана при заполненном текстовом поле")
    @Test
    public void expandableListTest() {
        {
            Allure.step("Первый шаг",()->{
                new LandingPage(driver).clickTextViewByContentDesc("Views");
                new ViewsPage(driver).clickTextView("Expandable Lists");
                new ExpandableListsPage(driver).clickTextViewContainsText("Simple Adapter");
                List<WebElement> childInGroup = new ExpandableListsSimpleAdapterPage(driver)
                        .clickGroupFromList("Group 18")
                        .collectChildInGroup(14);
                Assertions.assertEquals(14,childInGroup.size());
            });
        }
    }

    @Tag("SMOKE")
    @Test
    public void appCustomDialogTest() {
            Allure.step("Первый шаг",()->{
                new LandingPage(driver).clickTextViewByContentDesc("App");
                new AppPage(driver).clickTextView("Activity");
                new ActivityPage(driver).clickTextViewByText("Custom Dialog");
                String expectedTitle = "App/Activity/Custom Dialog";
                String actualTitle = new CustomDialogPage(driver).title.getText();
                Assertions.assertEquals(actualTitle,expectedTitle);
                driver.navigate().back();
                new ActivityPage(driver);
            });
}
    @Test
    @Tag("SMOKE")
    @DisplayName("[Text][LogTextBox] поворот экрана при заполненном текстовом поле")
    public void logTextBoxChangeOrientationTest() {
        Allure.step("Первый шаг",()->{
            new LandingPage(driver).clickTextViewByContentDesc("Text");
            new TextPage(driver).clickTextView("LogTextBox");
            LogTextBoxPage logTextBoxPage =new LogTextBoxPage(driver);
            logTextBoxPage.addButton.click();
            Assertions.assertFalse(logTextBoxPage.getTextBox().getText().isBlank());
            driver.rotate(ScreenOrientation.LANDSCAPE);
            // После поворота экрана текст в поле исчезает из-за уничтожения Activity
           (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(logTextBoxPage.textBox)));
            Assertions.assertTrue(logTextBoxPage.getTextBox().getText().isBlank());
        });
    }

    @DisplayName("[App][Fragment][Stack] навигация по стеку фрагментов, добавление и удаление фрагментов из стека")
    @Test
    public void stackActivitiesTest(){
        new LandingPage(driver).clickTextViewByContentDesc("App");
        new LandingPage(driver).clickTextViewByContentDesc("Fragment");
        new FragmentPage(driver).clickTextViewByText("Stack");
        StackPage stackPage = new StackPage(driver);
        Assertions.assertEquals("Fragment #1",stackPage.getCurrentFragmentInStack());
        stackPage.addFragment();
        Assertions.assertEquals("Fragment #2",stackPage.getCurrentFragmentInStack());
        stackPage.deleteFragment();
        Assertions.assertEquals("Fragment #1",stackPage.getCurrentFragmentInStack());
        stackPage.addFragment();
        Assertions.assertEquals("Fragment #3",stackPage.getCurrentFragmentInStack());
        driver.navigate().back();
        Assertions.assertEquals("Fragment #1",stackPage.getCurrentFragmentInStack());
    }

    @DisplayName("[App][Loader] Загрузка в лоадере списка приложений и поиск приложений")
    @Test
    public void searchAppInLoaderTest(){

    }
}
