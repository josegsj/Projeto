package com.exemple.factory;

import com.example.domain.Entity;

public interface EntityFactory {
    
    abstract Entity create(String register);
    
}
