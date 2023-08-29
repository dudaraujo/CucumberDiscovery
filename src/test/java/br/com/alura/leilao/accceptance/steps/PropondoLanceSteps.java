package br.com.alura.leilao.accceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;

public class PropondoLanceSteps {

    private Lance lance;
    private Leilao leilao;
    private ArrayList<Lance> lista;


    @Before
    public void setup() {
        this.lista = new ArrayList<Lance>();
        leilao = new Leilao("Tablet XPTO");
    }

    @After
    public void tearDown() {
        System.out.println("after");
    }


    @Dado("um lance valido")
    public void dado_um_lance_valido() {
        Usuario usuario = new Usuario("Fulano");
        lance = new Lance(usuario, BigDecimal.TEN);

    }

    @Quando("propoe o leilao")
    public void quando_propoe_o_lance() {
        leilao.propoe(lance);
    }

    @Entao("o lance e aceito")
    public void entao_o_lance_e_aceito() {

        Assert.assertEquals(1, leilao.getLances().size());
        Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
    }

////////////////////////////////////////////////////////////////////////////////////////////////



    @Dado("um lance de {double} reais do usuario {string}")
    public void dado_um_lance_de_reais_usuario_fulano(double valor, String nomeUsuario) {

      Lance lance = new Lance(new Usuario(nomeUsuario), new BigDecimal(valor));

      lista.add(lance);

    }


    @Quando("propoe os leiloes")
    public void quando_propoe_os_leiloes() {

        this.lista.forEach(lance -> leilao.propoe(lance));

    }

    @Entao("os lances sao aceitos")
    public void entao_os_lances_sao_aceitos() {

        Assert.assertEquals(this.lista.size(), leilao.getLances().size());
        Assert.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
        Assert.assertEquals(this.lista.get(1).getValor(), leilao.getLances().get(1).getValor());
    }

}
