package BAPB;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;


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
        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.MILLISECONDS);
    }

    @AfterAll
    public static void afterClass() throws MalformedURLException {
        driver.quit();
    }


    @AfterEach
    @Description("Нажать Главная, после теста")
    public void afterTest() throws MalformedURLException {
        WebElement glavnaya = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout[1]");
        glavnaya.click();
    }

    @Attachment(value = "{0}")
    public byte[] saveScreenshot(String message) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    @org.junit.jupiter.api.Test
    @Feature(value = "Авторизация")
    @Description("Вход по логину, паролю")
    public void testDBOTEST_1() throws MalformedURLException {

        LogUtil.log("Step 1 - Выбрать обычный режим");
        WebElement step1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RadioButton[1]"));
        step1.click();

        LogUtil.log("Step 2 - Нажать Войти");
        WebElement step2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button"));
        step2.click();

//        ТУТ НУЖНЕН ЯВНЫЙ DRIVERwAIT

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
        LogUtil.log("Step 1 - Нажать Платежи");
        WebElement step1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ImageView"));
        step1.click();
        LogUtil.log("Step 2 - Свайп");

        WebElement functionalStep = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView"));
        functionalStep.click();

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
        LogUtil.log("Step 1 - Нажать Еще");
        WebElement step1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout[5]"));
        step1.click();
        LogUtil.log("Step 2 - нажать курсы валют");
        WebElement step2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[4]/android.widget.TextView"));
        step2.click();
        LogUtil.log("Step 3 - переключиться на Карточки");
        WebElement step3 = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Карточки\"]"));
        saveScreenshot("Скриншот Наличные");
        step3.click();
        LogUtil.log("Step 4 - переключиться на НБРБ");
        WebElement step4 = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"НБРБ\"]"));
        saveScreenshot("Скриншот Карточки");
        step4.click();
        LogUtil.log("Step 5 - переключиться на ЦБРФ");
        WebElement step5 = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"ЦБРФ\"]"));
        saveScreenshot("Скриншот НБРБ");
        step5.click();
        saveScreenshot("Скриншот ЦБРФ");
                  }


    @org.junit.jupiter.api.Test
    @Features(value = {@Feature(value = "Вклады")})
    @Story(value = "Выписка по вкладу")
    @Description("Просмотр выписки по вкладу")
    public void testDBOTEST_4() throws MalformedURLException {
        LogUtil.log("Step 1 - Нажать Депозиты");
        WebElement step1 = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Депозиты\"]"));
        step1.click();
        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.MILLISECONDS);
        LogUtil.log("Step 2 - перейти в первый депозит");
        WebElement step2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup"));
        step2.click();
        LogUtil.log("Step 3 - нажать Выписка");
        WebElement step3 = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Выписка\"]"));
        step3.click();
        LogUtil.log("Step 4 - нажать список За месяц");
        WebElement step4 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup"));
        step4.click();
        LogUtil.log("Step 5 - выбрать За неделю");
        WebElement step5 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout"));
        step5.click();
        LogUtil.log("Step 6 - нажать список За неделю");
        WebElement step6 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup"));
        step6.click();
        LogUtil.log("Step 7 - нажать выбрать период");
        WebElement step7 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout"));
        step7.click();
        LogUtil.log("Step 8 - нажать на год");
        WebElement step8 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TabHost/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
        step8.click();
        LogUtil.log("Step 9 - выбрать предыдущий год");
        WebElement step9 = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"2020\"]"));
        step9.click();
        LogUtil.log("Step 10 - нажать ОК");
        WebElement step10 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
        step10.click();
        saveScreenshot("Выписка по вкладу за год");
        //надо еще нажать назад
        LogUtil.log("Step 11 - нажать Назад");
        WebElement step11 = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Перейти вверх\"]"));
        step11.click();
    }

    @org.junit.jupiter.api.Test
    @Features(value = {@Feature(value = "Платежи")})
    @Story(value = "Ерип-velcom")
    @Description("Оплата velcom через ЕРИП")
    public void testDBOTEST_5() throws MalformedURLException {
        LogUtil.log("Step 1 - Нажать Платежи");
        WebElement step1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout[2]"));
        step1.click();
        LogUtil.log("Step 2 - Нажать Оплата услуг");
        WebElement step2 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.LinearLayout");
        step2.click();
        LogUtil.log("Step 3 - Нажать Мобильная связь");
        WebElement step3 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]");
        step3.click();
        LogUtil.log("Step 4 - Нажать Velcom");
        WebElement step4 =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout");
        step4.click();
        LogUtil.log("Step 5 - Ввести номер телефона 445368332");
        WebElement step5 =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
        step5.sendKeys(new String("4453683320"));
        LogUtil.log("Step 6 - Нажать Продолжить");
        WebElement step6 =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.Button");
        step6.click();
        LogUtil.log("Step 7 - ввести сумму 1 BYN");
        WebElement step7 =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
        step7.sendKeys(new String("1"));

        LogUtil.log("Step 8 - свайп");
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

        LogUtil.log("Step 9 - ввести мобильный ключ anastasia18");
        WebElement step9 =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
        step9.sendKeys(new String("anastasia18"));

        LogUtil.log("Step 10 - Нажать оплатить 1 BYN");
        WebElement step10 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.Button"));
        step10.click();

        LogUtil.log("Step 11 - Нажать ОК в окне ошибки");
        WebElement step11 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button"));
        step11.click();

        LogUtil.log("Step 12 - нажать Назад 2 раза");
        WebElement step12 =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton");
        step12.click();
        step12.click();

    }



}
