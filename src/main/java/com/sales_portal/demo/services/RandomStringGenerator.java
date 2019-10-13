package com.sales_portal.demo.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
class RandomStringGenerator {

    String getAlphaNumericString(int n)
    {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }


    public String linkCreator(String activationCode){
        //String activationCode = getAlphaNumericString(20);
        String link = "http://localhost:8080/userValidation" + "?" + "activationCode=" + activationCode;

        return link;
    }
}