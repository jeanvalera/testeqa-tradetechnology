package br.com.tradetechnology.testeqa.pageobjects.store;

import org.openqa.selenium.By;

import br.com.tradetechnology.testeqa.context.ScenarioContext;
import br.com.tradetechnology.testeqa.pageobjects.AbstractPage;

public class PurchaseConfirmationPage extends AbstractPage {

    public PurchaseConfirmationPage(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }

    public void confirm() {
        driver.findElement(By.cssSelector("button[data-cy='buyConfirmButton']")).click();
    }

    public int getGalacticCredits() {
        return Integer.parseInt(driver.findElement(By.className("total-credits")).getText());
    }
    
}
