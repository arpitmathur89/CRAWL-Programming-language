package trial;

import java.util.Scanner;
import java.util.HashMap;
import java.util.regex.PatternSyntaxException;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

public class Runtime {
	
	 
	
	public static HashMap globalSymbolTable= new HashMap<String, String>();
	public static void main(String[] args) throws FileNotFoundException{
	
		File file= new File("IntermediateCode.txt").getAbsoluteFile();
		
		try{
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				String incode = scanner.nextLine();
				String code[]= incode.trim().split("\\s+");
// syso for verifying correct input sequence
//			for(int i=0; i<code.length; i++ ){      
//				System.out.println(code[i]);
//			}
//			
			Runtime.parseGlobal(code);
				
				
			
			}scanner.close();		
		
	}catch(PatternSyntaxException e)
		{
			e.printStackTrace();
		}
//  syso for printing out the global symbol table	
		for (Object key : globalSymbolTable.keySet()) {
		    System.out.println(key + " " + globalSymbolTable.get(key));   
		}

}
	
	public static void parseGlobal(String code[]){
		if(code.length>0){
			int lookAhead=0;

		    for(int i=lookAhead;i<lookAhead+1 && i<=code.length;i++)
		     {
		    	if(code[i].contentEquals("mov")){
		    		
		    		String values[]= code[i+1].split(",");
		    		globalSymbolTable.put(values[0], values[1]); //key value pair
		    	}
		    	
		    	if(code[i].contentEquals("add")){
		    		String values[]= code[i+1].split(",");
		    	     String a1= (String) globalSymbolTable.get(values[0]);
		    		String a2= (String) globalSymbolTable.get(values[1]);
		    		int a3= Integer.parseInt(a1) + Integer.parseInt(a2);
		    		globalSymbolTable.put(values[0], a3);
		    	}
		    	
//		    	if(code[i].contentEquals("sub")){
//		    		String values[]= code[i+1].split(",");
//		    	     String a1= (String) globalSymbolTable.get(values[0]);
//		    		String a2= (String) globalSymbolTable.get(values[1]);
//		    		int a3= Integer.parseInt(a1) - Integer.parseInt(a2);
//		    		globalSymbolTable.put(values[0], a3);
//		    	}
		    	
//		    	if(code[i].contentEquals("mul")){
//		    		String values[]= code[i+1].split(",");
//		    	     String a1= (String) globalSymbolTable.get(values[0]);
//		    		String a2= (String) globalSymbolTable.get(values[1]);
//		    		int a3= Integer.parseInt(a1) * Integer.parseInt(a2);
//		    		globalSymbolTable.put(values[0], a3);
//		    	}
//		    	
//		    	if(code[i].contentEquals("div")){
//		    		String values[]= code[i+1].split(",");
//		    	     String a1= (String) globalSymbolTable.get(values[0]);
//		    		String a2= (String) globalSymbolTable.get(values[1]);
//		    		int a3= Integer.parseInt(a1) / Integer.parseInt(a2);
//		    		globalSymbolTable.put(values[0], a3);
//		    	}
		     }
			lookAhead++;
		}
		
		
	}
	
}