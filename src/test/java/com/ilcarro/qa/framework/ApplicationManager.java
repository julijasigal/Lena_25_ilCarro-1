package com.ilcarro.qa.framework;

import com.ilcarro.qa.model.Car;
import com.ilcarro.qa.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager  {
         WebDriver wd;
        CarHelper car;
        SessionHelper session;
        HeaderHelper header;

    private String browser;

    public void init() {
        if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }

        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
        car = new CarHelper(wd);
        session= new SessionHelper(wd);
        header = new HeaderHelper(wd);
    }

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public CarHelper car() {
        return car;
    }

    public SessionHelper session() {
        return session;
    }

    public HeaderHelper header() {
        return header;
    }

    public void stop() {
        wd.quit();
    }
}
