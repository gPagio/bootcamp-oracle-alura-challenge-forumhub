# 📚 Fórum Hub API - Oracle ONE
Este é o Forum Hub, projeto do segundo challenge proposto na formação `Java e Spring Framework T6 - ONE`, a qual formação pertence à grade do programa Oracle ONE.

## 💡Objetivo
O objetivo deste desafio foi proporcionar uma experiência real no mundo do desenvolvimento. Foi proposto para os alunos a contrução de uma `API Rest`, a qual seria o `backend` de um fórum realizando um `CRUD`.

No [`último projeto`](https://github.com/gPagio/bootcamp-oracle-alura-challenge-literalura) construído proposto pelo Oracle One, os dados eram oriundos da API Gutendex. O projeto atual gera os próprios dados, já que o mesmo possui todos os `endpoints` necessários para realizar um CRUD. Vale a pena mencionar que essa API persiste os dados em um banco de dados `MySQL` por meio da API do `Spring Boot` que se chama `Spring Data JPA`.

## 📝 End Points
### 🟢 Swagger
Os end points dessa API estão mapeados com o Swagger. Para acessar esse mapeamento, rode o projeto e entre em:

```
http://localhost:8080/swagger-ui/index.html#/
```

### 🐶 Bruno
Além do Swagger, na pasta raiz do projeto existe uma pasta chamada endpoints, onde a mesma possui todos os endpoints usados para testar a API.

Para fazer o uso desses arquivos intale o [`Bruno`](https://www.usebruno.com/) e importe a coleção de endpoints (pasta mencionada anteriormente) pelo botão `Open Collection`, o qual pode ser encontrado clicando em três pontinhos do lado esquerdo da tela.

## 📌 Dependências
Para o correto funcionamento do Fórum Hub, é necessário realizar a instalação das dependências abaixo. Clique no hyperlink em cada uma delas para ir a respectiva página de downloads.
 - [`MySQL`](https://dev.mysql.com/downloads/installer/): Banco de dados usado pelo Fórum Hub
 - [`Maven`](https://maven.apache.org/install.html): Gerenciador de dependências usado pelo Fórum Hub

## ⚙️ Configurações
Antes de executar o projeto devemos configurar algumas variáveis de ambiente em nossa máquina.

Abaixo estão listadas as variáveis de deverão ser criadas e o conteúdo que deve conter em cada uma delas:
|Variável|Conteúdo|Exemplo|
|---|---|---|
|`DB_FORUMHUB_API_HOST`|Host do banco de dados. O endereço para acessar o mesmo juntamente com a porta|127.0.0.1:3306|
|`DB_FORUMHUB_API_DATABASE`|Informa o nome do banco de dados que o Fórum Hub irá persistir|forum_hub|
|`DB_FORUMHUB_API_USER`|Informa o nome do usuário para se conectar ao banco de dados|root|
|`DB_FORUMHUB_API_PASSWORD`|Informa a senha do usuário definido na variável anterior|10203040|
|`JWT_FORUMHUB_API_SECRET`|Informa a chave secreta utilizada para assinar e verificar a autenticidade dos tokens JWT. Deve ser um número aleatório e secreto.|91723847|

## 🚀 Uso
Para executar o projeto temos duas opções:

### 1ª Opção
Abra o mesmo com a `IDE IntelliJ IDEA` e execute o método abaixo na classe `ForumhubApplication`:

``` Java
public static void main(String[] args)
```


### 2ª Opção
Entre na pasta do projeto pelo terminal e execute o comando abaixo:

```
mvn spring-boot:run
```
> [!NOTE]
> Caso encontre problemas com o Maven na execução do Fórum Hub, instale a versão `3.9.5`, que foi usada na construção do projeto.

Após a execução do programa, enviar uma requisição para o end point `/login`, informando email e senha em um `JSON` (estes que devem estar previamente cadastrados no banco de dados na tabela `Usuarios`, sendo a senha criptografada pelo BCrypt), para pegar o `Token JWT`.

Em seguida, basta usar normalmente os demais end poins para realizar as ações desejadas, informando o Token JWT para realizar sua autenticação. Vale mencionar que o Token JWT possui uma duração máxima de `duas horas`, ou seja, a cada duas horas se faz necessário obter um novo Token JWT.

## ⚠️ Avisos
1. Este projeto foi construído e testado sobre o JDK 17, dessa forma recomendamos o uso do mesmo durante a execução do mesmo.
