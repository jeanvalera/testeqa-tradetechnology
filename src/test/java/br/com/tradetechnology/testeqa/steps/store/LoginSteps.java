package br.com.tradetechnology.testeqa.steps.store;

import br.com.tradetechnology.testeqa.pageobjects.store.LoginPage;
import io.cucumber.java.en.Given;

public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Given("the user is logged into the store")
    public void the_user_is_logged_into_the_store() {
        loginPage.doLogin("test", "password");
    }

}
