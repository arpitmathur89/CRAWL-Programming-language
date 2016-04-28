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
    public static HashMap<String, String> localSymbolTable= new HashMap<String, String>();
    public static Stack<Integer> localSt = new Stack<Integer>();	
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
		    		
		    		int left = GlobalSt.pop();
		    		int right = GlobalSt.pop();
		    		if(right != 0)
		    		GlobalSt.push(left / right);
		    		else {
		    			System.out.println("Divide by zero error");
		    		   System.exit(0);
		    	}
		    	}
		    	else if(code[ip].contains("decl")) {
		    		
		    		String values[]= code[ip].split(" ");
		    		String fname = values[1];
		    		String argtype=values[2];
		    		String arg =values[3];
		    		
		    		do{
		    			ip+=1;
		    			functionBody.add(code[ip].toString());
		    		}while(!code[ip].contains("ret"));
		    		
		    		String[] fBody = functionBody.toArray(new String[0]);
		    		for (String s : fBody) {
					      System.out.println(s);
					    }
		    		Runtime.parseFunctions(fBody);
		    		
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
			
    		if(display[1].matches(" [a-z]+ "))
    		{
    			for(int j= 1; j<display.length;j++)
    				System.out.println(display[j]);
    		}	
    		else{
    		   // System.out.println(localSymbolTable.get(display[1]));
    		}
		}
		
		if(body[ip].contains("load") && !whileFlag){
    		
    		String values[]= body[ip].split(" ");
    		String value = values[values.length-1];
    		if(value.matches("[0-9]+"))
    		{
    			localSt.push(Integer.parseInt(value));
    		    System.out.println(localSt);
    		}
    		else
    		{
    			localSt.push(Integer.parseInt(localSymbolTable.get(value)));
    			
    		}
    		
    	}
    	else if(body[ip].contains("store") && !whileFlag){
    		
    		String values[]= body[ip].split(" ");
    		String value = values[values.length-1];
    		localSymbolTable.put(value, localSt.pop().toString());
    			 //key value pair
    	}
    	else if(body[ip].contains("add") && !whileFlag){
    		localSt.push(localSt.pop() + localSt.pop());
    	}else if(body[ip].contains("sub") && !whileFlag){
    		localSt.push(localSt.pop() - localSt.pop());
    	}else if(body[ip].contains("mul")&& !whileFlag){
    		localSt.push(localSt.pop() * localSt.pop());
    	}else if(body[ip].contains("div")&& !whileFlag){
    		
    		int left = localSt.pop();
    		int right = localSt.pop();
    		if(right != 0)
    		localSt.push(left / right);
    		else {
    			System.out.println("Divide by zero error");
    		    System.exit(0);
    	}
	} 	
		if(body[ip].contains("WHILE")){  		
    		whileFlag=true;	
    		do{
    			ip+=1;
    			whileBody.add(body[ip]);
    		}while(!body[ip].contains("EndWhile"));
    		
    		String[] whileLoopBody = whileBody.toArray(new String[0]);
    		 for (String s : whileLoopBody) {
			      System.out.println(s);
			    }
   			Runtime.parseWhileLoop(whileLoopBody);
		
    	}
		}
	}


	public static void parseWhileLoop(String body[]){
		
		int count=0;
		
		for(int ip =0; ip<body.length;ip++)
	     {
			Boolean cond = false;
	    	
  	    	if(body[ip].contains("load")){
	    		
	    		String values[]= body[ip].split(" ");
	    		String value = values[values.length-1];
	    		if(value.matches("[0-9]+"))
	    		{
	    			localSt.push(Integer.parseInt(value));
	    		    //System.out.println(localSt);
	    		}
	    		else if(value.matches("[a-z]+")){
	    			localSt.push(Integer.parseInt(localSymbolTable.get(value)));
	    			
	    		}
	    		else
	    		{
                        localSt.push(Integer.parseInt(globalSymbolTable.get(value)));
	    			
	    		}
	    		
	    	}
	    	else if(body[ip].contains("store")){
	    		
	    		String values[]= body[ip].split(" ");
	    		String value = values[values.length-1];
	    		localSymbolTable.put(value, localSt.pop().toString());
	    			 //key value pair
	    	}
	    	else if(body[ip].contains("add")){
	    		localSt.push(localSt.pop() + localSt.pop());
	    	}else if(body[ip].contains("sub")){
	    		localSt.push(localSt.pop() - localSt.pop());
	    	}else if(body[ip].contains("mul")){
	    		localSt.push(localSt.pop() * localSt.pop());
	    	}else if(body[ip].contains("div")){
	    		
	    		int left = localSt.pop();
	    		int right = localSt.pop();
	    		if(right != 0)
	    		localSt.push(left / right);
	    		else {
	    			System.out.println("Divide by zero error");
	    		    System.exit(0);
	    	
	    	}
	     }
  	    	
  	    	if(body[ip].contains("LE") ||body[ip].contains("GE") ||body[ip].contains("GEQ") ||body[ip].contains("LEQ")
  	    			||body[ip].contains("EQ") ||body[ip].contains("NEQ")){
  	    		
  	    		String op = body[ip].toString();
  	    		
  	    		switch(op){
  	    		
  	    		case "LE" :    
  	    			if(localSt.pop() >= localSt.pop())
  	    				count++;
  	    				cond=true;
  	    				System.out.println(count);
  	    				break;
  	    		case "LEQ" :	   
  	    			if(localSt.pop() > localSt.pop())
  	    				cond=true;
  	    			break;
  	    		case "GE" :          
  	    			if(localSt.pop() <= localSt.pop())
  	    				cond=true;
  	    			break;
  	    		case "GEQ" :   
  	    			if(localSt.pop() < localSt.pop())
  	    				cond=true;
  	    			break;
  	    		case "EQ" :         
  	    			if(localSt.pop() == localSt.pop())
  	    				cond=true;
  	    			break;
  	    		case "NEQ" :      
  	    			if(localSt.pop() != localSt.pop())
  	    				cond=true;
  	    			break;
  	    		default : System.out.println("Invalid operator"); break;	
  	    		
  	    		}
  	    		
  	    		if(cond){
  	    			do{
  	    				ip+=1;
  	    				if(body[ip].contains("load")){
  	    		    		
  	    		    		String values[]= body[ip].split(" ");
  	    		    		String value = values[values.length-1];
  	    		    		if(value.matches("[0-9]+"))
  	    		    		{
  	    		    			localSt.push(Integer.parseInt(value));
  	    		    		    //System.out.println(localSt);
  	    		    		}
  	    		    		else{
  	    		    			localSt.push(Integer.parseInt(localSymbolTable.get(value)));
  	    		    			
  	    		    		}
  	    		    		
  	    		    	}
  	    		    	else if(body[ip].contains("store")){
  	    		    		
  	    		    		String values[]= body[ip].split(" ");
  	    		    		String value = values[values.length-1];
  	    		    		localSymbolTable.put(value, localSt.pop().toString());
  	    		    			 //key value pair
  	    		    	}
  	    		    	else if(body[ip].contains("add")){
  	    		    		localSt.push(localSt.pop() + localSt.pop());
  	    		    	}else if(body[ip].contains("sub")){
  	    		    		localSt.push(localSt.pop() - localSt.pop());
  	    		    	}else if(body[ip].contains("mul")){
  	    		    		localSt.push(localSt.pop() * localSt.pop());
  	    		    	}else if(body[ip].contains("div")){
  	    		    		
  	    		    		int left = localSt.pop();
  	    		    		int right = localSt.pop();
  	    		    		if(right != 0)
  	    		    		localSt.push(left / right);
  	    		    		else {
  	    		    			System.out.println("Divide by zero error");
  	    		    		    System.exit(0);
  	    		    	}
  	    		    	}
  	    			}while(!body[ip].contains("gotowhile"));
  	  	    		
  	  	    		
  	  	    	}
  	    		
  	    		if(body[ip].contains("gotowhile")){
  	    			
  	    			ip = 0;
  	    			
  	    		}
  	    		
  	    	}

	     }
	
	}
}

		