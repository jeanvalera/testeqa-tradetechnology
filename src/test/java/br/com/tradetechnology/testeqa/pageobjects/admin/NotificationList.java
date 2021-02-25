package br.com.tradetechnology.testeqa.pageobjects.admin;

import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.tradetechnology.testeqa.context.ScenarioContext;

public class NotificationList {

    private WebDriver driver;

    public NotificationList(ScenarioContext scenarioContext) {
        this.driver = scenarioContext.driver;
    }

    public boolean notificationExistsWithContent(String content) {
        Stream<WebElement> found = driver.findElements(By.cssSelector("div[data-cy='notification']")).stream().filter(notification -> notification.findElement(By.tagName("p")).getText().equals(content));

        return found.count() == 1l;
    }
    
}
