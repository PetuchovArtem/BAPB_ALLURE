package BAPB;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.TakesScreenshot;

public final class LogUtil {

    private LogUtil() {
    }

    @Step("{0}")
    public static void log(final String message){
        //intentionally empty
    }


}