package com.marinas.wiki.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void validLogin(){
       String username = "Marinaqa";
       String password = "1234.com";
       app.login(username,password);
       Assert.assertTrue(app.isElementPresent(By.id("pt-logout")));
    }
}
