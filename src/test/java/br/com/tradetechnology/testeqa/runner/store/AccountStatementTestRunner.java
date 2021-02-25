package br.com.tradetechnology.testeqa.runner.store;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = "src/test/resources/features/store/AccountStatement.feature", glue = "br.com.tradetechnology.testeqa")
public class AccountStatementTestRunner {

}
