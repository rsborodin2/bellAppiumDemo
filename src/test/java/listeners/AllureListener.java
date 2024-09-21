package listeners;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.UUID;

import drivers.EmulatorDriver;
import io.qameta.allure.Attachment;

/**
 * Кастомный листенер для переопределения логики завершения теста
 */
public class AllureListener implements AfterTestExecutionCallback {



    /**
     * Метод добавления скриншота в аллюра отчета через аннотацию
     * @param screenShot байты скриншотов
     * @return
     */
    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    /**
     * Переопределение логики завершения тестов у juni5
     * @param context контекст теста
     */
    @Override
    public void afterTestExecution(ExtensionContext context) throws IOException {
        Method testMethod = context.getRequiredTestMethod(); //получаем тестовый метод
        String testName = testMethod.getName(); //получаем название тестового метода
        boolean testFailed = context.getExecutionException().isPresent();//проверяем упал ли тест
//        if (!testFailed) {//если тест упал
            screenshot("src/main/resources/");
       // }
    }

    public void screenshot(String path_screenshot) throws IOException {
        File srcFile= EmulatorDriver.driver.getScreenshotAs(OutputType.FILE);
        String filename= UUID.randomUUID().toString();
        File targetFile=new File(path_screenshot + filename +".jpg");
        FileUtils.copyFile(srcFile, targetFile);
    }


}

