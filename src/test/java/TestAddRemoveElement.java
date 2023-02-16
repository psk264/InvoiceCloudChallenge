import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAddRemoveElement {
    //Setup the driver for the desired browser: chrome, firefox
    BrowserDriver browserDriver = new BrowserDriver("chrome");
    //Instantiate the PageObjects class to get the elements during tests
    PageObjects pageObjects = new PageObjects(browserDriver);

    @BeforeTest
    void initialSetup(){
        browserDriver.getDriver().navigate().to("https://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test(priority = 0, testName = "Verify addition of single and assert number of added elements")
    void verifySingleAddElement(){
       pageObjects.getAddElementButton().click();
       Assert.assertEquals(pageObjects.getNumberOfNewElements(),1);

    }

    @Test(dependsOnMethods = "verifySingleAddElement", testName = "Verify deletion of single and assert number of added elements")
    void verifySingleDeleteElement(){
        pageObjects.getDeleteElementButton().click();  //clean up for following tests
        Assert.assertEquals(pageObjects.getNumberOfNewElements(),0);

    }

    //Added dependency on verifySingleAddElement to ensure we run that test first before running multiple elements check.
    @Test(priority = 1, testName = "Verify addition of multiple(5) buttons and assert number of added elements")
    void verifyMultipleAddElement(){
        int n=5, i=n;
        while(i>0) {
            pageObjects.getAddElementButton().click();
            i--;
        }
        Assert.assertEquals(pageObjects.getNumberOfNewElements(),n);

    }

    @Test(dependsOnMethods = "verifyMultipleAddElement", testName = "Verify addition of multiple(5) buttons and assert number of added elements")
    void verifyMultipleDeleteElement(){
        int n=5;
        while(n>0) {
            pageObjects.getDeleteElementButton().click();
            n--;
        }
        Assert.assertEquals(pageObjects.getNumberOfNewElements(),n);

    }

    @AfterTest
    void cleanUp(){
        browserDriver.getDriver().quit();
    }
}
