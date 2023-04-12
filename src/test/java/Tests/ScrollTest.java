package Tests;/*
 * Created on 07/04/2023 by Eyad Mohamed
 * Copyright (c) 2023 Vodafone Intelligent Solutions - API Factory
 */

import Pages.CompleteRegister.HomePage;
import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScrollTest {
    SHAFT.GUI.WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
        new HomePage(driver).openUrl()
                .assertUrl();
    }
    @Description("Test Case 10: Verify Subscription in home page")
    @Test
    public void subscriptionTest(){
        new HomePage(driver)
                .scrollToFooter()
                .assertSubscriptionText()
                .enterSubscriptionEmail()
                .clickOnSubscribeButton()
                .assertOnAlertMessage();
    }
}
