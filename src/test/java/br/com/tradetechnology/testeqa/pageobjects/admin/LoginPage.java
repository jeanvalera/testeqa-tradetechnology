package br.com.tradetechnology.testeqa.pageobjects.admin;

import org.openqa.selenium.By;

import br.com.tradetechnology.testeqa.context.ScenarioContext;
import br.com.tradetechnology.testeqa.pageobjects.AbstractPage;

public class LoginPage extends AbstractPage {

    public LoginPage(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }

    public void doLogin(String user, String password) {
        driver.get("https://testeqa.tradetechnology.com.br/admin/login");

        driver.findElement(By.id("inputUser")).sendKeys(user);
        driver.findElement(By.id("inputPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("button[data-cy='loginAdminButton']")).click();
    }
    
}
