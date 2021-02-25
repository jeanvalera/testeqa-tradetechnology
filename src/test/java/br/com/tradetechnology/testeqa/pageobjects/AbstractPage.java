package br.com.tradetechnology.testeqa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.tradetechnology.testeqa.context.ScenarioContext;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstractPage(ScenarioContext scenarioContext) {
        this.driver = scenarioContext.driver;
        this.wait = scenarioContext.wait;
    }
    
}
