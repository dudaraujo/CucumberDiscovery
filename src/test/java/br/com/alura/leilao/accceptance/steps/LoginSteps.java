package br.com.alura.leilao.accceptance.steps;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class LoginSteps {

    private Browser browser;
    private LoginPage loginPage;
    private LeiloesPage leiloesPage;

    @Dado("um usuario valido")
    public void UmUsuarioValido() {

        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
    }

    @Quando("ele realiza o login")
    public void EleRealizaLogin() {

       leiloesPage = this.loginPage.realizaLoginComo("fulano", "pass");
    }

    @Entao("e redirecionado para a pagina de leiloes")
    public void ERedirecinadoParaAPaginaDeLeiloes() {

        Assert.assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());
    }

    @Dado("um usuario invalido")
    public void UmUsuarioInvalido() {

        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
    }

    @Quando("ele tenta realizar o login")
    public void EleTentaRealizarOLogin() {

        leiloesPage = this.loginPage.realizaLoginComo("fulana", "pass");
    }

    @Entao("continua na pagina de login")
    public void ContinuaNaPaginaDeLogin() {

        Assert.assertTrue(this.loginPage.estaNaPaginaDeLoginComErro());
    }



}
