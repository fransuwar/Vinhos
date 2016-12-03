# language: pt
Funcionalidade: Listar vinhos
	Eu como usuário do sistema gostaria de visializar a listagem de vinhos cadastrados no sistema.

	Contexto: 
		Um usuário gostaria de consultar os vinhos cadastrados no sistema.
	
	Cenário: Listar vinhos quando existe vinho cadastrado no sistema
	    Quando seleciono a opção listar vinhos
	    E existem vinhos cadastrados
	    Então os vinhos cadastrados no sistema são listados
	
	Cenário: Listar vinhos quando não existe vinho cadastrado no sistema
		Quando seleciono a opção listar vinhos
		E não existem vinhos cadastrados
	    Então uma mensagem de feedback deve ser exibida