package com.exemple.factory;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.domain.Salesman;

import static org.junit.Assert.*;

public class SalesmanFactoryTest {
    
    public SalesmanFactoryTest() {
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
    public void testCreateSalesmanByString(){
        Salesman expectedSalesman = new Salesman("1234567891234", "Pedro",new BigDecimal(5000));
        String expectedSalesmanRegister = String.format("001ç%sç%sç%s",
                expectedSalesman.getCpf(),
                expectedSalesman.getName(),
                expectedSalesman.getSalary());
        
        EntityFactory factory = new SalesmanFactory();
        Salesman salesman = (Salesman) factory.create(expectedSalesmanRegister);
        assertEquals(salesman.getCpf(), expectedSalesman.getCpf());
        assertEquals(salesman.getName(), expectedSalesman.getName());
        assertEquals(salesman.getSalary(), expectedSalesman.getSalary());   
    }
}
