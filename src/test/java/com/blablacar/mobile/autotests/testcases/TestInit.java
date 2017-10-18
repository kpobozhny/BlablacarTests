package com.blablacar.mobile.autotests.testcases;

import com.blablacar.mobile.autotests.controller.DriverFactory;
import com.blablacar.mobile.autotests.pages.*;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriverException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Kostiantyn Pobozhni on 08.02.2017.
 */
public abstract class TestInit {



    private static final String EOL = System.getProperty("line.separator");
    private static StringBuilder builder = new StringBuilder();
    static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    static Date date = new Date();
    static Logger log;
    public static AppiumDriver driver;
    //WebDriverWait waitForCondition ;




    @Rule
    public TestWatcher watchman = new TestWatcher() {

        @Override
        protected void failed(Throwable e, Description description) {
            builder.append("------------->\n");
            if (description != null) {
                builder.append(description);
            }
            if (e != null) {
                builder.append(' ');
                builder.append(e);
            }
            builder.append(" FAIL");
            builder.append(EOL);
        }

        @Override
        protected void succeeded(Description description) {
            builder.append("------------->\n");
            if (description != null) {

                builder.append(description);
            }
            builder.append(" OK");
            builder.append(EOL);
        }
    };

    @BeforeClass
    public static void setUp() throws MalformedURLException, IOException {

        driver = DriverFactory.getDriver("android");

        PropertyConfigurator.configure("src/main/resources/prop/log4j.properties");
        log = Logger.getLogger(TestInit.class);

    }

    @AfterClass
    public static void tearDown(){

        log.info("-------------TESTS RESULTS (on "+ dateFormat.format(date)+") -----------");
        log.info(builder);
        log.info("----------END OF TEST RESULTS---------\n");


        driver.quit();
    }

    public void hideKeyboardIfAppears(){
        try{
            driver.hideKeyboard();
        }catch(WebDriverException e){}

    }


}
