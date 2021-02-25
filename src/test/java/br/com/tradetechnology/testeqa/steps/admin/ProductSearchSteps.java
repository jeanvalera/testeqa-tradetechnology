package br.com.tradetechnology.testeqa.steps.admin;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.tradetechnology.testeqa.context.ScenarioContext;
import br.com.tradetechnology.testeqa.dto.ProductStatus;
import br.com.tradetechnology.testeqa.dto.ProductType;
import br.com.tradetechnology.testeqa.dto.StockLevel;
import br.com.tradetechnology.testeqa.pageobjects.admin.ProductListPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearchSteps {

    private ScenarioContext scenarioContext;
    private ProductListPage productListPage;

    public ProductSearchSteps(ScenarioContext scenarioContext, ProductListPage productListPage) {
        this.scenarioContext = scenarioContext;
        this.productListPage = productListPage;
    }

    @When("the user searches products by name")
    public void the_user_searches_products_by_name() {
        scenarioContext.searchedProductName = "suco";

        productListPage.getSearchBar().performSearchByProductName(scenarioContext.searchedProductName);
    }

    @When("the user searches products by type")
    public void the_user_searches_products_by_type() {
        productListPage.getSearchBar().performSearchByProductType(ProductType.BEBIDAS_LACTEAS);
    }

    @When("the user searches products by status")
    public void the_user_searches_products_by_status() {
        productListPage.getSearchBar().performSearchByProductStatus(ProductStatus.ACTIVE);

        scenarioContext.searchedProductStatus = ProductStatus.ACTIVE;
    }

    @When("the user searches products by stock level")
    public void the_user_searches_products_by_stock_level() {
        productListPage.getSearchBar().performSearchByProductStockLevel(StockLevel.REGULAR);
    }

    @Then("the product list shows products with this name")
    public void the_product_list_shows_products_with_this_name() {
        assertThat(productListPage.listContainsProductsWithNameLike(scenarioContext.searchedProductName)).isTrue();
    }

    @Then("the product list shows products with this type")
    public void the_product_list_shows_products_with_this_type() {
        assertThat(productListPage.isProductListEmpty()).isFalse();
    }

    @Then("the product list shows products with this status")
    public void the_product_list_shows_products_with_this_status() {
        assertThat(productListPage.listContainsProductsWithStatusLike(scenarioContext.searchedProductStatus)).isTrue();
    }

    @Then("the product list shows products with this stock level")
    public void the_product_list_shows_products_with_this_stock_level() {
        assertThat(productListPage.isProductListEmpty()).isFalse();
    }

}
