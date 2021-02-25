package br.com.tradetechnology.testeqa.steps.admin;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.tradetechnology.testeqa.context.ScenarioContext;
import br.com.tradetechnology.testeqa.pageobjects.admin.ProductListPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteProductSteps {

    private ScenarioContext scenarioContext;
    private ProductListPage productListPage;

    public DeleteProductSteps(ScenarioContext scenarioContext, ProductListPage productListPage) {
        this.scenarioContext = scenarioContext;
        this.productListPage = productListPage;
    }

    @When("the user deletes the product")
    public void the_user_deletes_the_product() {
        productListPage.deleteProduct(scenarioContext.product.getName());
    }

    @Then("the product is deleted")
    public void the_product_is_deleted() {
        assertThat(productListPage.isProductInList(scenarioContext.product)).isFalse();
    }

}
