package br.com.tradetechnology.testeqa.pageobjects.store;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.tradetechnology.testeqa.context.ScenarioContext;
import br.com.tradetechnology.testeqa.pageobjects.AbstractPage;

public class ProductListPage extends AbstractPage {

    public ProductListPage(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }

    public void addProduct(int productShelfPosition) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-cy='shelfCardScroll']")));

        driver.findElement(By.cssSelector("div[data-cy='shelfCardScroll']")).findElements(By.tagName("div"))
                .get(productShelfPosition).click();
    }

    public void addProduct(String productName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-cy='shelfCardScroll']")));

        driver.findElement(By.cssSelector("div[data-cy='shelfCardScroll']"))
                .findElements(By.cssSelector("div[data-cy='horizontalCardTitle']")).stream()
                .filter(item -> item.getText().toLowerCase().equals(productName.toLowerCase())).findFirst().get()
                .click();
    }

}
