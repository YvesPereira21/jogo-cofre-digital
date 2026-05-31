# Jogo cofre digital

Este projeto é uma aplicação Cliente-Servidor multithread desenvolvida em Java. O sistema implementa um jogo de adivinhação onde múltiplos clientes podem se conectar simultaneamente a um servidor para tentar adivinhar um número secreto e ganhar prêmios em dinheiro retirados de um cofre compartilhado.
O projeto está dividido em dois pacotes principais para separar as responsabilidades:

* `sockets/`
    * `Servidor.java`: Classe principal do servidor que gerencia a porta `2004` e aceita novas conexões.
    * `Cliente(Número).java`: Classes dos jogadores, responsável por enviar e receber mensagens do servidor.
* `processos/`
    * `Cofre.java`: Objeto partilhado que guarda o valor do fundo. Possui métodos sincronizados entre múltiplos jogadores.
    * `ProcessoServidor.java`: Thread responsável por gerenciar a sessão de cada cliente.

Para testar o projeto corretamente, você precisará executar as classes dentro da sua própria IDE. O Servidor deve sempre ser iniciado **antes** do(s) Cliente(s).
