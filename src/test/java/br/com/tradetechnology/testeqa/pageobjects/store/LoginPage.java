package br.com.tradetechnology.testeqa.pageobjects.store;

import org.openqa.selenium.By;

import br.com.tradetechnology.testeqa.context.ScenarioContext;
import br.com.tradetechnology.testeqa.pageobjects.AbstractPage;

public class LoginPage extends AbstractPage {

    public LoginPage(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }

    public void doLogin(String user, String password) {
        driver.get("https://testeqa.tradetechnology.com.br/");

        driver.findElement(By.id("user-input")).sendKeys(user);
        driver.findElement(By.id("password-input")).sendKeys(password);
        driver.findElement(By.cssSelector("button[data-cy='loginButton']")).click();
    }
    
}
