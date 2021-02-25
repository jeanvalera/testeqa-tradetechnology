package br.com.tradetechnology.testeqa.steps.store;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;

import br.com.tradetechnology.testeqa.context.ScenarioContext;
import br.com.tradetechnology.testeqa.pageobjects.store.LoginPage;
import br.com.tradetechnology.testeqa.pageobjects.store.ProductListPage;
import br.com.tradetechnology.testeqa.pageobjects.store.PurchaseConfirmationPage;
import br.com.tradetechnology.testeqa.pageobjects.store.PurchaseConfirmedPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseSteps {

    private ScenarioContext scenarioContext;
    private ProductListPage productListPage;
    private PurchaseConfirmationPage purchaseConfirmationPage;
    private PurchaseConfirmedPage purchaseConfirmedPage;
    private LoginPage loginPage;

    public PurchaseSteps(ScenarioContext scenarioContext, ProductListPage productListPage,
            PurchaseConfirmationPage purchaseConfirmationPage, PurchaseConfirmedPage purchaseConfirmedPage, LoginPage loginPage) {
        this.scenarioContext = scenarioContext;
        this.productListPage = productListPage;
        this.purchaseConfirmationPage = purchaseConfirmationPage;
        this.purchaseConfirmedPage = purchaseConfirmedPage;
        this.loginPage = loginPage;
    }

    @When("the user selects a product and confirm the purchase")
    public void the_user_selects_a_product_and_confirm_the_purchase() {
        Random random = new Random();

        productListPage.addProduct(random.nextInt(4));
        scenarioContext.galacticCredits = purchaseConfirmationPage.getGalacticCredits();
        purchaseConfirmationPage.confirm();
    }

    @When("the product stock is reduced to less than {int} units")
    public void the_product_stock_is_reduced_to_less_than_units(int amount) {
        loginPage.doLogin("test", "password");
        productListPage.addProduct(scenarioContext.product.getName());
        purchaseConfirmationPage.confirm();
    }

    @Then("the purchase is confirmed")
    public void the_purchase_is_confirmed() {
        assertThat(purchaseConfirmedPage.getConfirmationMessage()).isEqualTo("Compra confirmada!");
    }

    @Then("the message {string} is shown")
    public void the_message_is_shown(String expectedMessage) {
        assertThat(purchaseConfirmedPage.getItemReadyMessage()).isEqualTo(expectedMessage);
    }

    @Then("user's galactic credits are debited")
    public void user_s_galactic_credits_are_debited() {
        assertThat(purchaseConfirmedPage.getGalacticCredits()).isLessThan(scenarioContext.galacticCredits);
    }

}
