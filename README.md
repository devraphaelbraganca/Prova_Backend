# Prova_Backend
prova/explicação

Meu programa funciona da seguinte maneira:

Utilizando o link "http:localhost:8080/api/produtos"

http://localhost:8080/api/produtos - 
Post: Cria produtos

{
       "codigo": 12,
       "nome": "feijao",
       "quantidade": 10,
       "valor": 4
}

Get: Lista todos os produtos

http://localhost:8080/api/produtos/{codigo} -
Get: Lista o produto com o codigo descrito
Delete: Deleta o produto

http://localhost:8080/api/produtos/vendas -
Get: Lista as vendas

http://localhost:8080/api/produtos/venda/{codigo}/{solicitacao} - 
Post: Faz uma venda
