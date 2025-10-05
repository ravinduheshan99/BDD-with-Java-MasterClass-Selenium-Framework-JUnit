package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OffersPageStepDefinitions {

    public String actualProductNameOffersPage;
    TestContextSetup testContextSetup;

    public OffersPageStepDefinitions(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
    }

    public void switchToOffersPage(){
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
        if (!(landingPage.driver.getCurrentUrl().equals("https://rahulshettyacademy.com/seleniumPractise/#/offers"))){
            testContextSetup.genericUtils.switchWindowToChild();
        }

    }

    @Then("^user searched for same shortname (.+) in offers page and extracted actual name of product$")
    public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {
        switchToOffersPage();
        OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
        offersPage.searchItem(shortName);
        actualProductNameOffersPage = offersPage.getProductName();
        System.out.println(actualProductNameOffersPage+" is extracted from Offers Page");
    }

    @Then("validate product name in offers page matches with landing page")
    public void validate_product_name_in_offers_page_matches_with_landing_page(){
        Assert.assertEquals(testContextSetup.actualProductNameLandingPage,actualProductNameOffersPage);
        System.out.println("Assertion Success : Both product names are equal");
    }


}
