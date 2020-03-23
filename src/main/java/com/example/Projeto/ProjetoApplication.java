package com.example.Projeto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

import org.springframework.boot.SpringApplication;

import com.example.domain.Client;
import com.example.domain.Sale;
import com.example.domain.Salesman;
import com.example.service.MakeFileOutService;
import com.example.service.ProcessFileInService;

public class ProjetoApplication {
	
	public static void main(String[] args)  throws IOException, InterruptedException  {
		 SpringApplication.run(ProjetoApplication.class, args); 
		 WatchService watchService= FileSystems.getDefault().newWatchService();

		 Path inputPath = Paths.get(
				 System.getProperty("user.home")
				 .concat(File.separator)
                 .concat("data")
                 .concat(File.separator)
                 .concat("in"));

		 inputPath.register(
				 watchService,
				 StandardWatchEventKinds.ENTRY_CREATE
				 );
		 
		 iteratorWatchService(inputPath,watchService);
	}
	
	private static void iteratorWatchService(Path inputPath, WatchService watchService) throws InterruptedException, IOException {	
        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                String filename = event.context().toString();
                if (".dat".equalsIgnoreCase(filename.substring(filename.length() - 4))) {
                    Path inputFilePath = inputPath.resolve((Path) event.context());
                    Thread.sleep(1000);
                    ProcessFileInService service=startProcessFile(inputFilePath);
                    makeDoneFile(service.getClients(),service.getSalesmen(),service.getSales(),filename);
                }
            }
            key.reset();
        }
	}
	
	public static ProcessFileInService startProcessFile(Path inputFilePath) throws IOException {
		   List<String> lines = Files.readAllLines(inputFilePath);
           ProcessFileInService service = new ProcessFileInService();
           service.processAll(lines);
           return service;
	}
	
	private static void makeDoneFile(List<Client> listClient,List<Salesman> listSalesman,List<Sale> listSale,String filename) throws IOException {
		MakeFileOutService makeFileOutService=new MakeFileOutService(listClient, listSalesman, listSale);
		String fileResult=makeFileOutService.getReportResult();
        writeDoneFile(filename,fileResult);
	}
	

	private static void writeDoneFile(String filename,String fileResult) throws IOException {
		Path outputPath = Paths.get(System.getProperty("user.home")
	                 .concat(File.separator)
	                 .concat("data")
	                 .concat(File.separator)
	                 .concat("out"));
      	 Path outputFilePath = outputPath.resolve(filename.replace(".dat", ".done.dat"));
      	 try (BufferedWriter writer = Files.newBufferedWriter(outputFilePath)) {
      		 writer.write(fileResult);
         }
      }
}
