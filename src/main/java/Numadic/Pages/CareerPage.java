package main.java.Numadic.Pages;

import main.java.Numadic.Urls.NumadicWebsite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class CareerPage
{

    private WebDriver webDriver;

    public  CareerPage(WebDriver webDriver)
    {
        this.webDriver=webDriver;
    }


    By dropdownJobType=By.xpath("//select[@id='job_type']");
    By noJobWarning=By.xpath("//td[contains(text(),'There are no available job positions that match your filters.')]");
    By titleText =By.xpath("//h1[contains(text(),'JOIN OUR CREW')]");
    By qaEngineerLink=By.xpath("//a[@class='job-title' and contains(text(),'QA Engineer')]");
    By applyButton=By.xpath("//a[@class='job-title' and contains(text(),'QA Engineer')]//following::button[1]");



    public void openCareerPage()
    {
        webDriver.get(NumadicWebsite.careerPage);
    }
    public boolean verifyCareerPage()
    {
        if(webDriver.findElement(titleText).isDisplayed())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void selectJobTypeFromDropDown(String jobType)
    {
        WebElement dropdown=webDriver.findElement(dropdownJobType);
        Select select=new Select(dropdown);
        select.selectByVisibleText(jobType);
    }

    public boolean verifyNoJobAvailable()
    {
        if(webDriver.findElement(noJobWarning).isDisplayed())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void clickQaEngineer()
    {
        webDriver.findElement(qaEngineerLink).click();
    }
    public void clickApply()
    {
        webDriver.findElement(applyButton).click();
    }

    public void waitForJobToLoad()
    {
        WebDriverWait webDriverWait=new WebDriverWait(webDriver,30);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Apply for a Job')]")));
    }
    public void mouseHover()
    {
        Actions actions=new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(qaEngineerLink)).build().perform();
    }

    public boolean validatePersonalDetails()
    {
        ArrayList<By> personalDetailsFields=new ArrayList<By>();
        personalDetailsFields.add(By.xpath("//input[@id='firstName']"));
        personalDetailsFields.add(By.xpath("//input[@id='lastName']"));
        personalDetailsFields.add(By.xpath("//input[@id='email']"));
        personalDetailsFields.add(By.xpath("//input[@id='phone']"));
        personalDetailsFields.add(By.xpath("//select[@id='sports']"));
        personalDetailsFields.add(By.xpath("//select[@id='pets']"));
        personalDetailsFields.add(By.xpath("//input[@name='Current location']"));
        personalDetailsFields.add(By.xpath("//input[@id='hometown']"));
        personalDetailsFields.add(By.xpath("//input[@id='dob']"));

        for(By field:personalDetailsFields)
        {
            if(!webDriver.findElement(field).isDisplayed())
            {
                return false;
            }
        }
        return true;
    }


}
