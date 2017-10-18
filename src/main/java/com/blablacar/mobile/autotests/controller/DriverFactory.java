package com.blablacar.mobile.autotests.controller;

import com.blablacar.mobile.autotests.tools.ConfigData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DriverFactory {


    public static AppiumDriver getDriver (String deviceOS) throws MalformedURLException, IOException {
        AppiumDriver driver;
        File file;
        DesiredCapabilities desiredCapabilities;
        String apkSource;


        if(deviceOS.toLowerCase().equals("ios")){

            file = new File("C:\\ipa", "blablacar.ipa");
            desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "ios");
            desiredCapabilities.setCapability("deviceName", "iosTestDevice");
            desiredCapabilities.setCapability("app", file.getAbsolutePath());

            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        } else {
            if (ConfigData.getConfigValue("env").equals("prod")) {
                apkSource = "C:\\apk\\blablacar\\prod";
            }else{
                apkSource = "C:\\apk\\blablacar\\qa";
            }
            file = new File(apkSource, "BlaBlaCar_com.comuto.apk");
            desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("deviceName", "androidTestDevice");
            desiredCapabilities.setCapability(CapabilityType.PLATFORM, "Android");
            desiredCapabilities.setCapability("platformVersion", "5");
            desiredCapabilities.setCapability("app", file.getAbsolutePath());
            //desiredCapabilities.setCapability("appPackage", "");
            //desiredCapabilities.setCapability("appActivity", "");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);


        }

        //implicitly wait
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        return driver;
    }

}
