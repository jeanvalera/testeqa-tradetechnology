package br.com.tradetechnology.testeqa.steps.store;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.tradetechnology.testeqa.pageobjects.store.AccountStatementPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountStatementSteps {

    private AccountStatementPage accountStatementPage;

    public AccountStatementSteps(AccountStatementPage accountStatementPage) {
        this.accountStatementPage = accountStatementPage;
    }

    @When("the user goes to his account statement")
    public void the_user_goes_to_his_account_statement() {
        accountStatementPage.goToPage();
    }

    @Then("a list of the user's last purchases is shown")
    public void a_list_of_the_user_s_last_purchases_is_shown() {
        assertThat(accountStatementPage.getTitle()).isEqualTo("Extrato");
        assertThat(accountStatementPage.getBodyTitle()).isEqualTo("Últimas compras");
        assertThat(accountStatementPage.getItemsCount()).isGreaterThan(0);
    }

}
