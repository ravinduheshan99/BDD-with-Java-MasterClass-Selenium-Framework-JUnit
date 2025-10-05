package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    public WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver=driver;
    }

    private By search = By.xpath("//input[@type='search']");
    private By productName = By.cssSelector("h4.product-name");
    private By topDeals = By.linkText("Top Deals");
    private By increment = By.cssSelector("a.increment");
    private By addToCart = By.cssSelector(".product-action button");
    private By cartBag = By.cssSelector("[alt='Cart']");
    private By checkoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");

    public String getTitleLandingPage(){
        System.out.println("getTitleLandingPage : Method Executed");
        return driver.getTitle();
    }

    public void searchItem(String productNameSearching) throws InterruptedException {
        System.out.println("searchItem : Method Executed");
        driver.findElement(search).sendKeys(productNameSearching);
        Thread.sleep(2000);
    }

    public String getProductName(){
        System.out.println("getProductName : Method Executed");
        return driver.findElement(productName).getText().split("-")[0].trim();
    }

    public void selectTopDealsPage(){
        System.out.println("selectTopDealsPage : Method Executed");
        driver.findElement(topDeals).click();
    }

    public void incrementQuantity(int quantity){
        System.out.println("incrementQuantity : Method Executed");
        int i = quantity;
        for (int j=0; j<i; j++){
            driver.findElement(increment).click();
        }
    }

    public void addToCart(){
        System.out.println("addToCart : Method Executed");
        driver.findElement(addToCart).click();
    }

    public void checkoutItems() {
        System.out.println("checkoutItems : Method Executed");
        driver.findElement(cartBag).click();
        driver.findElement(checkoutButton).click();
    }

}
