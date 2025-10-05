package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinitions {

    public LandingPage landingPage;
    TestContextSetup testContextSetup;

    public LandingPageStepDefinitions(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
        landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("user is on GreenKart landing page")
    public void user_is_on_green_kart_landing_page() {
        Assert.assertEquals(landingPage.getTitleLandingPage(),"GreenKart - veg and fruits kart");
    }

    @When("^user searched for shortname (.+) and extracted actual name of product$")
    public void user_searched_for_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        landingPage.searchItem(shortName);
        testContextSetup.actualProductNameLandingPage = landingPage.getProductName();
        System.out.println(testContextSetup.actualProductNameLandingPage+" is extracted from Landing Page");
    }

    @When("added {string} items of the selected product to cart")
    public void added_items_of_the_selected_product_to_cart(String quantity){
        testContextSetup.actualProductNameLandingPage = landingPage.getProductName();
        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();
    }

    @Then("user proceeds to checkout")
    public void user_proceeds_to_checkout_and_validate_the_product_items_in_checkout_page(){
        landingPage.checkoutItems();

    }



}
