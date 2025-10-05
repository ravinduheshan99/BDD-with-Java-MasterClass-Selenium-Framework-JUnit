package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\global.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String url = properties.getProperty("QAUrl");
        String browser_properties = properties.getProperty("browser");
        String browser_maven = System.getProperty("browser");

        String executingBrowser = browser_maven!=null ? browser_maven : browser_properties;

        if (driver==null){
            if (executingBrowser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\ChormeDriver\\chromedriver.exe");
                driver = new ChromeDriver();
            }
            if (executingBrowser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\GeckoDriver\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
            if (executingBrowser.equalsIgnoreCase("edge")) {
                //edge code
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(url);
            return driver;
        }
        return driver;
    }
}
