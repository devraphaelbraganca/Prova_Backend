<h1> Esse projeto foi feito por <a  href="https://github.com/lcamaraol/">Bernardo, e pelo <a  href="https://github.com/flexxphael/">Raphael. <img  src="https://www.gamerview.com.br/wp-content/uploads/2019/12/dark-souls.gif" width="50px"></h1>


# Prova_Backend
prova/explicação

Meu programa funciona da seguinte maneira:

Utilizando o link "http:localhost:8080/api/produtos"

http://localhost:8080/api/produtos - 
Post: Cria produtos

{
       "codigo do produto": 12,
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

http://localhost:8080/api/produtos/venda/{codigo}/{quantidade do produto} - 
Post: Faz uma venda

