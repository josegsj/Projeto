package com.exemple.factory;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.domain.SaleItem;

import static org.junit.Assert.*;

public class SaleItemFactoryTest {
    
    public SaleItemFactoryTest() {
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
    public void testCreateSaleItemByString(){
        SaleItem expectedSaleItem = new SaleItem(1L,10L,new BigDecimal(100));
        String expectedSaleItemRegister = String.format("%s-%s-%s",
                expectedSaleItem.getId().toString(),
                expectedSaleItem.getQuantity().toString(),
                expectedSaleItem.getPrice().toString());
        EntityFactory factory = new SaleItemFactory();
        SaleItem saleItem = (SaleItem)factory.create(expectedSaleItemRegister);
        assertEquals(saleItem.getId(), expectedSaleItem.getId());
        assertEquals(saleItem.getQuantity(), expectedSaleItem.getQuantity());
        assertEquals(saleItem.getPrice(), expectedSaleItem.getPrice());
        
    }
}
