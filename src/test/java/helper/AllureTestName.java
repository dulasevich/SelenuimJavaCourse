package helper;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;

public class AllureTestName {

    public static void setTestName(String name) {
        AllureLifecycle lifecycle = Allure.getLifecycle();
        lifecycle.updateTestCase(testResult -> testResult.setName(name));
    }
}
