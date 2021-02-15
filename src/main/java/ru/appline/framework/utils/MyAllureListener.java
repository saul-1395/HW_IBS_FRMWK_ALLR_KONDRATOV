package ru.appline.framework.utils;

import io.qameta.allure.Attachment;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.appline.framework.managers.DriverManager;

public class MyAllureListener extends AllureJunit5 implements TestWatcher {


//  Здесь должен быть переопределённые методы или метод который позволит прикреплять скриншоты к шагу аллюра
//  Если не получается переопредилить то скопировать библиотеку AllureJunit4 себе в пакет listener
//  И прописать в конкретном месте в скопированной библиотеке строчку Allure.addAttachment();
//  Или там же прописать Allure.getLifecycle().addAttachment();


//
    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] addScreenshot() {
        return ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

//    @Override
//    public void afterEach(ExtensionContext context) throws Exception {
//        if(context.getExecutionException().get()!=null){
//            addScreenshot();
//        }
//    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        addScreenshot();
    }


//
//    @Override
//    public Map<String, String> buildFailureEvent(String type, String uuid, Throwable throwable) {
//        Map<String, String> map = new HashMap();
//        map.put("allure.fixture", type);
//        map.put("event", "failure");
//        map.put("uuid", uuid);
//        Optional<Status> maybeStatus = ResultsUtils.getStatus(throwable);
//        maybeStatus.map(Status::value).ifPresent((status) -> {
//            String var10000 = (String)map.put("status", status);
//        });
//        Optional<StatusDetails> maybeDetails = ResultsUtils.getStatusDetails(throwable);
//        maybeDetails.map(StatusDetails::getMessage).ifPresent((message) -> {
//            String var10000 = (String)map.put("message", message);
//        });
//        maybeDetails.map(StatusDetails::getTrace).ifPresent((trace) -> {
//            String var10000 = (String)map.put("trace", trace);
//        });
//
//        addScreenshot();
//        return map;
//    }
}

