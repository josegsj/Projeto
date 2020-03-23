package com.example.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class SaleItem extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long quantity;
	private BigDecimal price;

}
