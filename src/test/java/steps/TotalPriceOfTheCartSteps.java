package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static locators.TotalPriceOfTheCartLocators.*;
import org.testng.Assert;
import pages.TotalPriceOfTheCartPage;
import utility.MasterPage;

public class TotalPriceOfTheCartSteps {
    MasterPage masterPage = new MasterPage();
    TotalPriceOfTheCartPage totalPriceOfTheCartPage = new TotalPriceOfTheCartPage();

    @Given("The user navigate to the home page")
    public void the_user_navigate_to_the_home_page() {
        masterPage.navigateTo("https://www.demoblaze.com/");
    }
    @When("he add the first product to the cart")
    public void he_add_the_first_product_to_the_cart() throws InterruptedException {
        masterPage.implicitWait(5);
        masterPage.selectWebElement(samsungGalaxyS6Link);
        totalPriceOfTheCartPage.addProductToTheCart();
    }
    @And("he add the second product to the cart")
    public void he_add_the_second_product_to_the_cart() throws InterruptedException {
        masterPage.selectWebElement(homeNavLink);
        masterPage.selectWebElement(nokiaLumia1520Link);
        totalPriceOfTheCartPage.addProductToTheCart();
    }
    @And("he navigate to the cart page")
    public void he_navigate_to_the_cart_page() {
        masterPage.selectWebElement(cartNavLink);
    }
    @Then("he can see the total price of all products added")
    public void he_can_see_the_total_price_of_all_products_added() {
        masterPage.explicitWait(totalPrice,2);
        String totalPriceOfArray = totalPriceOfTheCartPage.totalSum();
        String totalPriceOfThePage = masterPage.textOfTheLocator(totalPrice);
        Assert.assertEquals(totalPriceOfArray,totalPriceOfThePage);
        masterPage.closeNavigator();
    }
}
