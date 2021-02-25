package br.com.tradetechnology.testeqa.pageobjects.store;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.tradetechnology.testeqa.context.ScenarioContext;
import br.com.tradetechnology.testeqa.pageobjects.AbstractPage;

public class PurchaseConfirmedPage extends AbstractPage {

    public PurchaseConfirmedPage(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }

    public String getConfirmationMessage() {
        return driver.findElement(By.className("buy-page-title")).getText();
    }

    public String getItemReadyMessage() {
        List<WebElement> messageParts = driver.findElement(By.className("purchase-complete")).findElements(By.tagName("p"));
        
        return String.format("%s %s", messageParts.get(0).getText(), messageParts.get(1).getText());
    }

    public int getGalacticCredits() {
        return Integer.parseInt(driver.findElement(By.className("total-credits")).getText());
    }
    
}
