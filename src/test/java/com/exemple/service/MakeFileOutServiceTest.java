package com.exemple.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.service.MakeFileOutService;
import com.example.service.ProcessFileInService;


public class MakeFileOutServiceTest {

	 private static List<String> lines;
	 private static ProcessFileInService service;
	 private static MakeFileOutService makeFileOutService;
	 
	 @BeforeClass
	 public static void setUpClass() {
		 service = new ProcessFileInService();
		 
	     lines = new ArrayList<>();
	     lines.add("001ç1234567891234çPedroç50000");
	     lines.add("001ç3245678865434çPauloç40000.99");
	     lines.add("002ç2345675434544345çJose da SilvaçRural");
	     lines.add("002ç2345675433444345çEduardo PereiraçRural");
	     lines.add("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro");
	     lines.add("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo");
	  }
	 
	 @Before
	 public void setUp() {
		 service.processAll(lines);
		 makeFileOutService=new MakeFileOutService(service.getClients(), service.getSalesmen(), service.getSales());
	    }
	 
	 @Test
	    public void testGetReportResult(){
	        assertEquals(makeFileOutService.getReportResult(),"2ç2ç10çPaulo");
	    }
}
