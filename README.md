# costumer-api

Aplicação para cadastro de clientes a ser utilizada na disciplina de Apis Rest com Java e Spring da UNIFACEF.

# A solução

![image](https://user-images.githubusercontent.com/39503653/148442635-d106da43-9e54-4ba3-8ace-0db72a86452d.png)


# car-api

Microsserviço responsável pelo CRUD de carros via HTTP, por persistir no mongo e enviar para a rental-api.

# price-api

Microsserviço responsável pelo CRUD de preços via HTTP, por persistir no mongo e enviar para a rental-api.

# costumer-api

Microsserviço responsável pelo CRUD de clientes via HTTP, por persistir no mongo e enviar para a rental-api.

# Arquitetura utilizada na solução: Hexagonal

![image](https://user-images.githubusercontent.com/39503653/148442909-316d819c-df4e-4c0d-8767-54a90261d2fd.png)


# Tecnologias Utilizadas

* Java 8 
* MongoDB 
* Lombok 
* Spring Boot 
* Spring Data 
* Open Feign 
* FF4J


# Executando a API

Criar um banco de dados mongo local chamado costumer-api, ou alterar o arquivo application.yml atualizando-o para o endereço mongo correto. Após subir essa aplicação ficará disponível em http://localhost:8083 Swagger disponível em: http://localhost:8083/swagger-ui.html FF4J disponível em: http://localhost:8083/ff4j-console/
