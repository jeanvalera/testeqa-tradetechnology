package br.com.tradetechnology.testeqa.steps.admin;

import br.com.tradetechnology.testeqa.pageobjects.admin.LoginPage;
import io.cucumber.java.en.Given;

public class LoginSteps {
    
    private LoginPage loginPage;

    public LoginSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Given("the user is logged into the admin module")
    public void the_user_is_logged_into_the_admin_module() {
        loginPage.doLogin("test", "password");
    }

}
