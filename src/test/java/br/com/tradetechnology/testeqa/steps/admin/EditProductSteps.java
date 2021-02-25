package br.com.tradetechnology.testeqa.steps.admin;

import br.com.tradetechnology.testeqa.context.ScenarioContext;
import br.com.tradetechnology.testeqa.pageobjects.admin.AddOrEditProductPage;
import br.com.tradetechnology.testeqa.pageobjects.admin.ProductListPage;
import io.cucumber.java.en.When;

public class EditProductSteps {

    private ScenarioContext scenarioContext;
    private ProductListPage productListPage;
    private AddOrEditProductPage addOrEditProductPage;

    public EditProductSteps(ScenarioContext scenarioContext, ProductListPage productListPage,
            AddOrEditProductPage addOrEditProductPage) {
        this.scenarioContext = scenarioContext;
        this.productListPage = productListPage;
        this.addOrEditProductPage = addOrEditProductPage;
    }

    @When("the user modifies the product")
    public void the_user_modifies_the_product() {
        productListPage.goToEditProductScreen(scenarioContext.product.getName());

        scenarioContext.product.setName(scenarioContext.product.getName() + " modified");

        addOrEditProductPage.editProduct(scenarioContext.product);
    }

}
