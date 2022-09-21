package Tests;

import Core.Driver;
import main.java.Core.ChromeDriver;
import main.java.Numadic.Pages.CareerDetailPageQA;
import main.java.Numadic.Pages.CareerPage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestCareers

{
    Driver driver=new ChromeDriver();
    CareerPage careerPage=new CareerPage(driver.getDriver());
    CareerDetailPageQA careerDetailPageQA=new CareerDetailPageQA(driver.getDriver());

    @BeforeSuite
    public void setup()
    {
        driver.getDriver();
        driver.getDriver().manage().window().maximize();
    }

    @Test
    public void careersTestFlow() throws InterruptedException {
        careerPage.openCareerPage();
        Assert.assertEquals(careerPage.verifyCareerPage(),true);
        careerPage.selectJobTypeFromDropDown("Internship");
        Assert.assertEquals(careerPage.verifyNoJobAvailable(),true);
        careerPage.selectJobTypeFromDropDown("Full time");
        careerPage.clickQaEngineer();
        Assert.assertEquals(careerDetailPageQA.verifyUrl(),true);
        careerDetailPageQA.clickApplyHereBuuton();
        Assert.assertEquals(careerPage.verifyCareerPage(),true);
        careerPage.mouseHover();
        careerPage.clickApply();
        careerPage.waitForJobToLoad();

        //Validation of all personal details
        Assert.assertEquals(careerPage.validatePersonalDetails(),true);
    }

    @AfterSuite
    public void tear()
    {
        driver.exitDrivers();
    }

}
