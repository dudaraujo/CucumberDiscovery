# language: pt

  Funcionalidade: Apenas usuários cadastrados podem logar no sistema

  Cenario: Um usuário valido consegue logar
    Dado um usuario valido
    Quando ele realiza o login
    Entao e redirecionado para a pagina de leiloes


Cenário: Um usuario inválido não consegue logar
Dado um usuario invalido
Quando ele tenta realizar o login
Entao continua na pagina de login