# language: pt
Funcionalidade: Login
  Teste funcionais com dados válido e inválidos

	@valid_login
  Cenario: Usuário e senha válidos
    Dado que o uauário está na página inicial
    Quando inserir os dados de usuário e senha válidos
    Então o usuário deverá estar logado
