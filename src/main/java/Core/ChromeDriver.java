package main.java.Core;

import Core.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class ChromeDriver implements Driver

{
    private static WebDriver webDriver;

    public  WebDriver getDriver() {

        if(webDriver==null) {
            WebDriverManager.chromedriver().setup();
            webDriver = new org.openqa.selenium.chrome.ChromeDriver();
            return webDriver;
        }
        else
        {
            return webDriver;
        }
    }

    public void exitDrivers()
    {
        webDriver.quit();
    }
}
