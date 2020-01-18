package com.marinas.wiki.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void logIn(String username, String password){
        click(By.id("js-link-box-en"));
        pause(1000);
        click(By.id("pt-login"));
        pause(1000);
        type(By.id("wpName1"), username);
        type(By.id("wpPassword1"),password);
        click(By.id("wpLoginAttempt"));

    }

}
