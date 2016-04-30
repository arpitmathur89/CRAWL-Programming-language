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
    public static ArrayList<String> ifBody = new ArrayList<String>();
    public static Stack<HashMap<String, String>> ActivationStack = new Stack<HashMap<String, String>>();
    public static HashMap<String, String[]> FuncMap = new HashMap<String, String[]>();
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
			Runtime.parseGlobal(code);
			
				
	}catch(PatternSyntaxException e)
		{
			e.printStackTrace();
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
		    		}
		    		else
		    		{	if(globalSymbolTable.containsKey(value))
		    				GlobalSt.push(Integer.parseInt(globalSymbolTable.get(value)));	
		    		else{
		    			System.out.println("Variable not declared");
		    		}
		    		}
		    	}
		    	else if(code[ip].contains("store") && !whileFlag){
		    		String values[]= code[ip].split(" ");
		    		String value = values[values.length-1];
		    		globalSymbolTable.put(value, GlobalSt.pop().toString());
		    			
		    	}
		    	else if(code[ip].contains("add") && !whileFlag){
		    		GlobalSt.push(GlobalSt.pop() + GlobalSt.pop());
		    	}else if(code[ip].contains("sub") && !whileFlag){
		    		GlobalSt.push(GlobalSt.pop() - GlobalSt.pop());
		    	}else if(code[ip].contains("mul")&& !whileFlag){
		    		GlobalSt.push(GlobalSt.pop() * GlobalSt.pop());
		    	}else if(code[ip].contains("div")&& !whileFlag){
		    		

		    		int right = localSt.pop();
		    		int left = localSt.pop();
		    		if(right != 0)
		    		localSt.push(left / right);
		    		else {
		    			System.out.println("Divide by zero error");
		    		   System.exit(0);
		    	}
		    	}
		    		
		    	else if(code[ip].contains("main")){
		    		functionBody.clear();
		    		do{
		    			ip+=1;
		    			functionBody.add(code[ip].toString());
		    		}while(!code[ip].contains("ret"));
		    		String[] fBody = functionBody.toArray(new String[0]);
		    		String[] params = null;
		    		Runtime.parseFunctions(fBody,params);
		    	}
		    	else if(code[ip].contains("decl") && !code[ip].contains("main")) {
		    		functionBody.clear();
		    		String values[]= code[ip].split(" ");
		    		String fname = values[1];		    		
		    		
		    		do{		    			
		    			functionBody.add(code[ip].toString());
		    			ip+=1;
		    		}while(!code[ip].contains("ret"));
		    		String[] fBody = functionBody.toArray(new String[0]);		    	
		    		FuncMap.put(fname, fBody);		    		
		    	}		    			    			     
		   
	}
}

	
public static void parseFunctions(String[] body, String[] params){
	for(int ip=0; ip<body.length; ip++){
		
		if(body[ip].contains("disp")){
			String display[]= body[ip].split(" ");
    		if(display[1].contains("\""))
    		{
    			for(int j= 1; j<display.length ;j++)
    			{
    				System.out.print(display[j].toString().replace("\"","" ) + " ");
    			}
    				System.out.println();
    		}	
    		else{
    		   System.out.println(localSymbolTable.get(display[1]));
    		}
		}
		
		if(body[ip].contains("load")){
    		
    		String values[]= body[ip].split(" ");
    		String value = values[values.length-1];
    		if(value.matches("[0-9]+"))
    		{
    			localSt.push(Integer.parseInt(value));
    		}
    		else
    		{	
    			if(localSymbolTable.containsKey(value))
    				localSt.push(Integer.parseInt(localSymbolTable.get(value)));
    			else if(globalSymbolTable.containsKey(value))
    				localSt.push(Integer.parseInt(globalSymbolTable.get(value)));
    			else
    				System.out.println("Variable not declared!!" + localSymbolTable.get(value));
    		}
    		
    	}
		else if(body[ip].contains("decl") && !body[ip].contains("main")) {
    		
    		String values[]= body[ip].split(" ");
    		String fname = values[1];
    		String temp = "";
    		if(values.length>2){
    			int j=0;
    		System.out.println("Got this from param :" + values[3]);
    			temp = values[3];
    			System.out.println(temp);
    			}	
    	 //System.out.println("ACt stack " + ActivationStack);
    		localSymbolTable.put(temp, ActivationStack.pop().get(temp).toString());		    		
    	}		
    	else if(body[ip].contains("store")){
    		
    		String values[]= body[ip].split(" ");
    		String value = values[values.length-1];
    		localSymbolTable.put(value, localSt.pop().toString());
    
    	}
    	else if(body[ip].contains("add")){
    		localSt.push(localSt.pop() + localSt.pop());
    	}else if(body[ip].contains("sub")){
    		localSt.push(- localSt.pop() + localSt.pop());
    	}else if(body[ip].contains("mul")){
    		localSt.push(localSt.pop() * localSt.pop());
    	}else if(body[ip].contains("div")){
    		
    		int right = localSt.pop();
    		int left = localSt.pop();
    		if(right != 0)
    		localSt.push(left / right);
    		else {
    			System.out.println("Divide by zero error");
    		    System.exit(0);
    	}
	}
    	else if(body[ip].contains("call")){
			
			String values[]= body[ip].split(" ");
    		String fname = values[1];
    		String temp = "";
    
	    	if(values.length>2){
	    			int j=0;
	    		System.out.println("Got this from param :" + values[2]);
	    			temp = values[2];
	    			System.out.println(temp);
	    			}	 
	    	
			String funcallbody[] = FuncMap.get(fname);
			String funcparam[]= funcallbody[0].split(" ");
			if(funcparam.length>2){
    			int j=0;
    			if(temp.matches("[0-9]+")){
    				//localSt.push(Integer.parseInt(temp));
    				localSymbolTable.put(funcparam[3],temp.toString());
    			}
    			else if(!temp.matches("[0-9]+")){
    					if(!localSymbolTable.containsKey(temp)){
    						localSymbolTable = ActivationStack.pop();
    					}
    						localSymbolTable.put(funcparam[3],(localSymbolTable.get(temp)));  					
    					   					  					
    			}
    		}
			
			ActivationStack.push(localSymbolTable);
			localSymbolTable.clear();
			Runtime.parseFunctions(funcallbody,params);			
			
		}
    	else if(body[ip].contains("ret")){  			   			   		
			if(!ActivationStack.isEmpty()){
				localSymbolTable = ActivationStack.pop();
			}
		}
    	else if(body[ip].contains("STACK")){
    		String s[]= body[ip].split(" ");
    		String stackname = s[1];
    		
    		Stack<Integer> LocalSt = new Stack<Integer>();	
    		
    		do{
    			ip +=1;
    			if(body[ip].contains("push")){
    				String stackvalues[]= body[ip].split(" ");
		    		String value = stackvalues[1];
		    		if(value.matches("[0-9]+"))
		    		{
		    			LocalSt.push(Integer.parseInt(value));
		    		  //  System.out.println(LocalSt);
		    		}
    			}
    			
    			if(body[ip].contains("pop")){
		    			LocalSt.pop();
		    		    //System.out.println(LocalSt);
		    		
    			}
    			
    			if(body[ip].contains("peek")){
		    		LocalSt.peek();    
    				System.out.println(LocalSt.peek());
    			}
    			
    			if(body[ip].contains("isEmpty")){
    				 
	    		    System.out.println(LocalSt.isEmpty());
			}	
    		}while(body[ip].contains(stackname));
    	}
    	else if(body[ip].contains("WHILE")){  		
    		whileFlag=true;	
    		do{
    			whileBody.add(body[ip]);
    			ip+=1;
    			
    		}while(!body[ip].contains("EndWhile"));
    		
    		String[] whileLoopBody = whileBody.toArray(new String[0]);
   			Runtime.parseWhileLoop(whileLoopBody);
		
    	}
		
    	else if(body[ip].contains("CHK")){				
    		do{
    			//System.out.println("inside check");
    			ip+=1;
    			ifBody.add(body[ip]);   			    			
    		}while(!body[ip].equals("EndIfElse"));
    		
    		String[] ifelseBody = ifBody.toArray(new String[0]);
    		Runtime.parseIf(ifelseBody);
		}
	}
}

	
public static void parseIf(String body[]){
		
			String[] params = null;
		for(int ip=0; ip<body.length; ip++){
			
			
							
               if(body[ip].contains("load")){
	    		
	    		String values[]= body[ip].split(" ");
	    		String value = values[values.length-1];
	    		if(value.matches("[0-9]+"))
	    		{
	    			localSt.push(Integer.parseInt(value));
	    		}
	    		else if(value.matches("[a-z]+")){
	    			if(localSymbolTable.containsKey(value))
	    				localSt.push(Integer.parseInt(localSymbolTable.get(value)));
	    			else if (globalSymbolTable.containsKey(value))
	    				localSt.push(Integer.parseInt(globalSymbolTable.get(value)));
	    			else
	    				System.out.println("variable not declared!!" + localSt.peek());
	    		}	    			    		
	    	}  	    	                            
	    	
 if(body[ip].equals("LE") ||body[ip].equals("GE") ||body[ip].equals("GEQ") ||body[ip].equals("LEQ")
     	    			||body[ip].equals("EQ") ||body[ip].equals("NEQ")){
	 				Boolean cond = false;
     	    		String op = body[ip].toString();
     	    		switch(op){
     	    		
     	    		case "LE" :    
     	    			if(localSt.pop() >= localSt.pop() ){
     	    				cond=true;}
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
     	    		default :  
     	    			break;	
     	    		}
 				
 				if(cond){
 					functionBody.clear();
 					do{
 						ip+=1;
		    			functionBody.add(body[ip].toString());
 					}while(!body[ip].equals("EndIf"));
 					String[] fBody = functionBody.toArray(new String[0]);
		    		Runtime.parseFunctions(fBody,params);
 				}
 				else if(!cond){
 					do{
 						ip+=1;
 					}while(!body[ip].contains("cond false"));
 					functionBody.clear();
 					do{
 						ip+=1;
		    			functionBody.add(body[ip].toString());
 					}while(!body[ip].equals("EndIfElse"));
 					String[] fBody = functionBody.toArray(new String[0]);
		    		Runtime.parseFunctions(fBody,params);
 				}
			}
		}
     } 
	
	public static void parseWhileLoop(String body[]){
	
		String[] params = null;
		for(int ip =0; ip<body.length;ip++)
		{			
			
  	    	if(body[ip].contains("load")){
	    		
	    		String values[]= body[ip].split(" ");
	    		String value = values[values.length-1];
	    		if(value.matches("[0-9]+"))
	    		{
	    			localSt.push(Integer.parseInt(value));
	    		    
	    		}
	    		else if(value.matches("[a-z]+")){
	    			if(localSymbolTable.containsKey(value))
	    				localSt.push(Integer.parseInt(localSymbolTable.get(value)));
	    			else if (globalSymbolTable.containsKey(value))
	    				localSt.push(Integer.parseInt(globalSymbolTable.get(value)));
	    			else
	    				System.out.println("variable not declared!!");
	    			
	    		}
	    		
	    	}
  	    	
	    	else if(body[ip].contains("store")){
	    		
	    		String values[]= body[ip].split(" ");
	    		String value = values[values.length-1];
	    		if(globalSymbolTable.containsKey(value)&&!localSymbolTable.containsKey(value)){
	    			globalSymbolTable.put(value, localSt.pop().toString());
	    		}
	    		else
	    			localSymbolTable.put(value, localSt.pop().toString());	    		
	    			
	    	}	 
  	    	
	    	else if(body[ip].equals("LE") ||body[ip].contains("GE") ||body[ip].contains("GEQ") ||body[ip].contains("LEQ")
  	    			||body[ip].contains("EQ") ||body[ip].contains("NEQ")){
  	    		
	    		Boolean cond = false;
  	    		String op = body[ip].toString();
  	    		
  	    		switch(op){
  	    		
  	    		case "LE" :    
  	    			if(localSt.pop() >= localSt.pop() ) 	    				
  	    				cond=true;
  	    				
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
  	    		default :  break;	
  	    		
  	    		}
  	    		
  	    		if(cond){
  	    			//System.out.println("trueeee aaya");
  	    			functionBody.clear();
  	    			do{
  	    				ip+=1;
  	    				functionBody.add(body[ip].toString());
 					}while(!body[ip].equals("gotowhile"));
 					String[] fBody = functionBody.toArray(new String[0]); 	
		    		Runtime.parseFunctions(fBody,params); 	  	    		  	    		
  	    		if(body[ip].contains("gotowhile")){ 	    			
  	    			ip = 0;  	    			
  	    		}
  	    	}else if(!cond){
  	    		while(ip<body.length && !body[ip].equals("EndWhile")){
  	    			ip+=1;
  	    		}
  	    	}
 	    		
  	    	}

	     }
	
	}
}