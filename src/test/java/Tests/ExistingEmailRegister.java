package Tests;/*
 * Created on 06/04/2023 by Eyad Mohamed
 * Copyright (c) 2023 Vodafone Intelligent Solutions - API Factory
 */

import Pages.CompleteRegister.HomePage;
import Pages.CompleteRegister.Login_Signup_Page;
import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExistingEmailRegister {

    SHAFT.GUI.WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @Description("Test Case 5: Register User with existing email")
    @Test
    public void existingEmail() {
        new HomePage(driver).openUrl()
                .assertUrl()
                .assertLogin_Text()
                .clickOnSignup_LoginButton()
                .assertSignup_Text()
                .enterNameAndEmail();
        new Login_Signup_Page(driver)
                .assertSignUpError();
    }
}
