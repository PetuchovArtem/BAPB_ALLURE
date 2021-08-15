package BAPB;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.*;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;

public class Test {

    public static AndroidDriver driver;

    @BeforeAll
    public static void beforeClass() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "RZ8MA0W1R9F");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.alseda.bapb");
        capabilities.setCapability("appActivity", "com.alseda.features.start.splash.view.SplashActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
    
    @AfterEach
    @Description("Нажать Главная, после теста")
    public void afterTest() throws MalformedURLException {
        WebElement glavnaya = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout[1]");
        glavnaya.click();
    }


    @org.junit.jupiter.api.Test
    @Feature(value = "Авторизация")
    @Description("Вход по логину, паролю")
    public void testDBOTEST_1() throws MalformedURLException {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        LogUtil.log("Step 1 - Выбрать обычный режим");
        WebElement step1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RadioButton[1]"));
        step1.click();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        LogUtil.log("Step 2 - Нажать Войти");
        WebElement step2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button"));
        step2.click();
        driver.manage().timeouts().implicitlyWait(400000, TimeUnit.MILLISECONDS);
        LogUtil.log("Step 3 - Согласиться с Задать пинкод для входа в приложение");
        WebElement step3 =  driver.findElementById("com.alseda.bapb:id/positiveBtnHorizontal");
        step3.click();
        LogUtil.log("Step 4 - Создание пина");
        WebElement step4 = driver.findElementById("com.alseda.bapb:id/pin_oneButton");
        for (int count = 0; count < 10; count++) {
            step4.click();
        }
        LogUtil.log("Step 5 - Разрешить доступ к физическим активностям");
        WebElement step5 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]"));
        step5.click();
    }

    @org.junit.jupiter.api.Test
    @Feature(value = "Быстрые платежи")
    @Description("Просмотр быстрых платежей")
    public void testDBOTEST_2() throws MalformedURLException {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        LogUtil.log("Step 1 - Нажать Платежи");
        WebElement step1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ImageView"));
        step1.click();
        LogUtil.log("Step 2 - Свайп");

        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = driver.manage().window().getSize();
        int edgeBorder = 10;
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);

        new TouchAction(driver)
                .press(pointOptionStart)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .moveTo(pointOptionEnd)
                .release().perform();
    }

    @org.junit.jupiter.api.Test
    @Features(value = {@Feature(value = "Вкладка Еще")})
    @Story(value = "Курсы валют")
    @Description("Просмотр курсов валют")
    public void testDBOTEST_3() throws MalformedURLException {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        LogUtil.log("Step 1 - Нажать Еще");
        WebElement step1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout[5]"));
        step1.click();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        LogUtil.log("Step 2 - нажать курсы валют");
        WebElement step2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[4]/android.widget.TextView"));
        step2.click();
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
        LogUtil.log("Step 3 - переключиться на Карточки");
        WebElement step3 = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Карточки\"]"));
        step3.click();
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
        LogUtil.log("Step 4 - переключиться на НБРБ");
        WebElement step4 = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"НБРБ\"]"));
        step4.click();
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
        LogUtil.log("Step 5 - переключиться на ЦБРФ");
        WebElement step5 = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"ЦБРФ\"]"));
        step5.click();
                  }


}
