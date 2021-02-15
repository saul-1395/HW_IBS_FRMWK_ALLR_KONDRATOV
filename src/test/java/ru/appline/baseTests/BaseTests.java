package ru.appline.baseTests;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import ru.appline.framework.managers.PageManager;
import ru.appline.framework.utils.MyAllureListener;

import static ru.appline.framework.managers.DriverManager.getWebDriver;
import static ru.appline.framework.managers.InitManager.initFramevork;
import static ru.appline.framework.managers.InitManager.quitFramework;
import static ru.appline.framework.managers.PropertyManager.getPropertyManager;
import static ru.appline.framework.utils.PropertyConst.APP_URL;

@ExtendWith(MyAllureListener.class)
public class BaseTests {

    protected JavascriptExecutor jse;
    protected PageManager app = PageManager.getPageManager();

    @BeforeAll
    static void beforeAll() {
        initFramevork();
    }

    @BeforeEach
    void beforeEach() {
        getWebDriver().get(getPropertyManager().getProperties(APP_URL));
        jse = (JavascriptExecutor) getWebDriver();
    }

    @AfterAll
    static void afterAll() {
        quitFramework();
    }

}