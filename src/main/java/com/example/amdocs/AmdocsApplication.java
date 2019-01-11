package com.example.amdocs;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;

import com.example.amdocs.domain.AppRepository;
import com.example.amdocs.domain.Application;
import com.example.amdocs.domain.DeffectInstanceRepository;
import com.example.amdocs.domain.DeffectRepository;
import com.example.amdocs.domain.Deffect_instance;
import com.example.amdocs.domain.Deffects;
import com.example.amdocs.domain.FileLogRepository;
import com.example.amdocs.domain.SolutionRepository;
import com.example.amdocs.domain.fileLog;


import readFile.Line;
import readFile.readLog;


@SpringBootApplication
public class AmdocsApplication {
	  @Autowired 
      private AppRepository repository;
	  
	  @Autowired 
      private DeffectRepository drepository;
	  @Autowired 
      private FileLogRepository frepository;
	  @Autowired 
      private SolutionRepository srepository;
	  @Autowired 
      private DeffectInstanceRepository direpository;
	  
	public static void main(String[] args) {
		SpringApplication.run(AmdocsApplication.class, args);
		//2222
		
	}


@Bean
    CommandLineRunner runner(){
        return args -> {
    // Place your code here
        	repository.deleteAll();
        	drepository.deleteAll();
        	frepository.deleteAll();
        	srepository.deleteAll();
        	
   		 ArrayList<Line> errorList=new ArrayList<Line>();
   		  Set<Application> AppSet = new HashSet<Application>(); 
          Set<Deffects> DeffectsSet = new HashSet<Deffects>(); 
         
        	 try {
        		 String filename="C:\\Users\\Rental-Media\\Desktop\\amdocs\\src\\main\\java\\com\\example\\amdocs\\file1.txt";
        		 readLog logReader=new readLog(filename);
        		 errorList=logReader.findError();
        		 fileLog file=new fileLog(filename,"sep 13");
           	      frepository.save(file);
           	   
              

        	      for(Line b:errorList) {
        		 
     	           Application app=new Application(b.getAppName(),b.getAppType()); 
     	           AppSet.add(app);
     	           repository.save(app);
        	 
             	   Deffects deffect=new Deffects(b.getErrorCode(),b.getSeverity(),"Solution");
             	   DeffectsSet.add(deffect);
            	   drepository.save(deffect);
            	   
        	       Deffect_instance deffectInstance=new Deffect_instance();
        	       deffectInstance.setApp(app);
        	       deffectInstance.setDeff(deffect);
        	       deffectInstance.setFile(file);
        	       direpository.save(deffectInstance);
        	      }
        	 

         }
        
        	 catch (Exception ex) {  
 	            System.out.println(ex.getMessage());  
 	        }  
		
  };
}

}

