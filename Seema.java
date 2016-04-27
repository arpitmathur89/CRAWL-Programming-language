import java.util.Scanner;
import java.util.*;
import java.util.HashMap;
import java.util.regex.PatternSyntaxException;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

public class Runtime {
  
	public static HashMap<String, String> globalSymbolTable= new HashMap<String, String>();
    public static Stack<Integer> GlobalSt = new Stack<Integer>();	
    public static Boolean whileFlag = false;
    public static String Body = "";
    public static String Leftvar = "";
    public static String Relop = "";
    public static int Rightvar = 0;
	public static void main(String[] args) throws FileNotFoundException{
		
		File file= new File("IntermediateCode.txt").getAbsoluteFile();
		
		try{
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				String incode = scanner.nextLine();
				String code[]= incode.trim().split("\\n+");
// syso for verifying correct input sequence
			for(int i=0; i<code.length; i++ ){      
				System.out.println(code[i]);
			}
//			
			Runtime.parseGlobal(code);	
			}scanner.close();		
		
	}catch(PatternSyntaxException e)
		{
			e.printStackTrace();
		}
//  syso for printing out the global symbol table	
		for (Object key : globalSymbolTable.keySet()) {
		   // System.out.println(key + " " + globalSymbolTable.get(key));   
		}
}


	
	
	public static void parseGlobal(String code[]){
		if(code.length>0){
			int lookAhead=0;
         
		    for(int i=lookAhead;i<lookAhead+1 && i<=code.length;i++)
		     {
		    	if(code[i].contains("load")){
		    		
		    		String values[]= code[i].split(" ");
		    		String value = values[values.length-1];
		    		if(value.matches("[0-9]+"))
		    		{
		    			GlobalSt.push(Integer.parseInt(value));
		    		    System.out.println(GlobalSt);
		    		}
		    		else
		    		{
		    			GlobalSt.push(Integer.parseInt(globalSymbolTable.get(value)));
		    			
		    		}
		    		//globalSymbolTable.put(values[0], values[1]); //key value pair
		    	}
		    	else if(code[i].contains("store")){
		    		
		    		String values[]= code[i].split(" ");
		    		String value = values[values.length-1];
		    		globalSymbolTable.put(value, GlobalSt.pop().toString());
		    			 //key value pair
		    	}
		    	else if(code[i].contains("add")){
		    		GlobalSt.push(GlobalSt.pop() + GlobalSt.pop());
		    	}else if(code[i].contains("sub")){
		    		GlobalSt.push(GlobalSt.pop() - GlobalSt.pop());
		    	}else if(code[i].contains("mul")){
		    		GlobalSt.push(GlobalSt.pop() * GlobalSt.pop());
		    	}else if(code[i].contains("div")){
		    		GlobalSt.push(GlobalSt.pop() / GlobalSt.pop());
		    	}
		    	else if(code[i].contains("WHILE")){
		    		System.out.println("Inside while");
		    		String values[]= code[i].split(" ");
		    		System.out.println("val 1 =" + values[1] + "val2 = " + values[2] + "val2 =" + values[3]);
		    		Body = "";
		    		Leftvar = values[1]; 
		    		Relop = values[2];
		    		Rightvar = Integer.parseInt(values[3]);
		    		whileFlag=true;
		    	}
		    	else if(!code[i].equals("EndWhile") && whileFlag == true){
		    		//System.out.println("Body k andar");
		    		Body += code[i] + "\n";
		    	}
		    	else if(code[i].equals("EndWhile")){
		    		System.out.println("Encountered endwhile");
					Runtime.parseWhileLoop(code);
		    	System.out.println(GlobalSt);
		    	whileFlag = false;
		    	}
		     }
	}
	
}

	public static void parseWhileLoop(String code[]){
		String whileBodyArray[]=Body.split("\n");
		int FirstValue= Integer.parseInt(globalSymbolTable.get(Leftvar));
		int SecondValue=Rightvar;
		System.out.println("Firstvalue is :" +FirstValue);
		System.out.println("Second Value is :" +SecondValue);
		switch(Relop){
		case "<" :
			System.out.println("gfgv");
			while(FirstValue < SecondValue)
			{
				
				for(int i=0;i<whileBodyArray.length;i++){
					String arrayOfTokens[]=whileBodyArray[i].split(" ");
					Runtime.parseGlobal(arrayOfTokens);
				}
				FirstValue=Integer.parseInt(globalSymbolTable.get(Leftvar));
				System.out.println(FirstValue);
			}
			break;
				
//	case "!=" :
//		while(FirstValue == Rightvar)
//		{
//			for(int i=0;i<whileBodyArray.length;i++){
//				String arrayOfTokens[]=whileBodyArray[i].split(" ");
//				Runtime.parseGlobal(arrayOfTokens);
//			}
//		}
//		break;
		}	
	}
		}
		
	
