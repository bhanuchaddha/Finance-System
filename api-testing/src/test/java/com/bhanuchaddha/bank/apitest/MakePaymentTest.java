package com.bhanuchaddha.bank.apitest;

import io.restassured.response.Response;
import org.junit.Test;

import static com.bhanuchaddha.bank.apitest.HelperMethods.*;
import static org.hamcrest.Matchers.equalTo;

public class MakePaymentTest {

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


}
