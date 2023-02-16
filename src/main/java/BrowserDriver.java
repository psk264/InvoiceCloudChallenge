import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserDriver {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    BrowserDriver(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("start-maximized");
            driver = new FirefoxDriver(options);
            return;
        }

        /*
         * More browser options can be further added, however, for now we will consider default case as chrome driver.
         * */
        System.out.println("Initiating default case chrome driver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);


    }
}
