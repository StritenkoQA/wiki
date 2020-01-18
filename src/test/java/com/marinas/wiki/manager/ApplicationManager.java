package com.marinas.wiki.manager;

import com.marinas.wiki.helpers.SessionHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    SessionHelper sessionHelper;


    public void init(){
        String browser = System.getProperty("browser", BrowserType.CHROME);
        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            wd = new EdgeDriver();
        }

        sessionHelper = new SessionHelper(wd);

        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://www.wikipedia.org/");

    }

    public void stop(){
        wd.quit();
    }

    public void login(String username, String password) {
        sessionHelper.logIn(username, password);
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size() > 0;
    }

}
