@AllTest


Feature:(@api) Validar micros serviços para o desafio datum

  #######################################   services   ########################################

  @BuscaUsuarios
  Scenario: Retorna informacoes dos usuarios cadastrado
    Given que eu tenha uma lista de clientes cadastrados
    When realizo uma busca na lista de usuarios
    Then devo validar todas as informacoes referente aos usuarios cadastrados

  @CriarCadastro
  Scenario: Cadastrar um novo cliente
    Given que eu tenha as informações necessaria para cadastrar o novo usuario
    When realizo a inclusao do novo usuario no endpoit api/users
    Then devo validar que o usuario foi cadastrado com sucesso

 @Login
 Scenario Outline: Validar a funcionalidade de login com usuario valido e invalido
    Given que eu realize um login com "<USUARIO>" e "<SENHA>"
    Then devo receber "<STATUS_CODE>" e um token caso usuario e senha estejam certos
    And "<MENSAGEM>" e "<STATUS_CODE>" de erro caso os dados de acesso estejam errados
  Examples:
  |USUARIO           |SENHA      |STATUS_CODE|MENSAGEM|
  |eve.holt@reqres.in|cityslicka | 200       |                        |
  |user@invalido.in  |cityslicka | 400       |user not found          |
  |eve.holt@reqres.in|           | 400       |Missing password        |




