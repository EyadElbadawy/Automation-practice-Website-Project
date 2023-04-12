package Tests;/*
 * Created on 06/04/2023 by Eyad Mohamed
 * Copyright (c) 2023 Vodafone Intelligent Solutions - API Factory
 */

import Pages.CompleteRegister.HomePage;
import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogoutTest {
    SHAFT.GUI.WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();

        new HomePage(driver).openUrl()
                .assertUrl()
                .clickOnSignup_LoginButton()
                .enterNameAndEmail()
                .enterPersonalData()
                .clickContinue();
    }

    @Description("Test Case 4: Logout User")
    @Test
    public void logoutEmail() {
        new HomePage(driver)
                .clickOnLogoutButton()
                .assertLogin_Text();
    }
}
