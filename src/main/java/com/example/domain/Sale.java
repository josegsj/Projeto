package com.example.domain;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper =false)
public class Sale extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String salesmanName;
	private List<SaleItem> listSaleItem;

}
