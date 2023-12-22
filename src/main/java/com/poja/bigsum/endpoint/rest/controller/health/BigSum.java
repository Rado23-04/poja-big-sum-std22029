package com.poja.bigsum.endpoint.rest.controller.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
@RestController
public class BigSum {
    @GetMapping("/big-sum/{a}/{b}")
    public String getBigSum(
            @PathVariable String a,
            @PathVariable String b
    ) {
        try {
            BigInteger numA = new BigInteger(a);
            BigInteger numB = new BigInteger(b);

            BigInteger result = numA.add(numB);

            return "Result: " + result.toString();
        } catch (NumberFormatException e) {
            return "Les paramètres 'a' et 'b' doivent être des nombres valides.";
        }
    }
}
