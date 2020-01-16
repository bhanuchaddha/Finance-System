package com.bhanuchaddha.bank.apitest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.bhanuchaddha.bank.apitest.HelperMethods.*;

public class GenerateTraffic {

    @Test
    public void generateTraffic(){
        int numOfPayments = 50;
        Random random = new Random();
        List<Integer>  accountIds = getAllAccountIds();
        List<String> paymentReport = new ArrayList<>();

        for(int i = 1; i<= numOfPayments ;i++){
            int fromAccountIndex = random.nextInt(accountIds.size()-1);
            int toAccountIndex = random.nextInt(accountIds.size()-1);
            if(toAccountIndex==fromAccountIndex){ // just try one more time
                toAccountIndex = random.nextInt(accountIds.size()-1);
            }
            paymentReport.add(i+". from="+accountIds.get(fromAccountIndex)+" to="+accountIds.get(toAccountIndex)+" amount="+(random.nextInt(900)+100));
            createPayment(accountIds.get(fromAccountIndex), accountIds.get(toAccountIndex),128);
        }
        paymentReport.stream().forEach(System.out::println);
    }
}
