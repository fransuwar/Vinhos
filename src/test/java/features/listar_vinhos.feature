# language: pt
Funcionalidade: Listar vinhos
	Eu como funcionário cadastrado no sistema gostaria de visializar a listagem de vinhos cadastrados no sistema.

	Contexto: 
		Dado que sou um funcionário cadastrado no sistema
		E gostaria de consultar os vinhos cadastrados no sistema
	
	Cenário: Listar vinhos quando existe vinho cadastrado no sistema
	    Quando seleciono a opção para listar vinhos
	    E existem vinhos cadastrados no sistema
	    Então os vinhos cadastrados no sistema são listados
	
	Cenário: Listar vinhos quando não existe vinho cadastrado no sistema
		Quando seleciono a opção para listar vinhos
		E não existem vinhos cadastrados no sistema
	    Então uma mensagem de feedback deve ser exibida