package com.exemple.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.domain.Entity;
import com.example.domain.Sale;
import com.example.domain.SaleItem;

public class SaleFactory implements EntityFactory {

    @Override
    public Entity create(String register) {
        String[] splitedRegistries = register.split("ç");
        Sale sale = new Sale(
                new Long(splitedRegistries[1]),
                splitedRegistries[3],
               createSaleItems(splitedRegistries[2])
        );        
        return sale;
    }
    
    private List<SaleItem> createSaleItems(String itemsRegister){
        List<SaleItem> saleItems = new ArrayList<>();
        List<String> items = Arrays.asList(itemsRegister.replace("[", "").replace("]", "").split(","));
        EntityFactory saleItemFactory = new SaleItemFactory();
        for(String item : items) {
            saleItems.add((SaleItem) saleItemFactory.create(item));
        }
        return saleItems;
    }
    
}
