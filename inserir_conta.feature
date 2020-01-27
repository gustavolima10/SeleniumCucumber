Feature: Cadastro de contas

	Como um usuario
	Gostaria de cadastrar contas 
	Para que eu possa distribuir meu dinheiro de uma forma mais organizada

Background: 

Given que estou acessando a aplicacao
When informo o usuario "gustavo.lima2@live.com"
And a senha "Sparta26"
And seleciono entrar
When visualizo a pagina inicial
Then seleciono Contas
And seleciono Adicionar

Scenario Outline: Deve validar regras cadastro contas

And informo a conta "<conta>"
And seleciono Salvar
Then recebo a mensagem "<mensagem>"

Examples:

| conta 				| mensagem 						     |
| Conta de Teste		| Conta adicionada com sucesso!	     |
|						| Informe o nome da conta		     |
| Conta de Teste		| Já existe uma conta com esse nome! |
