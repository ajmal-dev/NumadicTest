package main.java.Numadic.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareerDetailPageQA

{
    private WebDriver webDriver;

    public  CareerDetailPageQA(WebDriver webDriver)
    {
        this.webDriver=webDriver;
    }

    By applyhereButton=By.xpath("//a[contains(text(),'Apply here now')]");


    public boolean verifyUrl()
    {
        if(webDriver.getCurrentUrl().equalsIgnoreCase("https://numadic.com/careers/qa-engineer.php"))
        {
            return true;
        }
        else {
            return  false;
        }
    }

    public void clickApplyHereBuuton()
    {
        webDriver.findElement(applyhereButton).click();
    }


}
