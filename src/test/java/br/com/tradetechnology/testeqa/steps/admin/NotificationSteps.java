package br.com.tradetechnology.testeqa.steps.admin;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.tradetechnology.testeqa.context.ScenarioContext;
import br.com.tradetechnology.testeqa.pageobjects.admin.ProductListPage;
import io.cucumber.java.en.Then;

public class NotificationSteps {

    private ScenarioContext scenarioContext;
    private ProductListPage productListPage;

    public NotificationSteps(ScenarioContext scenarioContext, ProductListPage productListPage) {
        this.scenarioContext = scenarioContext;
        this.productListPage = productListPage;
    }

    @Then("a notification is sent to the admin about the product's limited stock")
    public void a_notification_is_sent_to_the_admin_about_the_product_s_limited_stock() {
        scenarioContext.driver.get("https://testeqa.tradetechnology.com.br/admin/login");
        productListPage.viewNotifications();
        assertThat(productListPage.getNotificationList().notificationExistsWithContent(
                String.format("%s tem menos de 6 unidades no estoque", scenarioContext.product.getName()))).isTrue();
    }

    @Then("a notification is sent to the admin about the product expiration")
    public void a_notification_is_sent_to_the_admin_about_the_product_expiration() {
        productListPage.viewNotifications();
        assertThat(productListPage.getNotificationList().notificationExistsWithContent(
                String.format("%s vence sua validade em 2 dia(s).", scenarioContext.product.getName()))).isTrue();
    }

}
