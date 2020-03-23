package com.exemple.factory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.domain.Client;
import com.example.factory.ClientFactory;
import com.example.factory.EntityFactory;

import static org.junit.Assert.*;

public class ClientFactoryTest {
    
    public ClientFactoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCreateClientByString(){
        Client expectedClient = new Client("2345675434544345","Jose da Silva","Rural");
        String expectedClientRegister = String.format("002ç%sç%sç%s", expectedClient.getCnpj(), expectedClient.getName(), expectedClient.getBusinessArea());
        
        EntityFactory factory = new ClientFactory();
        Client client = (Client) factory.create(expectedClientRegister);
        assertEquals(client.getCnpj(), expectedClient.getCnpj());
        assertEquals(client.getName(), expectedClient.getName());
        assertEquals(client.getBusinessArea(), expectedClient.getBusinessArea());
    }
}
