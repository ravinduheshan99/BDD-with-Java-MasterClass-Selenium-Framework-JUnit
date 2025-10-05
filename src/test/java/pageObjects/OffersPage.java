package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

    public WebDriver driver;

    public OffersPage(WebDriver driver){
        this.driver=driver;
    }

    private By search = By.xpath("//input[@type='search']");
    private By productName = By.cssSelector("tr td:nth-child(1)");

    public void searchItem(String productNameSearching) throws InterruptedException {
        System.out.println("searchItem : Method Executed");
        driver.findElement(search).sendKeys(productNameSearching);
        Thread.sleep(2000);
    }

    public String getProductName(){
        System.out.println("getProductName : Method Executed");
        return driver.findElement(productName).getText();
    }
}
