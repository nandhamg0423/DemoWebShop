package com.demowebshop.test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.RegisterPage;
import org.testng.annotations.Test;

public class RegisterPageTest extends Base {
    RegisterPage register;
    @Test
    public void verifyRegister(){
        register=new RegisterPage(driver);
    }
}
