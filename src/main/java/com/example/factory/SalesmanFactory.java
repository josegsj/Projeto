package com.example.factory;


import java.math.BigDecimal;

import com.example.domain.Entity;
import com.example.domain.Salesman;

public class SalesmanFactory implements EntityFactory {

    @Override
    public Entity create(String register) {
        String[] splitedRegister = register.split("ç");
        return new Salesman(
                splitedRegister[1],
                splitedRegister[2],
                new BigDecimal(splitedRegister[3])
        );
    }

}
