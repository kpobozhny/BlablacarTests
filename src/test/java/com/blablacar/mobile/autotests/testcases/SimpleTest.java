package com.blablacar.mobile.autotests.testcases;

import com.blablacar.mobile.autotests.pages.FirstPage;
import com.blablacar.mobile.autotests.tools.ConfigData;
import org.junit.Assert;
import org.junit.Test;


public class SimpleTest extends TestInit {

    FirstPage firstPage = new FirstPage(driver);

    @Test
    public void checkElementsOnNavigationPanel() throws InterruptedException {
/*        firstPage.clickOnSkipButton();
       firstPage.swipeUpCountryList();
        firstPage.clickOnSwitcherUkraine();
        firstPage.clickOnSelectCountryButton();*/
        firstPage.clickOnNextView();
        firstPage.clickOnNextView();
        Thread.sleep(2000);
        firstPage.clickOnNextView();
        firstPage.clickOnSkipTextView();
        firstPage.clickOnAlertNo();
        Assert.assertTrue(firstPage.offerRideButtonExists());
        firstPage.clickOnProfileButton();
        Assert.assertTrue(firstPage.loginButtonExists());
        firstPage.clickOnSearchButton();
        Assert.assertTrue(firstPage.searchFormButtonExists());
        firstPage.clickOnRidesButton();
        Assert.assertTrue(firstPage.offerRideButtonExists());
    }

}
