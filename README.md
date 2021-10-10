


# CONFIGURAÇÃO DE AMBIENTE DE DESENVOLVIMENTO INTEGRADO #
<h2> IDE </h2>
Plugin's <br>
- Junit <br>
- Cucumber for Java

# CLASSE RUNNER MAIN #
<h2> Configurar web.runner </h2>
 - Acessar 'Run' <br>
 - Edit configurations <br>
 - Selecionar 'JUNIT' <br>
 - Incluir novo com nome 'Runner' <br>
 - Test kind: 'Class' <br>
 - Class: 'runner.Runner' <br>
 - VM options: '-ea' <br>
 - Working diretory: '$MODULE_WORKING_DIR$' 
 <h2> Tags </h2>
 - Alterar a tag a ser executado na class web.runner <br>
 - A opção 'tags = ("@test")' identifica qual tag sera executada
 
 # RELATORIO DE EXECUÇÃO DOS TESTES- DASHBOARD (API) #
 <h2> Tags </h2>
 - Após execusão dos testes é possivel visualizar um relatorio macro referente aos testes <br>
   Ex: target->cucumber-reports->report-html. 
   
 

 
"# datum" 
