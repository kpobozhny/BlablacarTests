package com.blablacar.mobile.autotests.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kostiantyn Pobozhni on 18.10.2017.
 */
public class FirstPage extends PageInit{

    public FirstPage(AppiumDriver driver){

        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
    }

    @FindBy(xpath = ".//*[@resource-id='android:id/button2']")
    private MobileElement alertNo;

    @FindBy(xpath = ".//*[@resource-id='com.comuto:id/on_boarding_skip_textView']")
    private MobileElement buttonSkipTextView;

    @FindBy(xpath = ".//*[@resource-id='com.comuto:id/next_textView']")
    private MobileElement buttonNextView;

    @FindBy(xpath = ".//*[@class='android.widget.FrameLayout' and @index='21']")
    private MobileElement switcherUkraine;

    @FindBy(xpath = ".//*[@resource-id='com.comuto:id/modal_footer_negative_button']")
    private MobileElement skipButton;

    @FindBy(xpath = ".//*[@resource-id='com.comuto:id/subheader_title']")
    private MobileElement subheader;

    @FindBy(xpath = ".//*[@resource-id='com.comuto:id/select_country_button']")
    private MobileElement selectCountryButton;
    //--------------------
    @FindBy(xpath = ".//*[@resource-id='com.comuto:id/your_rides']")
    private MobileElement ridesButton;

    @FindBy(xpath = ".//*[@resource-id='com.comuto:id/search']")
    private MobileElement searchButton;

    @FindBy(xpath = ".//*[@resource-id='com.comuto:id/profile']")
    private MobileElement profileButton;

    //--------------------------
    @FindBy(xpath = ".//*[@resource-id='com.comuto:id/home_offer_ride_empty_state_button']")
    private MobileElement offerRideButton;

    @FindBy(xpath = ".//*[@resource-id='com.comuto:id/search_form_button']")
    private MobileElement searchFormButton;

    @FindBy(xpath = ".//*[@resource-id='com.comuto:id/login_button']")
    private MobileElement loginButton;


    public boolean offerRideButtonExists(){
        waitForCondition.until(ExpectedConditions.visibilityOf(offerRideButton));
        return offerRideButton.isDisplayed();
    }

    public boolean searchFormButtonExists(){
        waitForCondition.until(ExpectedConditions.visibilityOf(searchFormButton));
        return searchFormButton.isDisplayed();
    }

    public boolean loginButtonExists(){
        waitForCondition.until(ExpectedConditions.visibilityOf(loginButton));
        return loginButton.isDisplayed();
    }

    public void clickOnRidesButton(){
        ridesButton.click();
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }

    public void clickOnProfileButton(){
        profileButton.click();
    }

    public void clickOnSkipButton(){
        skipButton.click();
    }

    public void clickOnSelectCountryButton(){
        selectCountryButton.click();
    }

    public void clickOnSwitcherUkraine(){
        switcherUkraine.click();
    }

    public void clickOnNextView(){
        buttonNextView.click();
    }

    public void clickOnSkipTextView(){
        buttonSkipTextView.click();
    }

    public void swipeUpCountryList(){
        waitForCondition.until(ExpectedConditions.visibilityOf(subheader));
        swipeUp();
    }

    public void clickOnAlertNo(){
        alertNo.click();
    }
}
