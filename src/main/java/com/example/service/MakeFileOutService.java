package com.example.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.domain.Client;
import com.example.domain.Sale;
import com.example.domain.SaleItem;
import com.example.domain.Salesman;


@Service
public class MakeFileOutService {
	
	private List<Client> listClient;
	private List<Salesman> listSalesman;
	private List<Sale> listSale;
	
	public MakeFileOutService(List<Client> listClient,List<Salesman> listSalesman,List<Sale> listSale) {
		this.listClient=listClient;
		this.listSalesman=listSalesman;
		this.listSale=listSale;
	}
	
	
    public String getReportResult(){
        return String.format("%dç%dç%02dç%s", 
        		listClient.size(),
        		listSalesman.size(),
                getMostExpensiveSaleId(),
                getWorstSalesman()
                );
    }
	
    private Long getMostExpensiveSaleId() {
        BigDecimal mostExpensivePrice = BigDecimal.ZERO;
        Long mostExpensiveSaleId = 0L;
        List<Sale> sales = listSale;
        for (Sale sale : sales) {
            BigDecimal purchaseTotal = purchaseTotal(sale);
            if (mostExpensivePrice.compareTo(purchaseTotal) <= 0) {
                mostExpensiveSaleId = sale.getId();
                mostExpensivePrice = purchaseTotal;
            }
        }
        return mostExpensiveSaleId;
    }
    
    private String getWorstSalesman(){
        List<Sale> sales =listSale;
        BigDecimal worstSalePrice = purchaseTotal(sales.get(0));
        Sale worstSale = sales.get(0);
        for(Sale sale : sales) {
            if(worstSalePrice.compareTo(purchaseTotal(sale)) < 0){
            } else {
                worstSalePrice = purchaseTotal(sale);
                worstSale = sale;
            }
        }   
        return worstSale.getSalesmanName();
    }
    
    private BigDecimal purchaseTotal(Sale sale) {
        BigDecimal purchaseTotal = BigDecimal.ZERO;
        for (SaleItem item : sale.getListSaleItem()) {
            purchaseTotal = purchaseTotal.add(item.getPrice());
        }
        return purchaseTotal;
    }

}
