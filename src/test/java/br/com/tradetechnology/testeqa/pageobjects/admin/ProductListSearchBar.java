package br.com.tradetechnology.testeqa.pageobjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.tradetechnology.testeqa.context.ScenarioContext;
import br.com.tradetechnology.testeqa.dto.ProductStatus;
import br.com.tradetechnology.testeqa.dto.ProductType;
import br.com.tradetechnology.testeqa.dto.StockLevel;

public class ProductListSearchBar {

    private WebDriver driver;
    private WebDriverWait wait;

    public ProductListSearchBar(ScenarioContext scenarioContext) {
        this.driver = scenarioContext.driver;
        this.wait = scenarioContext.wait;
    }

    public void performSearchByProductName(String productName) {
        waitForSearchBarToBeVisible();
        driver.findElement(By.id("inputSearchTitle")).sendKeys(productName);
        driver.findElement(By.cssSelector("button[data-cy='productsDashboardSearchButton']")).click();
    }

    public void performSearchByProductType(ProductType productType) {
        waitForSearchBarToBeVisible();
        driver.findElement(By.cssSelector("input[data-cy='productsDashboardSearchType']")).click();
        driver.findElement(By.id("select-type")).findElement(By.id("selectOptions-type"))
                .findElement(By.cssSelector(String.format("option[value='%s']", productType.description))).click();
        driver.findElement(By.cssSelector("button[data-cy='productsDashboardSearchButton']")).click();
    }

    public void performSearchByProductStatus(ProductStatus productStatus) {
        waitForSearchBarToBeVisible();
        driver.findElement(By.cssSelector("input[data-cy='productsDashboardSearchStatus']")).click();
        driver.findElement(By.id("select-status")).findElement(By.id("selectOptions-status"))
                .findElement(By.cssSelector(String.format("option[title='%s']", productStatus.description))).click();
        driver.findElement(By.cssSelector("button[data-cy='productsDashboardSearchButton']")).click();
    }

    public void performSearchByProductStockLevel(StockLevel stockLevel) {
        waitForSearchBarToBeVisible();
        driver.findElement(By.cssSelector("input[data-cy='productsDashboardSearchStock']")).click();
        driver.findElement(By.id("select-stockLevel")).findElement(By.id("selectOptions-stockLevel"))
                .findElement(By.cssSelector(String.format("option[title='%s']", stockLevel.description))).click();
        driver.findElement(By.cssSelector("button[data-cy='productsDashboardSearchButton']")).click();
    }

    private void waitForSearchBarToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-cy='containerHeader']")));
    }

}
