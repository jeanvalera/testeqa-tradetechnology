package br.com.tradetechnology.testeqa.steps.admin;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.MalformedURLException;

import br.com.tradetechnology.testeqa.context.ScenarioContext;
import br.com.tradetechnology.testeqa.dto.Product;
import br.com.tradetechnology.testeqa.dto.ProductStatus;
import br.com.tradetechnology.testeqa.helpers.ProductHelper;
import br.com.tradetechnology.testeqa.pageobjects.admin.AddOrEditProductPage;
import br.com.tradetechnology.testeqa.pageobjects.admin.ProductListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStatusSteps {

    private ScenarioContext scenarioContext;
    private AddOrEditProductPage addOrEditProductPage;
    private ProductListPage productListPage;
    private ProductHelper productHelper;

    public ProductStatusSteps(ScenarioContext scenarioContext, AddOrEditProductPage addOrEditProductPage,
            ProductListPage productListPage, ProductHelper productHelper) {
        this.scenarioContext = scenarioContext;
        this.addOrEditProductPage = addOrEditProductPage;
        this.productListPage = productListPage;
        this.productHelper = productHelper;
    }

    @Given("an inactive product")
    public void an_inactive_product() throws MalformedURLException, IOException {
        createProductWithStatus(ProductStatus.INACTIVE);
    }

    @Given("an active product")
    public void an_active_product() throws MalformedURLException, IOException {
        createProductWithStatus(ProductStatus.ACTIVE);
    }

    @When("the user activates the product")
    public void the_user_activates_the_product() {
        productListPage.changeProductStatusTo(scenarioContext.product.getName(), ProductStatus.ACTIVE);
    }

    @When("the user deactivates the product")
    public void the_user_deactivates_the_product() {
        productListPage.changeProductStatusTo(scenarioContext.product.getName(), ProductStatus.INACTIVE);
    }

    @Then("the product is activated")
    public void the_product_is_activated() {
        assertThat(productListPage.getProductStatus(scenarioContext.product.getName())).isEqualTo("Ativo");
    }

    @Then("the product is deactivated")
    public void the_product_is_deactivated() {
        assertThat(productListPage.getProductStatus(scenarioContext.product.getName())).isEqualTo("Inativo");
    }

    private void createProductWithStatus(ProductStatus productStatus) throws MalformedURLException, IOException {
        Product product = productHelper.buildProduct();

        productListPage.goToAddProductScreen();
        addOrEditProductPage.addProduct(product);
        productListPage.changeProductStatusTo(product.getName(), productStatus);

        scenarioContext.product = product;
    }

}
