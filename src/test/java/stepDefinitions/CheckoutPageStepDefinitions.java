package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinitions {

    public CheckoutPage checkoutPage;
    TestContextSetup testContextSetup;

    public CheckoutPageStepDefinitions(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
        checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @Then("^validate the (.+) items in checkout page$")
    public void validate_the_product_item_name_in_checkout_page(String productName){
        Assert.assertEquals(checkoutPage.checkoutPageProductItemName(),testContextSetup.actualProductNameLandingPage);
    }

    @Then("verify user has ability to enter promo code and place the order")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order(){
        Assert.assertTrue(checkoutPage.verifyPromoButton());
        Assert.assertTrue(checkoutPage.verifyPlaceOrderButton());
    }

}
