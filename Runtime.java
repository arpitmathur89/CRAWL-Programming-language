package trial;

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
    public static ArrayList<String> whileBody = new ArrayList<String>();
    public static ArrayList<String> functionBody = new ArrayList<String>();
    public static String Leftvar = "";
    public static String Relop = "";
    public static int Rightvar = 0;
	public static void main(String[] args) throws FileNotFoundException{
		
		File file= new File("IntermediateCode.txt").getAbsoluteFile();
		List<String> codeArray = new ArrayList<String>();
		try{
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				String incode = scanner.nextLine();
			    codeArray.add(incode);
			}scanner.close();	
			String[] code = codeArray.toArray(new String[0]);
//			  for (String s : code) {
//			      System.out.println(s);
//			    }
			Runtime.parseGlobal(code);
			
				
	}catch(PatternSyntaxException e)
		{
			e.printStackTrace();
		}
//  printing out the global symbol table	
		for (Object key : globalSymbolTable.keySet()) {
		    System.out.println(key + " " + globalSymbolTable.get(key));   
		}
	  
}

public static void parseGlobal(String code[]){
	
       
		    for(int ip =0; ip<code.length;ip++)
		     {
		    	
       	    	if(code[ip].contains("load") && !whileFlag){
		    		
		    		String values[]= code[ip].split(" ");
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
		    	else if(code[ip].contains("store") && !whileFlag){
		    		
		    		String values[]= code[ip].split(" ");
		    		String value = values[values.length-1];
		    		globalSymbolTable.put(value, GlobalSt.pop().toString());
		    			 //key value pair
		    	}
		    	else if(code[ip].contains("add") && !whileFlag){
		    		GlobalSt.push(GlobalSt.pop() + GlobalSt.pop());
		    	}else if(code[ip].contains("sub") && !whileFlag){
		    		GlobalSt.push(GlobalSt.pop() - GlobalSt.pop());
		    	}else if(code[ip].contains("mul")&& !whileFlag){
		    		GlobalSt.push(GlobalSt.pop() * GlobalSt.pop());
		    	}else if(code[ip].contains("div")&& !whileFlag){
		    		GlobalSt.push(GlobalSt.pop() / GlobalSt.pop());
		    	}
       	    	
       	    	
		    	if(code[ip].contains("WHILE")){
		    		
		    		String values[]= code[ip].split(" ");
		    		System.out.println("val 1 =" + values[1] + "operator => " + values[2] + "val2 =" + values[3]);
		    		Leftvar = values[1]; 
		    		Relop = values[2];
		    		Rightvar = Integer.parseInt(values[3]);
		    		whileFlag=true;	
		    		
		    		do{
		    			ip+=1;
		    			whileBody.add(code[ip]);
		    		}while(!code[ip].contains("EndWhile"));
		    		
		    		String[] whileLoopBody = whileBody.toArray(new String[0]);
//		    		while(Integer.parseInt(globalSymbolTable.get(Leftvar)) != Rightvar)
//		    			Runtime.parseWhileLoop(whileLoopBody, Leftvar, Relop, Rightvar);
	    		
		    	}
       	    	
		    	if(code[ip].contains("decl")) {
		    		
		    		String values[]= code[ip].split(" ");
		    		String fname = values[1];
		    		String argtype=values[2];
		    		String arg =values[3];
		    		
		    		do{
		    			ip+=1;
		    			functionBody.add(code[ip]);
		    		}while(!code[ip].contains("ret"));
		    		
		    		String[] fBody = functionBody.toArray(new String[0]);
		    		//Runtime.parseFunctions(fBody);
		    		
		    	}
		    	if(code[ip].contains("STACK")){
		    		String s[]= code[ip].split(" ");
		    		String stackname = s[1];
		    		
		    		Stack<Integer> LocalSt = new Stack<Integer>();	
		    		
		    		do{
		    			ip +=1;
		    			if(code[ip].contains("push")){
		    				String stackvalues[]= code[ip].split(" ");
				    		String value = stackvalues[1];
				    		if(value.matches("[0-9]+"))
				    		{
				    			LocalSt.push(Integer.parseInt(value));
				    		    System.out.println(LocalSt);
				    		}
		    			}
		    			
		    			if(code[ip].contains("pop")){
				    			LocalSt.pop();
				    		    //System.out.println(LocalSt);
				    		
		    			}
		    			
		    			if(code[ip].contains("peek")){
				    		    System.out.println(LocalSt);
		    			}
		    			
		    			if(code[ip].contains("isEmpty")){
		    				 
			    		     if(LocalSt.empty())
			    		     {
			    		    	 System.out.println("empty");
			    		     }
			    		     
			    		     else 
			    		    	 System.out.println("not empty");
	    			}	
		    		}while(code[ip].contains(stackname));
		    		
		    	
		     }
		   
	}
}

	
public static void parseFunctions(String[] body){
	
	for(int ip=0; ip<body.length; ip++){
		
		if(body[ip].contains("disp")){
			String display[]= body[ip].split(" ");
			
    		if(display[1].contains("\" "))
    		{
    			for(int j= 1; j<display.length;j++)
    				System.out.println(display[j]);
    		}	
    		else{
    		    System.out.println(globalSymbolTable.get(display[1]));
    		}
		}
			
		}
	}


	public static void parseWhileLoop(String body[], String l, String o, int r){
		
		Stack<Integer> WhileSt = new Stack<Integer>();
		//HashMap<String, String> whileSymbolTable= new HashMap<String, String>();
		
		for(int ip =0; ip<body.length;ip++)
	     {
	    	
  	    	if(body[ip].contains("load") && whileFlag){
	    		
	    		String values[]= body[ip].split(" ");
	    		String value = values[values.length-1];
	    		if(value.matches("[0-9]+"))
	    		{
	    			WhileSt.push(Integer.parseInt(value));
	    		    //System.out.println(WhileSt);
	    		}
	    		else
	    		{
                        WhileSt.push(Integer.parseInt(globalSymbolTable.get(value)));
	    			
	    		}
	    		
	    	}
	    	else if(body[ip].contains("store") && whileFlag){
	    		
	    		String values[]= body[ip].split(" ");
	    		String value = values[values.length-1];
	    		globalSymbolTable.put(value, WhileSt.pop().toString());
	    			 //key value pair
	    	}
	    	else if(body[ip].contains("add") && whileFlag){
	    		WhileSt.push(WhileSt.pop() + WhileSt.pop());
	    	}else if(body[ip].contains("sub") && whileFlag){
	    		WhileSt.push(WhileSt.pop() - WhileSt.pop());
	    	}else if(body[ip].contains("mul")&& whileFlag){
	    		WhileSt.push(WhileSt.pop() * WhileSt.pop());
	    	}else if(body[ip].contains("div")&& whileFlag){
	    		WhileSt.push(WhileSt.pop() / WhileSt.pop());
	    	}
		
	     }
	
	}
}

		