package br.com.tradetechnology.testeqa.steps.admin;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.tradetechnology.testeqa.context.ScenarioContext;
import br.com.tradetechnology.testeqa.pageobjects.admin.ProductListPage;
import io.cucumber.java.en.Then;

public class ProductListSteps {

    private ScenarioContext scenarioContext;
    private ProductListPage productListPage;

    public ProductListSteps(ScenarioContext scenarioContext, ProductListPage productListPage) {
        this.scenarioContext = scenarioContext;
        this.productListPage = productListPage;
    }

    @Then("the new product is added to the product list")
    public void the_new_product_is_added_to_the_product_list() {
        assertThat(productListPage.isProductInList(scenarioContext.product)).isTrue();
    }

    @Then("the product is updated with new data")
    public void the_product_is_updated_with_new_data() {
        assertThat(productListPage.isProductInList(scenarioContext.product)).isTrue();
    }

}
