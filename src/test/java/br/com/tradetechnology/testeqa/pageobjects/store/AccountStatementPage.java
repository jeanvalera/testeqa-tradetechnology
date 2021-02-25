package br.com.tradetechnology.testeqa.pageobjects.store;

import org.openqa.selenium.By;

import br.com.tradetechnology.testeqa.context.ScenarioContext;
import br.com.tradetechnology.testeqa.pageobjects.AbstractPage;

public class AccountStatementPage extends AbstractPage {

    public AccountStatementPage(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }

    public void goToPage() {
        driver.findElement(By.cssSelector("button[data-cy='shelfbuttonHeader']")).click();
        driver.findElement(By.cssSelector("button[data-cy='accountExtractButton']")).click();
    }

    public String getTitle() {
        return driver.findElement(By.className("sc-bBrOnJ")).getText();
    }

    public String getBodyTitle() {
        return driver.findElement(By.className("body-title")).getText();
    }

    public int getItemsCount() {
        return driver.findElements(By.className("sc-cOajty")).size();
    }
    
}
