package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    public WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver=driver;
    }

    private By productName = By.xpath("//p[@class='product-name']");
    private By promoButton = By.cssSelector(".promoBtn");
    private By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");


    public String checkoutPageProductItemName() {
        System.out.println("checkoutPageProductItemName : Method Executed");
        return driver.findElement(productName).getText().split("-")[0].trim();
    }

    public Boolean verifyPromoButton() {
        System.out.println("verifyPromoButton : Method Executed");
        return driver.findElement(promoButton).isDisplayed();
    }

    public Boolean verifyPlaceOrderButton() {
        System.out.println("verifyPlaceOrderButton : Method Executed");
        return driver.findElement(placeOrderButton).isDisplayed();
    }

}
