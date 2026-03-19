# POKE-STORE

## Project modules

- [Contracts](#contracts)
- [Cardstore](#cardstore)
- [Gateway](#gateway)
- [Supservice](#supservice)
- [Nginx](#nginx)

## Contracts

Módulo suporte apenas para compartilhar Classes em comum entre as aplicações
Ex: cardstore e o serviço se email usam a mesma classe (EmailEvent) quando ultilizando Kafka para comunicação assync.

## Cardstore

API principal da aplicação, reponsavel por guardar as informações das cartas, decks, coleções; ela não é reposnsavel por mais nada além do core da loja, como por exemplo autenticação, routing.  

## Gateway

Módulo responsavel por receber as requisições do Nginx e enviar para os serviços devidos, juntamente se a requisição for para a API o serviço validará o token automaticamente.

## supservice

Esse módulo guarda varios microserviços em uma aplicação apenas, esses microserviços funcionariam separadamente cada em seu proprio container, por performance todos serão reunidos nesta aplicação.

- Email
- Autenticação
- cadastro de usuários

## Nginx

Porta de entrada de todo o projeto, todas as requisições serão recebidas por esse container e direcionadas ao Cloud Gatway que redirecionara ao devido serviço Spring.
