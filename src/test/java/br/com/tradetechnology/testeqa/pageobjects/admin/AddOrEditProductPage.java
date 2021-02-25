package br.com.tradetechnology.testeqa.pageobjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.com.tradetechnology.testeqa.context.ScenarioContext;
import br.com.tradetechnology.testeqa.dto.Product;
import br.com.tradetechnology.testeqa.pageobjects.AbstractPage;

public class AddOrEditProductPage extends AbstractPage {

    public AddOrEditProductPage(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }

    public void addProduct(Product product) {
        fillProductData(product);

        saveProduct();

        waitForMessage("Produto cadastrado com sucesso!");
    }

    public void editProduct(Product product) {
        fillProductData(product);

        waitForMessage("Imagem atualizada com sucesso!");

        saveProduct();

        waitForMessage("Produto alterado com sucesso!");
    }

    private void fillProductData(Product product) {

        driver.findElement(By.id("inputTitle")).clear();
        driver.findElement(By.id("inputTitle")).sendKeys(product.getName());
        driver.findElement(By.id("inputBrand")).clear();
        driver.findElement(By.id("inputBrand")).sendKeys(product.getBrand());
        driver.findElement(By.id("inputExpiresAt")).clear();
        driver.findElement(By.id("inputExpiresAt")).sendKeys(product.getDueDate().toString());
        driver.findElement(By.id("inputCalories")).clear();
        driver.findElement(By.id("inputCalories")).sendKeys(String.valueOf(product.getCalories()));
        driver.findElement(By.id("inputFlavor")).clear();
        driver.findElement(By.id("inputFlavor")).sendKeys(product.getFlavor());

        driver.findElement(By.cssSelector("input[data-cy='productModalCategory']")).click();
        driver.findElement(By.cssSelector(String.format("option[value='%s']", product.getCategory()))).click();

        driver.findElement(By.id("inputStock")).clear();
        driver.findElement(By.id("inputStock")).sendKeys(String.valueOf(product.getStock()));
        driver.findElement(By.id("inputQuantity")).clear();
        driver.findElement(By.id("inputQuantity")).sendKeys(String.valueOf(product.getAmount()));

        driver.findElement(By.cssSelector("input[data-cy='productModalMeasurements']")).click();
        driver.findElement(By.cssSelector(String.format("option[value='%s']", product.getMeasurement().description)))
                .click();

        driver.findElement(By.cssSelector("input[data-cy='productModalType']")).click();
        driver.findElement(By.cssSelector("div[data-cy='modalContainer']")).findElement(By.id("selectOptions-type"))
                .findElement(By.cssSelector(String.format("option[value='%s']", product.getType().description)))
                .click();

        driver.findElement(By.id("inputCost")).clear();
        driver.findElement(By.id("inputCost")).sendKeys(String.valueOf(product.getPurchasePrice()));
        driver.findElement(By.id("inputPrice")).clear();
        driver.findElement(By.id("inputPrice")).sendKeys(String.valueOf(product.getSalePrice()));

        driver.findElement(By.id("image")).sendKeys(product.getPathToProductImage());

    }

    private void saveProduct() {
        driver.findElement(By.id("btSaveProductModal")).click();
    }

    private void waitForMessage(String message) {
        wait.until(ExpectedConditions.textToBe(By.className("Toastify__toast-body"), message));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("Toastify__toast-container")));
    }

}
