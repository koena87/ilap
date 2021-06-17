package dogAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class dogs {
	
public static void randomDog() {
	
	   try {
		
	    StringBuilder result = new StringBuilder(); // TODO Auto-generated catch block
	    URL url;

	 
		url = new URL("https://dog.ceo/api/breeds/image/random");


	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    BufferedReader ResponceInfo = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    String line;
	    String TestcaseA = "\n";
	    String TestcaseB = "\n";
	    String TestcaseC = "\n";

	    while((line = ResponceInfo.readLine()) != null) {
	             result.append(line);
	             if(line.contains("\"status\":\"success\""))
	            	 TestcaseA = "Success responce: Pass";
	            	 
	             
	    }
	    
	    System.out.print(TestcaseA + "\n");
	    ResponceInfo.close();
	    
	  
	    } catch (MalformedURLException ex) {
	        Logger.getLogger(dogs.class.getName()).log(Level.SEVERE, null, ex);
	    } catch (ProtocolException ex) {
	        Logger.getLogger(dogs.class.getName()).log(Level.SEVERE, null, ex);
	    } catch (IOException ex) {
	        Logger.getLogger(dogs.class.getName()).log(Level.SEVERE, null, ex);
	    }
	  }


public static void breedDog() {
	
	   try {
		
	    StringBuilder result = new StringBuilder(); // TODO Auto-generated catch block
	    URL url;

	 
		url = new URL("https://dog.ceo/api/breeds/list/all");


	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    BufferedReader ResponceInfo = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    String line;
	    String TestcaseA = "\n";
	    String TestcaseB ="\n";
	    String TestcaseC = "\n";

	    while((line = ResponceInfo.readLine()) != null) {
	             result.append(line);

	             
	             if(line.contains("bulldog"))
	            	 TestcaseB = "Bulldog is found: True";
	             else
	            	 TestcaseB = "Bulldog is found: false";
	             
	    }
	    
	    System.out.print(TestcaseB +"\n"+TestcaseA + "\n");
	    ResponceInfo.close();
	    
	  
	    } catch (MalformedURLException ex) {
	        Logger.getLogger(dogs.class.getName()).log(Level.SEVERE, null, ex);
	    } catch (ProtocolException ex) {
	        Logger.getLogger(dogs.class.getName()).log(Level.SEVERE, null, ex);
	    } catch (IOException ex) {
	        Logger.getLogger(dogs.class.getName()).log(Level.SEVERE, null, ex);
	    }
	  }

public static void breedDogsImages() {
	
	   try {
		
	    StringBuilder result = new StringBuilder(); // TODO Auto-generated catch block
	    URL url;
	    
	    String ouputdOGS = "\n";
	    
	    

	 
		url = new URL("https://dog.ceo/api/breed/bulldog/list");


	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    BufferedReader ResponceInfo = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    String line;
	    String TestcaseC = null;

	    while((line = ResponceInfo.readLine()) != null) {
            result.append(line);
            if(line.contains("\"status\":\"success\"")) 
            	TestcaseC = line.toString();

           

	    }
	    
        TestcaseC = TestcaseC.replace("{\"message\":[\"", "");
        TestcaseC = TestcaseC.replace("\"],\"status\":\"success\"}", "");
	    
	    String [] doglst = TestcaseC.split("\",\"");
	    System.out.print("\nSub breed for bulls are \n");
	    
	    for(String subbreed:doglst) {
	    	
	    	System.out.print(subbreed + "\n");
	    	
	    }
        
	    
	  
	    } catch (MalformedURLException ex) {
	        Logger.getLogger(dogs.class.getName()).log(Level.SEVERE, null, ex);
	    } catch (ProtocolException ex) {
	        Logger.getLogger(dogs.class.getName()).log(Level.SEVERE, null, ex);
	    } catch (IOException ex) {
	        Logger.getLogger(dogs.class.getName()).log(Level.SEVERE, null, ex);
	    }
	  }





}
