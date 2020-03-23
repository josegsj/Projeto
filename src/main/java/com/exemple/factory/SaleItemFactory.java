package com.exemple.factory;

import java.math.BigDecimal;

import com.example.domain.Entity;
import com.example.domain.SaleItem;

public class SaleItemFactory implements EntityFactory {

    public SaleItemFactory() {
    }

    @Override
    public Entity create(String register) {
        String[] splitedRegistries = register.split("-");
        return new SaleItem(
                new Long(splitedRegistries[0]),
                new Long(splitedRegistries[1]),
                new BigDecimal(splitedRegistries[2])
        );
        
    }
    
    
    
}
