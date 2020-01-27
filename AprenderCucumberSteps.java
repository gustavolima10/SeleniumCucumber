package br.ce.gutavolima.steps;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import br.ce.gutavolima.converters.DateConverter;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AprenderCucumberSteps {
	
//	@Given("^que criei o arquivo corretamente$")
//	public void que_criei_o_arquivo_corretamente() throws Throwable {
	@Given("^que criei o arquivo corretamente$")
	public void queCrieiOArquivoCorretamente() throws Throwable {
		System.out.println("qualquer coisa");
	}

	@When("^executa-lo$")
	public void executaLo() throws Throwable {

	}

	@Then("^a especificacao deve finalizar com sucesso$")
	public void aEspecificacaoDeveFinalizarComSucesso() throws Throwable {

	}
	
	
	private int contador = 0;
	
	@Given("^que o valor do contador é (\\d+)$")
	public void queOValorDoContadorÉ(int arg1) throws Throwable {
		contador = arg1;
		
	}

	@When("^incrementar em (\\d+)$")
	public void incrementarEm(int arg1) throws Throwable {
	    contador = contador + arg1;
	}

	@Then("^valor do contador sera (\\d+)$")
	public void valorDoContadorSera(int arg1) throws Throwable {
//	    Assert.assertTrue(arg1 == contador);
	    Assert.assertEquals(arg1, contador);
	}

	Date entrega = new Date();
	
	@Given("^que o prazo é dia (.*)$")
	public void queOPrazoÉDia(@Transform(DateConverter.class) Date data) throws Throwable {
		entrega = data;
		System.out.println(entrega);
	}

	@When("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
	public void aEntregaAtrasarEmDias(int arg1, String tempo) throws Throwable {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(entrega);
	    if(tempo.equals("dias")) {
	    cal.add(Calendar.DAY_OF_MONTH, arg1);
	    }
	    if(tempo.equals("meses")) {
		    cal.add(Calendar.MONTH, arg1);
		    }
	    entrega = cal.getTime();
	}

	@Then("^a entrega sera efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void aEntregaSeraEfetuadaEm(String data) throws Throwable {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = format.format(entrega);
		Assert.assertEquals(data, dataFormatada);
	}
	
	@Given("^que o ticket( especial)? é  A.(\\d+)$")
	public void queOTicketÉAF(String tipo, int arg1) throws Throwable {


	}

	@Given("^que o valor da passagem é R\\$ (.*)$")
	public void queOValorDaPassagemÉR$(Double numero) throws Throwable {
		System.out.println(numero);


	}

	@Given("^que o nome do passageiro é \"(.*)\"$")
	public void queONomeDoPassageiroÉ(String arg1) throws Throwable {
	
	}

	@Given("^que o telefone do passageiro é (\\d+)-(\\d+)$")
	public void queOTelefoneDoPassageiroÉ(int arg1, int arg2) throws Throwable {

	}

	@When("^criar os steps$")
	public void criarOsSteps() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^o teste vai funcionar$")
	public void oTesteVaiFuncionar() throws Throwable {
	
	}

	    
	

}
