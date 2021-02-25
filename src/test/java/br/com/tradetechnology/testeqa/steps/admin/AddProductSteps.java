package br.com.tradetechnology.testeqa.steps.admin;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.tradetechnology.testeqa.context.ScenarioContext;
import br.com.tradetechnology.testeqa.dto.Product;
import br.com.tradetechnology.testeqa.helpers.ProductHelper;
import br.com.tradetechnology.testeqa.pageobjects.admin.AddOrEditProductPage;
import br.com.tradetechnology.testeqa.pageobjects.admin.ProductListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class AddProductSteps {

    private ScenarioContext scenarioContext;
    private ProductListPage productListPage;
    private AddOrEditProductPage addProductPage;
    private ProductHelper productHelper;

    public AddProductSteps(ScenarioContext scenarioContext, ProductListPage productListPage,
            AddOrEditProductPage addProductPage, ProductHelper productHelper) {
        this.scenarioContext = scenarioContext;
        this.productListPage = productListPage;
        this.addProductPage = addProductPage;
        this.productHelper = productHelper;
    }

    @Given("an existing product")
    public void an_existing_product() throws MalformedURLException, IOException {
        Product product = productHelper.buildProduct();

        productListPage.goToAddProductScreen();
        addProductPage.addProduct(product);

        scenarioContext.product = product;
    }

    @Given("a product with {int} units in stock")
    public void a_product_with_units_in_stock(int amount) throws MalformedURLException, IOException {
        Product product = productHelper.buildProduct();
        product.setAmount(amount);

        productListPage.goToAddProductScreen();
        addProductPage.addProduct(product);

        scenarioContext.product = product;
    }

    @When("the user adds a new product")
    public void the_user_adds_a_new_product() throws MalformedURLException, IOException {
        Product product = productHelper.buildProduct();

        productListPage.goToAddProductScreen();
        addProductPage.addProduct(product);

        scenarioContext.product = product;
    }

    @When("a product expires in two days")
    public void a_product_expires_in_two_days() throws MalformedURLException, IOException {
        Product product = productHelper.buildProduct();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        product.setDueDate(LocalDate.now().plusDays(2).format(formatter));

        productListPage.goToAddProductScreen();
        addProductPage.addProduct(product);

        scenarioContext.product = product;
    }

}
