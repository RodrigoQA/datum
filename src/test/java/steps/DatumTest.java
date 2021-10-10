package steps;


import com.github.javafaker.Faker;
import core.BaseTest;
import cucumber.api.java.en.*;
import org.hamcrest.Matchers;
import java.util.logging.Logger;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DatumTest extends BaseTest {

    private static Logger log = Logger.getLogger("QALogger");

    String novoUsuario ;
    String jobUsuario ;
    String senha ;
    String usuario ;




////////////////////////////////    DatumTest   ///////////////////////////////////////////


    @Given("que eu tenha uma lista de clientes cadastrados")
    public void queEuTenhaUmaListaDeClientesCadastrados() throws Throwable {
        given()
                .relaxedHTTPSValidation()
                .get("users?page=2")
                .then()
                .body("data", hasSize(6));
    }



    @When("realizo uma busca na lista de usuarios")
    public void realizoUmaBuscaNaListaDeUsuarios() throws Throwable {
        given()
                .relaxedHTTPSValidation()
                .get("users?page=2")
                .then()
                .statusCode(200);


}

    @Then("devo validar todas as informacoes referente aos usuarios cadastrados")
    public void devoValidarTodasAsInformacoesReferenteAosUsuariosCadastrados() throws Throwable {

        given()
                .relaxedHTTPSValidation()
                .get("users?page=2")
                .then()
                .body("data.email", hasSize(6))
                .body("data.first_name",hasSize(6))
                .body("data.last_name",hasSize(6))
                .body("data.avatar",hasSize(6))
                .body("data.first_name", Matchers.hasItems("Tobias", "Rachel","Michael"))
                .body("data.last_name", Matchers.hasItems("Ferguson", "Fields","Howell"))
                .body("data.avatar", Matchers.hasItems("https://reqres.in/img/faces/10-image.jpg", "https://reqres.in/img/faces/9-image.jpg"))
                .body("data.email", Matchers.hasItems("michael.lawson@reqres.in", "lindsay.ferguson@reqres.in","george.edwards@reqres.in"));
        System.out.println("====> LISTA DE USUARIOS VALIDADA COM SUCESSO!");
        System.out.println("----------------------------------------------------");


}



    @Given("^que eu realize um login com \"([^\"]*)\" e \"([^\"]*)\"$")
    public void queEuRealizaUmLoginComE(String user, String password) throws Throwable {
      usuario = user;
      senha = password;



    }

    @Then("^devo receber \"([^\"]*)\" e um token caso usuario e senha estejam certos$")
    public void devoReceberStatusCode200EUmTokenCasoUsuarioESenhaEstejamCertos( int status) throws Throwable {
    if (usuario.equals("eve.holt@reqres.in")&&senha.equals("cityslicka")) {
        given()
                .relaxedHTTPSValidation()
                .body(" { \"email\": \"" + usuario + "\",\"password\": \"" + senha + "\" }")
                .post("login")
                .then()
                .statusCode(status)
                .body("token", notNullValue());
        System.out.println("====> LOGIN REALIZADO COM SUCESSO!");
        System.out.println("user: "+usuario);
        System.out.println("senha: "+senha);
        System.out.println("----------------------------------------------------");
        }

    }


    @Then("^\"([^\"]*)\" e \"([^\"]*)\" de erro caso os dados de acesso estejam errados$")
    public void umStatusCode400EMensagemDeErroCasoOsDadosDeAcessoEstejamErrados(String msgErro, int status) throws Throwable {
        if (usuario.contains("invalido")){
            given()
                    .relaxedHTTPSValidation()
                    .body(" { \"email\": \""+usuario+"\",\"password\": \""+senha+"\" }")
                    .post("login")
                    .then()
                    .statusCode(status)
                    .body("error",is(msgErro));
            System.out.println("====> LOGIN COM USER INVALIDO!");
            System.out.println("user: "+usuario);
            System.out.println("senha: "+senha);
            System.out.println("----------------------------------------------------");

        }else if (senha.equals("")){
            given()
                    .relaxedHTTPSValidation()
                    .body(" { \"email\": \""+usuario+"\",\"password\": \""+senha+"\" }")
                    .post("login")
                    .then()
                    .statusCode(status)
                    .body("error",is(msgErro));
            System.out.println("====> LOGIN SEM SENHA");
            System.out.println("user: "+usuario);
            System.out.println("senha: "+senha);
            System.out.println("----------------------------------------------------");
        }


    }

    @Given("^que eu tenha as informações necessaria para cadastrar o novo usuario$")
    public void queEuTenhaAsInformaçõesNecessariaParaCadastrarONovoUsuario() throws Throwable {
        Faker faker = new Faker();
        novoUsuario = faker.name().fullName();
        jobUsuario = faker.job().title();

    }

    @When("^realizo a inclusao do novo usuario no endpoit api/users$")
    public void realizoAInclusaoDoNovoUsuarioNoEndpoitApiUsers() throws Throwable {
        given()
                .relaxedHTTPSValidation()
                .body(" { \"name\": \""+novoUsuario+"\",\"job\": \""+jobUsuario+"\" }")
                .post("users")
                .then()
                .statusCode(201)
                .body("name",is(novoUsuario))
                .body("job",is(jobUsuario))
                .body("id",is(notNullValue()));



    }

    @Then("^devo validar que o usuario foi cadastrado com sucesso$")
    public void devoValidarQueOUsuarioFoiCadastradoComSucesso() throws Throwable {
        System.out.println("====> CADASTRO REALIZADO COM SUCESSO! " );
        System.out.println("nome: " +novoUsuario);
        System.out.println("job: "  +jobUsuario);
        System.out.println("----------------------------------------------------");


    }


}

