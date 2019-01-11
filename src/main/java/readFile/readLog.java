package readFile;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



public class readLog {
	 private BufferedReader reader=null;
	 //private ErrorMessage errorMessage=null;
	 
	 
	 
	 public readLog(String filename) throws Exception {
		super();
		init(filename);
		// TODO Auto-generated constructor stub
	}

		 
		public void init(String filename){
			try {
				FileReader fileReader=new FileReader(filename);
				 reader=new BufferedReader(fileReader);
				
			}
			catch(FileNotFoundException e) {
				System.out.println(e);
			}
		}
		
		 
		 public ArrayList<Line> findError() {
			 String error="No Error";
			String s1=null;
			String s2=null;
			String s3=null;
			String date;
			char c,c1;
			 int x=0;
			 Line line1=new Line();

			 ArrayList<Line> ErrorList=new ArrayList<Line>();
			 Map<String,Integer> errorMapCore=new HashMap<String,Integer>(); 
			 Map<String,Integer> errorMapCustom=new HashMap<String,Integer>(); 

			 
			 try {
				 do {

					// logLine=readLine();
					 String data=reader.readLine();
					 if(data==null)
						  break;
					 int subSindex=data.indexOf("INFO");
					 if(subSindex!=-1) {
						 date=data.substring(subSindex+6,subSindex+21);
						 line1.setDate(date);
					 }
					 
					 int substringIndex1=data.indexOf("Caused");
					 int substringIndex2=data.indexOf("by");
					 
					 if(substringIndex1!=-1 && substringIndex2 != -1) {	
						 
						 int subIn1=data.indexOf("(");
						 int subIn2=data.indexOf(")");
						 if(subIn1 != -1 && subIn2 !=-1)
						 {
							 error=data.substring(subIn1+1, subIn2);
							

						 }
						 int subIn3=error.indexOf("-");
						 if(subIn3!=-1) {
							  c=error.charAt(subIn3-1);
							   x=c-48;
							// if(x!=1)
								// x=2;
						  s1=error.substring(0,subIn3-1);
						  line1.setAppName(s1);
						  s2=error.substring(subIn3+1,error.length());
						  line1.setErrorCode(s2);
						 
						  s3=s1+s2;
						  
						  if(x==1)
						  {
							  if(errorMapCore.containsKey(s3)==false)
							  errorMapCore.put(s3, 1); 
							  else
								  errorMapCore.put(s3, errorMapCore.get(s3)+1);
							  line1.setAppType("Core");
						  }
						  	 
						  else
						  {
							  if(errorMapCustom.containsKey(s3)==false)
								  errorMapCustom.put(s3, 1); 
								  else
									  errorMapCustom.put(s3, errorMapCustom.get(s3)+1);
							  line1.setAppType("Custom");
						  }
						  
							  
						  
						
						 }
						 c1=s2.charAt(5);
						 if(c1>48 && c1<52) {
                              line1.setSeverity("critical");					
                              }
						 else if(c1>51 && c1<55) {
                             line1.setSeverity("error");					
							 }
						 else {
                             line1.setSeverity("warning");					
							 }
						 ErrorList.add(line1);
						 }
					 
				 }while(true);
				 
				// getSeverity(errorMapCore,errorMapCustom,line1);
			 }
			 catch(Exception e) {
				 System.out.println(e +"encountered. Unable to process input file.");
			 }
			 
			 return ErrorList;
			
		 }
		 
		 public void getSeverity(Map<String, Integer> errorMapCore, Map<String, Integer> errorMapCustom,Line line2) {
			 
			 String app,code;
			 int num=0,i=0;
			 String error;
			 
			 Map<String,Integer> errorSeverity=new HashMap<String,Integer>();
			  errorSeverity.put("critical", 0);
			  errorSeverity.put("error", 0);
			  errorSeverity.put("warning", 0);

			 
			 
			 for(Map.Entry m:errorMapCore.entrySet()){  
				 error=(String) m.getKey();
				
		           while(true)
		           {
		        	   num=error.charAt(i);
		        	   if(num>47&&num<58)
		        		   break;
		        	   i++;
		           }
		           
		           app=error.substring(0, i);
		           code=error.substring(i,error.length());
		           System.out.println("An error occurred on the APP : "+app +" with code " +code +" as Core "+m.getValue()+" time");
		          
		           addErrorSeverity(code,errorSeverity,(int)m.getValue());
		          }  
			 
			 
			 i=0;
			 for(Map.Entry m:errorMapCustom.entrySet()){  
				 error=(String) m.getKey();
				
		           while(true)
		           {
		        	   num=error.charAt(i);
		        	   if(num>47&&num<58)
		        		   break;
		        	   i++;
		           }
		           
		           app=error.substring(0, i);
		           code=error.substring(i,error.length());
		           System.out.println("An error occurred on the APP : "+app +" with code " +code +" as Custom "+m.getValue()+" time");
		           addErrorSeverity(code,errorSeverity,(int)m.getValue());
		          } 
	        printSeverity(errorSeverity);
		 }
		 
		 public void addErrorSeverity(String code,Map<String, Integer> errorS,int num)
		 {
			 char s1=code.charAt(5);
			 if(s1>48 && s1<52) {
			 errorS.put("critical", errorS.get("critical")+num);
			 }
			 else if(s1>51 && s1<55) {
				 errorS.put("error", errorS.get("error")+num);
				 }
			 else {
				 errorS.put("warning", errorS.get("warning")+num);
				 }
		 }
		 
		 public void printSeverity(Map<String, Integer> errorS) {
			 for(Map.Entry m:errorS.entrySet()){
				 System.out.println("number of defects with "+m.getKey()+" severity is: "+m.getValue());
			 }
		 }
}

