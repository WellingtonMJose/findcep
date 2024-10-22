# Documentação do Projeto: Sistema de Busca de CEP
### 1. Introdução
   #### 1.1 Contexto
   Em um mundo onde a logística e o atendimento ao cliente são cruciais, a possibilidade de acessar rapidamente informações de endereços por meio de um CEP é essencial. Este projeto visa fornecer uma solução eficiente para a busca de dados de endereço, permitindo que os usuários consultem informações relevantes a partir do CEP.

#### 1.2 Objetivo
O objetivo deste projeto é criar uma aplicação web que possibilite a busca de informações de endereço (rua, cidade, estado, DDD) usando um CEP. Além disso, a aplicação registra o histórico das buscas em um banco de dados, permitindo análises futuras e controle das consultas realizadas.

### 2. Funcionalidades
  #### 2.1 Busca de CEP
   O usuário pode consultar um CEP por meio de um endpoint específico.
   A resposta inclui os seguintes dados:
   Rua
   CEP
   Cidade
   Estado
   DDD
   #### 2.2 Armazenamento de Dados
   Todos os dados da busca são armazenados no banco de dados, incluindo:
   Horário da busca
   CEP consultado
   Dados retornados (rua, cidade, estado, DDD)
   #### 2.3 Visualização de Logs
   A aplicação oferece um endpoint dedicado para visualizar as buscas salvas.
   Os logs podem ser filtrados por data, CEP ou outros parâmetros conforme necessário.
### 3. Tecnologias Utilizadas
   #### 3.1 Backend
   Java com Spring Boot: Utilizado para criar uma API RESTful robusta e escalável.
   #### 3.2 Banco de Dados
   PostgreSQL: Escolha do banco de dados relacional para garantir consistência e suporte a consultas complexas.
   #### 3.3 Documentação
   Swagger: Ferramenta utilizada para gerar documentação interativa da API, facilitando o entendimento e a exploração dos endpoints disponíveis.
   #### 3.4 Hospedagem
   Render: Plataforma de hospedagem gratuita que permite o deploy contínuo da aplicação, garantindo alta disponibilidade e escalabilidade.
   ### 4. Estrutura da Aplicação
#### 4.1 Componentes Principais
   Controller de Busca de CEP: Responsável por lidar com requisições de busca, consultar a API externa (ViaCEP) e retornar os dados ao usuário.
   Controller de Logs: Permite ao usuário visualizar o histórico de buscas realizadas.
   Serviço de CEP: Interage com a API externa para obter informações de endereço.
   Repositório: Gerencia a persistência de dados no PostgreSQL, utilizando JPA para simplificar operações de banco de dados.
####  4.2 Diagrama da Arquitetura
   (Incluir um diagrama de classes ou um fluxo de dados para visualização da arquitetura do sistema.)

### 5. Endpoints da API
#### 5.1 Busca de CEP
   Endpoint: GET /cep/{cep}
   Descrição: Realiza a busca de informações de endereço com base no CEP fornecido.
   Resposta Exemplo:
   ### json
~~~
   {
   "cep": "01201-050",
   "logradouro": "PRACA OLAVO BILAC",
   "bairro": "CAMPOS ELISEOS",
   "localidade": "São Paulo",
   "uf": "SP",
   "ddd": "11"
   } 
   ~~~
   ### 5.2 Visualização de Logs
   Endpoint: GET /logs
   Descrição: Retorna um histórico de buscas realizadas, com parâmetros de filtragem.
   Resposta Exemplo:
   ### json
   
   ~~~[
   {
   "hora": "2024-10-20T14:40:17.925-03:00",
   "cep": "07260-470",
   "logradouro": "Rua Victorino Bento Lorena da Silva",
   "bairro": "Jardim Angélica",
   "localidade": "Guarulhos",
   "uf": "SP"
   },
   ...
   ] 
   ~~~
### 6. Como Executar o Projeto
   #### 6.1 Pré-requisitos
   JDK 21(JAVA)<br>
   PostgreSQL<br>
   Maven
Spring
   #### 6.2 Configuração do Banco de Dados
   Crie um banco de dados no PostgreSQL.<br>
   Configure o application.properties para incluir as credenciais do banco de dados.
   #### 6.3 Executar a Aplicação
   Navegue até o diretório do projeto e execute:
   bash
   `mvn spring-boot:run`
### 7. Considerações Finais
   #### 7.1 Vantagens do Projeto
   Acesso rápido e eficiente a informações de endereços.
   Armazenamento de histórico de buscas para análises futuras.
   Interface amigável gerada pelo Swagger, facilitando a interação com a API.
   #### 7.2 Futuras Melhorias
   Implementar autenticação para proteger endpoints.
   Adicionar funcionalidades para filtrar e exportar logs.
   Melhorar a performance das consultas e otimizar a estrutura do banco de dados.