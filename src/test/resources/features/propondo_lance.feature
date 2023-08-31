# language:pt

Funcionalidade: Propondo lances

Cenario: Propondo um unico lance valido
  Dado um lance valido
  Quando propoe o leilao
  Entao o lance e aceito

Cenario: Propondo varios lances validos
  Dado um lance de 10.0 reais do usuario "fulano"
  E um lance de 15.0 reais do usuario "beltrano"
  Quando propoe os leiloes
  Entao os lances sao aceitos

Esquema do Cenario: Propondo uma lance invalido
  Dado um lance invalido de <valor> reais
  Quando propoe o leilao
  Entao o lance nao e aceito

  Exemplos:

    |valor|
    |0    |
    |-100 |


Cenario: Propondo dois lances com o mesmo usuario
  Dado dois lances
    |valor|usuario|
    |10.0 |cigano |
    |15.0 |cigano |
  Quando propoe os leiloes
  Entao o segundo lance nao e aceito





  ####################################################################################



