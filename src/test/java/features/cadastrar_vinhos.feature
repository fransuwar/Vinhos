# language: pt
Funcionalidade: Cadastrar vinhos
	Eu como gerente cadastrado no sistema gostaria de cadastrar vinhos no sistema.
	O formulário de cadastro deve conter os seguintes campos: Nome, Tipo, Safra, Volume e Valor do Vinho.
	Todos os campos são obrigatórios.

	Contexto: 
		Dado que sou um gerente cadastrado no sistema
		E desejo cadastrar vinhos no sistema
	
	Cenário: cadastrar um vinho com sucesso
	    Quando informar nome vinho, tipo tinto, safra 2016, volume 750 e valor 45.0
	    Então o vinho deve ser cadastrado no sistema
	    E uma mensagem de sucesso deve ser exibida