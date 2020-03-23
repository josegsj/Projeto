package com.exemple.factory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.domain.Sale;
import com.example.domain.SaleItem;

import static org.junit.Assert.*;

public class SaleFactoryTest {

    public SaleFactoryTest() {
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
    public void testCreateSaleByRegister() {
        List<SaleItem> listSaleItem=new ArrayList<>();
        listSaleItem.add(new SaleItem(1L, 10L, new BigDecimal(100)));
        listSaleItem.add(new SaleItem(2L, 30L, new BigDecimal(2.50)));
        listSaleItem.add(new SaleItem(3L, 40L, new BigDecimal(3.10)));
        Sale expectedSale = new Sale(10L, "Pedro",listSaleItem);
        String expectedSaleRegister = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro";
        EntityFactory factory = new SaleFactory();
        Sale sale = (Sale) factory.create(expectedSaleRegister);
        assertEquals(sale.getId(), expectedSale.getId());
        assertEquals(sale.getSalesmanName(), expectedSale.getSalesmanName());

    }
}
