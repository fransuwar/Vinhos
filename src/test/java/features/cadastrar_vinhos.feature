# language: pt
Funcionalidade: Cadastrar vinhos
	Eu como gerente do sistema gostaria de cadastrar vinhos no sistema.
	O formulário de cadastro deve conter os seguintes campos: Nome, Tipo, Safra, Volume e Valor do Vinho.
	Todos os campos são obrigatórios.

	Contexto: 
		Dado que sou um gerente do sistema
		E gostaria de cadastrar vinhos no sistema.
	
	Cenário: cadastrar um vinho com sucesso
	    Quando informar nome vinho, tipo tinto, safra 2016, volume 750 e valor 45.0
	    Então o vinho deve ser cadastrado no sistema
	    E uma mensagem de sucesso deve ser exibida
	
	Cenário: cadastrar um vinho sem informar nome
	    Quando informar tipo tinto, safra 2016, volume 750 e valor 45.0
	    Então o vinho não deve ser cadastrado no sistema
	    E uma mensagem de erro deve ser exibida
	    
	Cenário: cadastrar um vinho sem informar tipo
	    Quando informar nome vinho, safra 2016, volume 750 e valor 45.0
	    Então o vinho não deve ser cadastrado no sistema
	    E uma mensagem de erro deve ser exibida
	   
	Cenário: cadastrar um vinho sem informar safra
	    Quando informar nome vinho, tipo tinto, volume 750 e valor 45.0
	    Então o vinho não deve ser cadastrado no sistema
	    E uma mensagem de erro deve ser exibida
	    
	Cenário: cadastrar um vinho sem informar volume
	    Quando informar nome vinho, tipo tinto, safra 2016 e valor 45.0 
	    Então o vinho não deve ser cadastrado no sistema
	    E uma mensagem de erro deve ser exibida
	    
	Cenário: cadastrar um vinho sem informar valor
	    Quando informar nome vinho, tipo tinto e safra 2016 
	    Então o vinho não deve ser cadastrado no sistema
	    E uma mensagem de erro deve ser exibida
	    
	Cenário: cadastrar um vinho sem informar nenhum dado
	    Quando não informar nome, tipo, safra, volume e valor 
	    Então o vinho não deve ser cadastrado no sistema
	    E uma mensagem de erro deve ser exibida
	    
	Cenário: cadastrar um vinho informando nome muito pequeno
	    Quando informar nome vi, tipo tinto, safra 2016, volume 750 e valor 45.0
	    Então o vinho não deve ser cadastrado no sistema
	    E uma mensagem de erro deve ser exibida
	    
	Cenário: cadastrar um vinho informando nome muito grande
	    Quando informar nome vinho amália do fim do mundo com gosto de lã, tipo tinto, safra 2016, volume 750 e valor 45.0
	    Então o vinho não deve ser cadastrado no sistema
	    E uma mensagem de erro deve ser exibida	    	    
	    
	Cenário: cadastrar um vinho informando valor negativo
	    Quando informar nome vinho, tipo tinto, safra 2016, volume 750 e valor -1.0
	    Então o vinho não deve ser cadastrado no sistema
	    E uma mensagem de erro deve ser exibida
	    
	Cenário: cadastrar um vinho informando volume negativo
	    Quando informar nome vinho, tipo tinto, safra 2016, volume -750 e valor 45.0
	    Então o vinho não deve ser cadastrado no sistema
	    E uma mensagem de erro deve ser exibida	 
	    
	Cenário: cadastrar um vinho informando valor absurdo
	    Quando informar nome vinho, tipo tinto, safra 2016, volume 750 e valor 10000.0
	    Então o vinho não deve ser cadastrado no sistema
	    E uma mensagem de erro deve ser exibida
	    
	Cenário: cadastrar um vinho informando volume absurdo
	    Quando informar nome vinho, tipo tinto, safra 2016, volume 20000 e valor 45.0
	    Então o vinho não deve ser cadastrado no sistema
	    E uma mensagem de erro deve ser exibida	            