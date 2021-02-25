package br.com.tradetechnology.testeqa.runner.admin;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = "src/test/resources/features/admin/EmployeeConsumptionChart.feature", glue = "br.com.tradetechnology.testeqa")
public class EmployeeConsumptionChartTestRunner {

}
