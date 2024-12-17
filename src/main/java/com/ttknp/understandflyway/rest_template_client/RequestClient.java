package com.ttknp.understandflyway.rest_template_client;


import com.ttknp.understandflyway.entities.Product;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


public class RequestClient {
    /*
      RestTemplate is a class within the Spring framework we will understand how to use RestTemplate for invoking REST APIs of different shapes.
      Once the above spring application is up and running,
      test all Spring rest APIs and logging results with the below Spring rest client
      (Making an HTTP GET Request to Obtain the JSON Response)
      to honestly we can use them(this class) instead Postman! ???
    * */
    private final RestTemplate RESTTEMPLATE;
    private HttpHeaders headers;
    private HttpEntity httpEntity;
    private ResponseEntity responseEntity;
    private final String ENDPOINT_PRODUCTS= "http://localhost:8080/api/product";
    private final String ENDPOINT_USERS= "http://localhost:8080/api/user";
    private final Logger logger;

    public RequestClient() {
        RESTTEMPLATE = new RestTemplate();
        logger = LoggerFactory.getLogger(RequestClient.class);
    }

    private void readsUsers () {
        responseEntity = RESTTEMPLATE.exchange(ENDPOINT_USERS+"/reads" , HttpMethod.GET , null , String.class);
        log(responseEntity);
    }



    private void readsProducts () {
        responseEntity = RESTTEMPLATE.exchange(ENDPOINT_PRODUCTS+"/reads" , HttpMethod.GET , null , String.class);
        log(responseEntity);
    }



    private void readProduct () {
            responseEntity = RESTTEMPLATE.exchange(ENDPOINT_PRODUCTS+"/read?id=6" , HttpMethod.GET , null , String.class);
        log(responseEntity);
    }

    private void createProduct() {
        headers = new HttpHeaders();  // Use HttpHeaders to set the Request Headers.
        headers.setAccept(List.of(MediaType.APPLICATION_JSON)); // importance for returning like json object
        Product product = new Product();
        product.setName("A");
        product.setSku("A");
        product.setActive(true);
        product.setQuantity(1);
        product.setPrice(1.1);
        // Use HttpEntity to wrap the request object.
        httpEntity = new HttpEntity<>(product); // for request to server
        // exchange() is executes a specified HTTP method, such as GET, POST, PUT, etc, and returns a ResponseEntity containing both the HTTP status code and the resource as an object.
        responseEntity = RESTTEMPLATE.exchange(ENDPOINT_PRODUCTS+"/create" , HttpMethod.POST , httpEntity , String.class);
        log(responseEntity);
    }

    private void updateProduct() {
        // Map< String, String > params = new HashMap< String, String >();
        // params.put("id", "6"); // key id value 1 for path read/{id}
        // another way
        Product product = new Product();
        product.setName("B");
        product.setSku("B");
        product.setActive(true);
        product.setQuantity(1);
        product.setPrice(1.1);
        httpEntity = new HttpEntity<>(product);
        responseEntity = RESTTEMPLATE.exchange(ENDPOINT_PRODUCTS+"/update?id=6",HttpMethod.PUT,httpEntity,String.class);
        log(responseEntity);
    }

    private void deleteProduct() {
        // Map< String, String > params = new HashMap< String, String >();
        // params.put("id", "1"); // key id value 1 for path read/{id}
        // RESTTEMPLATE.delete(ENDPOINT_PRODUCTS+"/delete?id=6");
        // another way
        responseEntity = RESTTEMPLATE.exchange(ENDPOINT_PRODUCTS+"/delete?id=6" , HttpMethod.DELETE , null , String.class);
        log(responseEntity);
    }


    private void log(@NonNull ResponseEntity responseEntity) {
        logger.warn("responseEntity {}",responseEntity);
        logger.warn("responseEntity.getBody() {}",responseEntity.getBody());
    }


    public static void main(String[] args) {
        RequestClient requestClient = new RequestClient();
        // requestClient.readsProducts();
        // requestClient.createProduct();
        // requestClient.updateProduct();
        // requestClient.deleteProduct();
        requestClient.readsUsers();
    }
}