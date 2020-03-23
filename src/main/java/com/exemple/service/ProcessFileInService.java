package com.exemple.service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.domain.Client;
import com.example.domain.Sale;
import com.example.domain.Salesman;
import com.exemple.factory.ClientFactory;
import com.exemple.factory.EntityFactory;
import com.exemple.factory.SaleFactory;
import com.exemple.factory.SalesmanFactory;

@Service
public class ProcessFileInService {
	
	 private List<com.example.domain.Entity> registers;

	 public ProcessFileInService() {
	     registers = new ArrayList<>();
	 }
	 
    public void processAll(List<String> lines){
        lines.stream().forEach(line -> process(line));
    }
    
    private void process(String line) {
        EntityFactory factory = getCorrespondentFactory(line);
        registers.add(factory.create(line));
    }
    
    private EntityFactory getCorrespondentFactory(String line) {
        String type = line.substring(0, 3);
        EntityFactory factory;
        	if(type.equals("001")) {
        		factory = new SalesmanFactory();
        	}else if(type.equals("002")){
                factory = new ClientFactory();
    		}else if(type.equals( "003")){
                factory = new SaleFactory();
    		}else {
    			throw new InvalidParameterException("Registro inválido");
            }
        return factory;
    }

    public List<Client> getClients() {
        return registers.stream()
                .filter(reg -> reg instanceof Client)
                .map(reg -> (Client) reg)
                .collect(Collectors.toList());
    }
    
    public List<Salesman> getSalesmen() {
        return registers.stream()
                .filter(reg -> reg instanceof Salesman)
                .map(reg -> (Salesman) reg)
                .collect(Collectors.toList());
    }
    
    public List<Sale> getSales() {
        return registers.stream()
                .filter(reg -> reg instanceof Sale)
                .map(reg -> (Sale) reg)
                .collect(Collectors.toList());
    }

}
