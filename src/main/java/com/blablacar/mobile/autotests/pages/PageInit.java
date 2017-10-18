package com.blablacar.mobile.autotests.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageInit {

    AppiumDriver driver;
    WebDriverWait waitForCondition ;
    Logger pageLogger;

    public PageInit(AppiumDriver driver){

        pageLogger = Logger.getLogger(PageInit.class);
        waitForCondition = new WebDriverWait (driver, 15 );
        this.driver=driver;
    }

    protected void swipeUp(){
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.6);
        int endy = (int) (size.height * 0.2);
        int startx = size.width / 2;
        driver.swipe(startx, starty, startx, endy, 200);
    }

    protected void swipeLeft(){
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height/2);
        int startx = (int) (size.width * 0.8);
        int endx = (int) (size.width * 0.2);
        driver.swipe(startx, starty, endx, starty, 300);
    }

    public void moveBack() {
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }

}
