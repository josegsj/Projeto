package com.example.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper =false)
public class Client  extends Entity  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	private String name;
	private String businessArea; 

}
