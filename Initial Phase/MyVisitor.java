import java.io.*;

public class MyVisitor extends MyGrammarBaseVisitor<Integer>{
	
	FileWriter file;
	BufferedWriter output;
	
	
	@Override
	public Integer visitStart(MyGrammarParser.StartContext ctx) {
	    visitChildren(ctx);
		return 0;
	}
	
	@Override
	public Integer visitBegin(MyGrammarParser.BeginContext ctx) {
		
	    System.out.println("BEGIN");
		visitChildren(ctx);
		try{
		file = new FileWriter("intermediatecode.txt",true);
		output = new BufferedWriter(file);
		output.write("BEGIN\n");
		output.close();
	}
	catch(IOException e){
		e.printStackTrace();
	}
		return 0;				
	}
	
	
	@Override
	public Integer visitEnd(MyGrammarParser.EndContext ctx) {
		
		try{
			file = new FileWriter("intermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write("END\n");
			output.close();
			System.out.println("END");
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		
		return 0;				
	}
	
	@Override
	public Integer visitProgram(MyGrammarParser.ProgramContext ctx) {
		
		visitChildren(ctx);
		return 0;
	}
	
	@Override
	public Integer visitVariable(MyGrammarParser.VariableContext ctx) {
		
		if((ctx.getChildCount()== 2)){
			String var = ctx.id.getText();
			int num = 0;
			try{
				file = new FileWriter("intermediatecode.txt",true);
				output = new BufferedWriter(file);
				output.write("load"+" "+num);
				output.write("\n");
				output.write("store"+" "+var);
				output.write("\n");
				System.out.println("load"+" "+num);	
				System.out.println("store"+" "+var);
				output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		}else{
			if(ctx.getChildCount()== 4 && (ctx.E.getText().matches("[0-9]+")|| ctx.E.getText().equals("true")|| ctx.E.getText().equals("false"))){
				int num = visit(ctx.E);
				try{
					file = new FileWriter("intermediatecode.txt",true);
					output = new BufferedWriter(file);
					output.write("load "+num);
					output.write("\n");
					System.out.println("load "+num);
					output.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			}else{
			visit(ctx.E);	
			}
			try{
				file = new FileWriter("intermediatecode.txt",true);
				output = new BufferedWriter(file);
				String var = ctx.id.getText();
				output.write("store "+" "+var);
				output.write("\n");
				System.out.println("store "+var);
				output.close();
			}catch(IOException e){
				e.printStackTrace();
			}		
			}
		
		return 0;
	}
	
	public Integer visitNUM(MyGrammarParser.NUMContext ctx) {
		
		return Integer.parseInt(ctx.getText());
	}
	
	@Override
	public Integer visitBOOL(MyGrammarParser.BOOLContext ctx) {
		
		int num = 0;
		if(ctx.getText().equals("true"))
			num = 1;
		else{
			num = 0;
		}
		return num;
	}
	
	@Override
	public Integer visitMUL(MyGrammarParser.MULContext ctx) {
			
			if(ctx.getChild(1).getText().equals("*")){				
				 
					 if((!ctx.L.getText().matches("[0-9]+")) && (!ctx.R.getText().matches("[0-9]+"))){				 
						 visit(ctx.L);
						 visit(ctx.R);
						 try{
								file = new FileWriter("intermediatecode.txt",true);
								output = new BufferedWriter(file);
								output.write("mul");
								output.write("\n");
								System.out.println("mul");
								output.close();
						 }catch(IOException e){
								e.printStackTrace();
							}
				}
				else if((!ctx.L.getText().matches("[0-9]+")) && (ctx.R.getText().matches("[0-9]+"))){
					visit(ctx.L);
					int num = visit(ctx.R);
					try{
						file = new FileWriter("intermediatecode.txt",true);
						output = new BufferedWriter(file);
						output.write("load "+num);
						output.write("\n");
						output.write("mul");
						output.write("\n");
						System.out.println("load "+num);
						System.out.println("mul");
						output.close();
					}catch(IOException e){
						e.printStackTrace();
					}
				}
				else if ((!ctx.R.getText().matches("[0-9]+")) && (ctx.L.getText().matches("[0-9]+"))){
					visit(ctx.R);
					int num = visit(ctx.L);
					try{
						file = new FileWriter("intermediatecode.txt",true);
						output = new BufferedWriter(file);
						output.write("load "+num);
						output.write("\n");
						output.write("mul");
						output.write("\n");
						System.out.println("load "+num);
						System.out.println("mul");
						output.close();
					}catch(IOException e){
						e.printStackTrace();
					}
				}else{			
					int num1 = visit(ctx.L);
					int num2 = visit(ctx.R);
					try{
						file = new FileWriter("intermediatecode.txt",true);
						output = new BufferedWriter(file);
						output.write("load "+num1);
						output.write("\n");
						output.write("load "+num2);
						output.write("\n");
						output.write("mul");
						output.write("\n");
						System.out.println("load "+num1);
						System.out.println("load "+num2);
						System.out.println("mul");
						output.close();
					}catch(IOException e){
					e.printStackTrace();
				}
				}
			}
			else if(ctx.getChild(1).getText().equals("/")){
				
				if((!ctx.L.getText().matches("[0-9]+")) && (!ctx.R.getText().matches("[0-9]+"))){				 
					 visit(ctx.L);
					 visit(ctx.R);
					 try{
							file = new FileWriter("intermediatecode.txt",true);
							output = new BufferedWriter(file);
							output.write("div");
							output.write("\n");
							System.out.println("div");
							output.close();
					 }catch(IOException e){
							e.printStackTrace();
						}
			}
			else if((!ctx.L.getText().matches("[0-9]+")) && (ctx.R.getText().matches("[0-9]+"))){
				visit(ctx.L);
				int num = visit(ctx.R);
				try{
					file = new FileWriter("intermediatecode.txt",true);
					output = new BufferedWriter(file);
					output.write("load "+num);
					output.write("\n");
					output.write("div");
					output.write("\n");
					System.out.println("load "+num);
					System.out.println("div");
					output.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			else if ((!ctx.R.getText().matches("[0-9]+")) && (ctx.L.getText().matches("[0-9]+"))){
				visit(ctx.R);
				int num = visit(ctx.L);
				try{
					file = new FileWriter("intermediatecode.txt",true);
					output = new BufferedWriter(file);
					output.write("load "+num);
					output.write("\n");
					output.write("div");
					output.write("\n");
					System.out.println("load "+num);
					System.out.println("div");
					output.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}else{			
				int num1 = visit(ctx.L);
				int num2 = visit(ctx.R);
				try{
					file = new FileWriter("intermediatecode.txt",true);
					output = new BufferedWriter(file);
					output.write("load "+num1);
					output.write("\n");
					output.write("load "+num2);
					output.write("\n");
					output.write("div");
					output.write("\n");
					System.out.println("load "+num1);
					System.out.println("load "+num2);
					System.out.println("div");
					output.close();
				}catch(IOException e){
				e.printStackTrace();
			}
			}
		}
			
		return 0;
	}
	
	@Override
	public Integer visitADD(MyGrammarParser.ADDContext ctx) {
		
			if(ctx.getChild(1).getText().equals("+")){
				
				if((!ctx.L.getText().matches("[0-9]+")) && (!ctx.R.getText().matches("[0-9]+"))){				 
					 visit(ctx.L);
					 visit(ctx.R);
					 try{
							file = new FileWriter("intermediatecode.txt",true);
							output = new BufferedWriter(file);
							output.write("add");
							output.write("\n");
							System.out.println("add");
							output.close();
					 }catch(IOException e){
							e.printStackTrace();
						}
			}
			else if((!ctx.L.getText().matches("[0-9]+")) && (ctx.R.getText().matches("[0-9]+"))){
				visit(ctx.L);
				int num = visit(ctx.R);
				try{
					file = new FileWriter("intermediatecode.txt",true);
					output = new BufferedWriter(file);
					output.write("load "+num);
					output.write("\n");
					output.write("add");
					output.write("\n");
					System.out.println("load "+num);
					System.out.println("add");
					output.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			else if ((!ctx.R.getText().matches("[0-9]+")) && (ctx.L.getText().matches("[0-9]+"))){
				visit(ctx.R);
				int num = visit(ctx.L);
				try{
					file = new FileWriter("intermediatecode.txt",true);
					output = new BufferedWriter(file);
					output.write("load "+num);
					output.write("\n");
					output.write("add");
					output.write("\n");
					System.out.println("load "+num);
					System.out.println("add");
					output.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}else{			
				int num1 = visit(ctx.L);
				int num2 = visit(ctx.R);
				try{
					file = new FileWriter("intermediatecode.txt",true);
					output = new BufferedWriter(file);
					output.write("load "+num1);
					output.write("\n");
					output.write("load "+num2);
					output.write("\n");
					output.write("add");
					output.write("\n");
					System.out.println("load "+num1);
					System.out.println("load "+num2);
					System.out.println("add");
					output.close();
				}catch(IOException e){
				e.printStackTrace();
			}
			}
		
			}
			else if(ctx.getChild(1).getText().equals("-")){
				if((!ctx.L.getText().matches("[0-9]+")) && (!ctx.R.getText().matches("[0-9]+"))){				 
					 visit(ctx.L);
					 visit(ctx.R);
					 try{
							file = new FileWriter("intermediatecode.txt",true);
							output = new BufferedWriter(file);
							output.write("sub");
							output.write("\n");
							System.out.println("sub");
							output.close();
					 }catch(IOException e){
							e.printStackTrace();
						}
			}
			else if((!ctx.L.getText().matches("[0-9]+")) && (ctx.R.getText().matches("[0-9]+"))){
				visit(ctx.L);
				int num = visit(ctx.R);
				try{
					file = new FileWriter("intermediatecode.txt",true);
					output = new BufferedWriter(file);
					output.write("load "+num);
					output.write("\n");
					output.write("sub");
					output.write("\n");
					System.out.println("load "+num);
					System.out.println("sub");
					output.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			else if ((!ctx.R.getText().matches("[0-9]+")) && (ctx.L.getText().matches("[0-9]+"))){
				visit(ctx.R);
				int num = visit(ctx.L);
				try{
					file = new FileWriter("intermediatecode.txt",true);
					output = new BufferedWriter(file);
					output.write("load "+num);
					output.write("\n");
					output.write("sub");
					output.write("\n");
					System.out.println("load "+num);
					System.out.println("sub");
					output.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}else{			
				int num1 = visit(ctx.L);
				int num2 = visit(ctx.R);
				try{
					file = new FileWriter("intermediatecode.txt",true);
					output = new BufferedWriter(file);
					output.write("load "+num1);
					output.write("\n");
					output.write("load "+num2);
					output.write("\n");
					output.write("sub");
					output.write("\n");
					System.out.println("load "+num1);
					System.out.println("load "+num2);
					System.out.println("sub");
					output.close();
				}catch(IOException e){
				e.printStackTrace();
			}
			}
		}
		return 0;
	}
	
	@Override
	public Integer visitOP(MyGrammarParser.OPContext ctx) {
			visit(ctx.L);
			if (ctx.R.getText().matches("[0-9]+")){
				try{
					file = new FileWriter("intermediatecode.txt",true);
					output = new BufferedWriter(file);
					output.write(("load " + ctx.R.getText()));
					output.write("\n");
					System.out.println("load " + Integer.parseInt(ctx.R.getText()));
					output.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}else{
			visit(ctx.R);
			}
			String opr = "";
			if(ctx.ROP.getText().equals("<")){
					System.out.println("LE");
					opr = "LE";
					System.out.println("cond true");
			}
			else if (ctx.ROP.getText().equals(">")){
				System.out.println("GE");
				System.out.println("cond true");
				opr = "GE";
			}else if (ctx.ROP.getText().equals("<=")){
				System.out.println("LEQ");
				System.out.println("cond true");
				opr = "LEQ";
			}else if (ctx.ROP.getText().equals(">=")){
				System.out.println("GEQ");
				System.out.println("cond true");
				opr = "GEQ";
			}else if(ctx.ROP.getText().equals("==")){
				System.out.println("EQ");
				System.out.println("cond true");
				opr = "EQ";
			}else if(ctx.ROP.getText().equals("!=")){
				System.out.println("NEQ");
				System.out.println("cond true");
				opr = "NEQ";
		}
			try{
				file = new FileWriter("intermediatecode.txt",true);
				output = new BufferedWriter(file);
				output.write(opr);
				output.write("\n");
				output.write("cond true");
				output.write("\n");
				output.close();
			}catch(IOException e){
				e.printStackTrace();
			}						
		return 0;
	}
	
	
	@Override
	public Integer visitAssignment(MyGrammarParser.AssignmentContext ctx) {
		
		visitChildren(ctx);
		if(!(ctx.aE.getText().matches("[0-9]+"))){
			try{
				file = new FileWriter("intermediatecode.txt",true);
				output = new BufferedWriter(file);
			output.write("store" + " " + ctx.ID.getText());
			System.out.print("store" + " " + ctx.ID.getText());
			output.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else {
			if (ctx.aE.getText().matches("[0-9]+")){
				try{
					file = new FileWriter("intermediatecode.txt",true);
					output = new BufferedWriter(file);
					int num = visit(ctx.aE);
					output.write("load "+ num);
					output.write("\n");
					System.out.println("load " + ctx.aE.getText());	
					output.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			}

			try{
				file = new FileWriter("intermediatecode.txt",true);
				output = new BufferedWriter(file);
			output.write("store" + " " + ctx.ID.getText());
			System.out.println("store" + " " + ctx.ID.getText());
			output.write("\n");
			output.close();
			}catch(IOException e){
				e.printStackTrace();
			}
						visit(ctx.aE);

		}
		
		return 0;
	}
	
	@Override
	public Integer visitIDEN(MyGrammarParser.IDENContext ctx) {
		try{
			file = new FileWriter("intermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write("load " + ctx.getText());
			output.write("\n");
			System.out.println("load " + ctx.getText());
			output.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Integer visitFunction(MyGrammarParser.FunctionContext ctx) {
		try{
			file = new FileWriter("intermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write("decl " + ctx.getChild(2).getText() + " ");
			System.out.print("decl " + ctx.getChild(2).getText() + " ") ;
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
			visitChildren(ctx);
			return 0;
		
	}
	
	@Override
	public Integer visitParameters(MyGrammarParser.ParametersContext ctx) {
		visitChildren(ctx);
		try{
			file = new FileWriter("intermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write("\n");
			System.out.println();
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	
	@Override
	public Integer visitParameter(MyGrammarParser.ParameterContext ctx) {
		try{
			file = new FileWriter("intermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write(ctx.getChild(0).getText() + " " + ctx.getChild(1).getText() + " " );
			System.out.print(ctx.getChild(0).getText() + " " + ctx.getChild(1).getText() + " ");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
			return 0;
	}
	
	@Override
	public Integer visitRtrnStat(MyGrammarParser.RtrnStatContext ctx) {
		try{
			file = new FileWriter("intermediatecode.txt",true);
			output = new BufferedWriter(file);
			System.out.println();
			output.write("\n");
			output.write("ret");
			output.write("\n");
			System.out.println("ret");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Integer visitFuncCallStat(MyGrammarParser.FuncCallStatContext ctx) {
		try{
			file = new FileWriter("intermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write("call " + ctx.getChild(0) + " ");
			System.out.print("call " + ctx.getChild(0) + " " );
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		visitChildren(ctx);
		return 0;
	}
	
	@Override
	public Integer visitActualParams(MyGrammarParser.ActualParamsContext ctx) {
		visitChildren(ctx);
		int num = visit(ctx.pL);
		try{
			file = new FileWriter("intermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write(num + "\n");
			System.out.print(num + "\n");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Integer visitStacktype(MyGrammarParser.StacktypeContext ctx) {
		try{
			file = new FileWriter("intermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write("STACK " + ctx.ID.getText()+ "\n");
		System.out.print("STACK " + ctx.ID.getText()+ "\n");
		output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Integer visitStackoper(MyGrammarParser.StackoperContext ctx) {
		try{
			file = new FileWriter("intermediatecode.txt",true);
			output = new BufferedWriter(file);
		if(ctx.getChild(1).getText().contains(".push")){
			
			output.write(ctx.PUSH.getText() + ".push" + " " + ctx.StackNumber.getText());
			output.write("\n"); 
			System.out.println(ctx.PUSH.getText() + ".push" + " " + ctx.StackNumber.getText());
		}
		 if(ctx.getChild(1).getText().equals(".pop()")){
			 output.write(ctx.POP.getText() + ".pop");			 
			 output.write("\n");
			 System.out.println(ctx.POP.getText() + ".pop");
		 }
		if(ctx.getChild(1).getText().equals(".peek()")){
			output.write(ctx.PEEK.getText() + ".peek");
			output.write("\n");
			System.out.println(ctx.PEEK.getText() + ".peek");
		}
		else if(ctx.getChild(1).getText().equals(".isEmpty()")){
			output.write(ctx.EMPTY.getText() + ".isEmpty");
			output.write("\n");
			System.out.println(ctx.EMPTY.getText() + ".isEmpty");
		}
		output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Integer visitIfStat(MyGrammarParser.IfStatContext ctx) {		
		visitChildren(ctx);
		return 0;
	}

	@Override
	public Integer visitIfstatement(MyGrammarParser.IfstatementContext ctx) {
		// TODO Auto-generated method stub
		try{
			file = new FileWriter("intermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write("\n");
			output.write("CHK ");
			output.write("\n");
			System.out.println();
			System.out.println("CHK ");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
			visit(ctx.exp);
			
			visit(ctx.st);
			try{
			file = new FileWriter("intermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write("\nEndIf");
			output.write("\n");
			output.close();
			System.out.println("\nEndIf");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public Integer visitElsestat(MyGrammarParser.ElsestatContext ctx) {
	
		try{
			file = new FileWriter("intermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write("Cond False");
			output.write("\n");
			output.close();
			System.out.println("Cond False");
		}catch(IOException e){
			e.printStackTrace();
		}
			visit(ctx.eS);
			try{
			file = new FileWriter("intermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write("EndIfElse");
			output.write("\n");
			System.out.println("EndIfElse");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
			return 0;
	}
	
	@Override
	public Integer visitWhileStat(MyGrammarParser.WhileStatContext ctx) {
		
		try{
			file = new FileWriter("intermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write("WHILE ");
			output.write("\n");
			System.out.println("WHILE ");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
			visit(ctx.exp);
			
			visit(ctx.st);
			try{
				file = new FileWriter("intermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write("\n");
			output.write("gotowhile");
			output.write("\n");
			output.write("\nEndWhile");
			output.write("\n");
			System.out.println();
			System.out.println("gotowhile");
			System.out.println("EndWhile");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return 0;
		
	}
	
	@Override
	public Integer visitDisplayStat(MyGrammarParser.DisplayStatContext ctx) {
		try{
			file = new FileWriter("intermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write("disp " + ctx.id.getText());
			output.write("\n");
			System.out.println("disp " + ctx.id.getText());
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
			return 0;
		
	}
}