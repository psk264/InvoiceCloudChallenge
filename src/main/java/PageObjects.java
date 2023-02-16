import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.remote.Browser;

import java.util.Collections;

public class PageObjects {
    WebDriver driver;
    PageObjects(BrowserDriver browserDriver){
        driver=browserDriver.getDriver();
    }
    public WebElement getAddElementButton(){
        return driver.findElement(By.cssSelector("#content > div > button"));
    }

    public int getNumberOfNewElements() {
        return driver.findElements(By.className("added-manually")).size();
    }

    public WebElement getDeleteElementButton(){
        return driver.findElement(By.xpath("//*[@id=\"elements\"]/button"));
    }

    }
