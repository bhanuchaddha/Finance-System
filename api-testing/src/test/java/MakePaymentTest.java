import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class MakePaymentTest {

    @Before
    public void setup(){
        RestAssured.reset();
    }

    @Test
    public void fullScenario(){
        int customer1 = createCustomer();
        int customer2 = createCustomer();
        int account1 = createAccount(customer1);
        int account2 = createAccount(customer2);
        int paymentId = createPayment(account1, account2, 400);
        Response payment = getPayment(paymentId);
        payment.then().assertThat()
                .body("fromAccount",equalTo(account1))
                .body("toAccount",equalTo(account2))
                .body("amount",equalTo(400f));

    }

    private int createCustomer(){
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

    private int createAccount(int customerId){
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
    private int createPayment(int fromAccount, int toAccount, int amount){
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

    private Response getPayment(int id){
        RestAssured.reset();
        RestAssured.baseURI="http://localhost:8082";
        return get("/payments/{paymentId}",id)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }
}
