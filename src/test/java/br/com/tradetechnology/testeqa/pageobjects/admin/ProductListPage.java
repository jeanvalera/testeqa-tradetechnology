package br.com.tradetechnology.testeqa.pageobjects.admin;

import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.com.tradetechnology.testeqa.context.ScenarioContext;
import br.com.tradetechnology.testeqa.dto.Product;
import br.com.tradetechnology.testeqa.dto.ProductStatus;
import br.com.tradetechnology.testeqa.pageobjects.AbstractPage;

public class ProductListPage extends AbstractPage {

    private ProductListSearchBar searchBar;
    private NotificationList notificationList;

    public ProductListPage(ScenarioContext scenarioContext, ProductListSearchBar searchBar, NotificationList notificationList) {
        super(scenarioContext);
        this.searchBar = searchBar;
        this.notificationList = notificationList;
    }

    public void goToAddProductScreen() {
        By buttonLocator = By.cssSelector("button[data-cy='productsDashboardNewProduct']");

        wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));

        driver.findElement(buttonLocator).click();
    }

    public void goToEditProductScreen(String productName) {
        selectProduct(productName);

        driver.findElement(By.cssSelector("button[data-cy='productsDashboardEditButton']")).click();
    }

    public void viewNotifications() {
        driver.findElement(By.cssSelector("button[data-cy='notificationsButtonHeader']")).click();
    }

    public boolean listContainsProductsWithNameLike(String name) {
        Stream<WebElement> found = getRows().stream()
                .filter(row -> row.findElements(By.tagName("td")).get(2).getText().contains(name));

        return found.count() > 0l;
    }

    public boolean listContainsProductsWithStatusLike(ProductStatus productStatus) {
        Stream<WebElement> found = getRows().stream().filter(row -> row.findElements(By.tagName("td")).get(8)
                .findElement(By.tagName("button")).getText().equals(productStatus.description));

        return found.count() > 0l;
    }

    public boolean isProductListEmpty() {
        return getRows().isEmpty();
    }

    public boolean isProductInList(Product product) {

        Stream<WebElement> found = getRows().stream().filter(row -> {
            List<WebElement> columns = row.findElements(By.tagName("td"));

            return columns.get(2).getText().equals(product.getName())
                    && columns.get(3).getText().equals(product.getDueDate())
                    && columns.get(4).getText().equals(String.format(Locale.US, "%.2f", product.getCalories()))
                    && columns.get(5).getText().equals(String.valueOf(product.getStock()))
                    && columns.get(6).getText().equals(String.format(Locale.US, "%.2f", product.getPurchasePrice()))
                    && columns.get(7).getText()
                            .equals(String.format(Locale.US, "%.2f", (double) product.getSalePrice()));

        });

        return found.count() > 0l;

    }

    public void deleteProduct(String productName) {
        selectProduct(productName);

        driver.findElement(By.cssSelector("button[data-cy='productsDashboardDeleteButton']")).click();
        driver.findElement(By.cssSelector("button[data-cy='submitDeleteProductModal']")).click();
    }

    public void changeProductStatusTo(String productName, ProductStatus productStatus) {
        WebElement button = getProductStatusButton(productName);

        if (!productStatus.description.equals(button.getText())) {
            button.click();
        }
    }

    public String getProductStatus(String productName) {
        return getProductStatusButton(productName).getText();
    }

    private WebElement getProductStatusButton(String productName) {
        WebElement productRow = findProductRowBy(productName);

        return productRow.findElement(By.tagName("button"));
    }

    private void selectProduct(String productName) {
        WebElement productRow = findProductRowBy(productName);

        if (!productRow.findElement(By.cssSelector("input[type='checkbox']")).isSelected()) {
            productRow.findElement(By.cssSelector("span[data-cy='checkmarkCheckbox']")).click();
        }
    }

    private WebElement findProductRowBy(String productName) {
        Stream<WebElement> rowsFound = getRows().stream()
                .filter(row -> row.findElements(By.tagName("td")).get(2).getText().equals(productName));

        return rowsFound.findFirst().get();
    }

    private List<WebElement> getRows() {
        return driver.findElement(By.className("sc-iGctRS")).findElement(By.tagName("tbody"))
                .findElements(By.tagName("tr"));
    }

    public ProductListSearchBar getSearchBar() {
        return searchBar;
    }

    public NotificationList getNotificationList() {
        return notificationList;
    }

}
