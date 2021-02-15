package ru.appline.framework.utils;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestWatcher implements AfterTestExecutionCallback {
    WebDriver driver;
 @Override
 public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
  Object test = extensionContext.getRequiredTestInstance();
  Field a = test.getClass().getDeclaredField("driver");
  a.setAccessible(true);
   driver = (WebDriver) a.get(test);

  Method method = extensionContext.getRequiredTestMethod();
  if (extensionContext.getExecutionException().isPresent()) {
   makeScreenshotOnFailure(method.getName());
  }
 }

    @Attachment(value = "{testName} - screenshot", type = "image/png")
    private byte[] makeScreenshotOnFailure(String testName) {

        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
