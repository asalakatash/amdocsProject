package com.example.amdocs;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;

import com.example.amdocs.domain.AppRepository;
import com.example.amdocs.domain.Application;
import com.example.amdocs.domain.FileLogRepository;
import com.example.amdocs.domain.fileLog;


import readFile.Line;
import readFile.readLog;


@SpringBootApplication
public class AmdocsApplication {
	  @Autowired 
      private AppRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(AmdocsApplication.class, args);
		//2222
		
	}


@Bean
    CommandLineRunner runner(){
        return args -> {
    // Place your code here
   		 ArrayList<Line> errorList=new ArrayList<Line>();

        	 try {
        		 String filename="C:\\Users\\Rental-Media\\Desktop\\amdocs\\src\\main\\java\\com\\example\\amdocs\\file1.txt";
        		 readLog logReader=new readLog(filename);
        		// logReader
        		 errorList=logReader.findError();
        	 }
        	         
        	       catch (Exception ex) {  
        	            System.out.println(ex.getMessage());  
        	        }  
        	    
        	
        	 for(Line b:errorList) {
        		 
     	   Application app=new Application(b.getAppName(),b.getAppType()); 
     	   repository.save(app);
        	 }
     	   

			
  };
}

}

