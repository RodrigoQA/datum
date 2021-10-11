# Técnica Utilizada
-Cenarios escrito em gherkin com framework do cucumber, restAssured, hamcrest.


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
 - Após execusão dos testes é possivel visualizar um relatorio macro referente aos testes <br>
   Ex: target->cucumber-reports->report-html. 
   
                                                                 
 ![image](https://user-images.githubusercontent.com/55006541/136707258-b80bf4d2-fa9a-486e-8163-e614c4912a92.png)
 
![image](https://user-images.githubusercontent.com/55006541/136707196-8297e574-b515-4cc0-ba89-66086afe1967.png)

 ![image](https://user-images.githubusercontent.com/55006541/136707149-9c915ec2-2f2b-466d-b4aa-31ed7831e761.png)

"# datum" 
