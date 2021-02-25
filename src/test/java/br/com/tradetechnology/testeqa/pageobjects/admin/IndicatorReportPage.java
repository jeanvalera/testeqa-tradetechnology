package br.com.tradetechnology.testeqa.pageobjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.com.tradetechnology.testeqa.context.ScenarioContext;
import br.com.tradetechnology.testeqa.pageobjects.AbstractPage;

public class IndicatorReportPage extends AbstractPage {

    public IndicatorReportPage(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }

    public void exportReport() throws InterruptedException {
        waitForIndicatorsMenu();
        driver.findElement(By.cssSelector("a[data-cy='sidebarIndicatorsMenuLink']")).click();
        driver.findElement(By.cssSelector("button[data-cy='indicatorsExportButton']")).click();
    }

    public void generateEmployeeConsumptionChart(String employee) {
        waitForIndicatorsMenu();
        driver.findElement(By.cssSelector("a[data-cy='sidebarIndicatorsMenuLink']")).click();

        driver.findElement(By.id("inputNameUser")).sendKeys(employee);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-cy='dataSearch']")));

        driver.findElement(By.cssSelector("div[data-cy='indicatorsSearchField']"))
                .findElement(By.cssSelector("div[data-cy='dataRow']")).click();

        driver.findElement(By.cssSelector("button[data-cy='indicatorsSearchUserButton']")).click();
    }

    public boolean isEmployeeConsumptionChartVisible() {
        return driver.findElement(By.className("highcharts-container")).isDisplayed();
    }

    private void waitForIndicatorsMenu() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("a[data-cy='sidebarIndicatorsMenuLink']")));
    }

}
