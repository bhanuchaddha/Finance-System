package com.bhanuchaddha.bank.apitest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.with;

@UtilityClass
public class HelperMethods {

    int createCustomer(){
        RestAssured.reset();
        RestAssured.baseURI="http://localhost:8083";

        return with()
                .body("{\"name\":\"customer 1\",\"address\":\"copenhagen\"}")
                .contentType(ContentType.JSON)
                .when()
                .request(Method.POST,"/customers")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .body().jsonPath().get("id");
    }

    int createAccount(int customerId){
        RestAssured.reset();
        RestAssured.baseURI="http://localhost:8081";

        return with()
                .body("{\"customerNumber\":"+customerId+",\"amount\":2000}")
                .contentType(ContentType.JSON)
                .when()
                .request(Method.POST,"/accounts")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .body().jsonPath().get("number");
    }
    int createPayment(int fromAccount, int toAccount, int amount){
        RestAssured.reset();
        RestAssured.baseURI="http://localhost:8082";

        return with()
                .body("{\"fromAccount\":"+fromAccount+",\"toAccount\":"+toAccount+",\"amount\":"+amount+"}")
                .contentType(ContentType.JSON)
                .when()
                .request(Method.POST,"/payments")
                .then()
                .statusCode(201)
                .extract()
                .response()
                .body().jsonPath().get("id");
    }

    Response getPayment(int id){
        RestAssured.reset();
        RestAssured.baseURI="http://localhost:8082";
        return get("/payments/{paymentId}",id)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    List<Integer> getAllAccountIds(){
        RestAssured.reset();
        RestAssured.baseURI="http://localhost:8081";

        return get("/accounts")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getList("number")
                ;
    }
}
