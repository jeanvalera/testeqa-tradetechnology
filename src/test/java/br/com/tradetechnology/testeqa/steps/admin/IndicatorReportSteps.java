package br.com.tradetechnology.testeqa.steps.admin;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import br.com.tradetechnology.testeqa.context.ScenarioContext;
import br.com.tradetechnology.testeqa.pageobjects.admin.IndicatorReportPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IndicatorReportSteps {

    private ScenarioContext scenarioContext;
    private IndicatorReportPage indicatorReportPage;

    public IndicatorReportSteps(ScenarioContext scenarioContext, IndicatorReportPage indicatorReportPage) {
        this.scenarioContext = scenarioContext;
        this.indicatorReportPage = indicatorReportPage;
    }

    @When("the user exports the indicators report")
    public void the_user_exports_the_indicators_report() throws InterruptedException {
        indicatorReportPage.exportReport();
    }

    @When("the user generates the consumption chart for an employee")
    public void the_user_generates_the_consumption_chart_for_an_employee() {
        indicatorReportPage.generateEmployeeConsumptionChart("Usuário teste");
    }

    @Then("the report is exported")
    public void the_report_is_exported() {
        FluentWait<WebDriver> wait = new FluentWait<>(scenarioContext.driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300));

        File directory = Paths.get("src", "test", "resources").toFile();

        wait.until(x -> directory.listFiles().length > 2);

        File[] filesFound = directory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.startsWith("IndicadoresR2D2-");
            }
        });

        assertThat(filesFound.length).isGreaterThan(0);
    }

    @Then("the chart is generated")
    public void the_chart_is_generated() {
        assertThat(indicatorReportPage.isEmployeeConsumptionChartVisible()).isTrue();
    }

}
