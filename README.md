 <h1> Projeto para consumo de API externa </h1>

<p id="sobre" align="center">
📱Esse projeto tem como finalidade a implementação de uma aplicação para consumir uma api externa.
Nesse caso em específico, a API escolhida foi a da tabela FIPE.

📱<b> A API externa a ser consumida pode ser encontrada aqui: </b>
 - <p>API FIPE para <a href="https://documenter.getpostman.com/view/7064033/SWT5jMGk#intro">Postman</a>.</p>


📱 <b> Nesse projeto foram usadas as seguintes tecnologias: </b>

- Spring;
- Maven;
- JUnit;
- REDIS;
- Spring Cache;
- Open Feign;
- Prometheus;
- Docker.

 <h4 align="left">  
📱Projeto finalizado ✔
</h4>

### 📱 Pré-requisitos<a id="pre-requisitos"></a>

- Possuir o Docker devidamente instalado na máquina;
- Postman para realizar os testes às requisições;
- Java 11.

### 📱 Build do projeto via docker <a id="pre-requisitos"></a>

- Executar os seguintes comandos:

build da aplicação:

<b> 1. docker build -t fipe-api-v1.jar .</b> 

docker run para acesso local:

<b>2. docker run -p 8080:8081 -d fipe-apiv1.jar</b>

docker run para REDIS:

<b>3. docker run --name redis-fipe -d -p 6379:6379 redis </b>

- Após realizar o processo de build, para acessar a aplicação e realizar as chamadas à API externa, substituia a URL https://parallelum.com.br/fipe/api/v1/carros pela porta que estiver sendo utilizada para testar a aplicação:
- ex: localhost:8080/marcas

### 📱 Features: <a id="pre-requisitos"></a>

- A aplicação possui testes unitários;
- Foram aplicados padrões de projeto, como Princípio da Responsabilidade Única e Princípio Aberto-Fechado (presentes no SOLID)
- É possivel visualizar e monitorar a aplicação através do actuator:
- Este está na porta 8081, basta acessar http://localhost:8081/actuator da sua máquina e acessar as métricas;
- Por padrão, a aplicação está rodando na porta 8080, seja localmente ou através da containerização.


