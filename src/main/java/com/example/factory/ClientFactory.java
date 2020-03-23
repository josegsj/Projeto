package com.example.factory;

import com.example.domain.Client;
import com.example.domain.Entity;

public class ClientFactory implements EntityFactory {

    @Override
    public Entity create(String register) {
        String[] splitedRegistries = register.split("ç");
        return new Client(splitedRegistries[1], splitedRegistries[2], splitedRegistries[3]);
    }
    
}
