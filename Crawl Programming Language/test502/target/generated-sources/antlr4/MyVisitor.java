import java.io.*;

public class MyVisitor extends MyGrammarBaseVisitor<Integer>{
	
	FileWriter file;
	BufferedWriter output;
	String filename = "intermediate.crwclass";
	
	@Override
	public Integer visitStart(MyGrammarParser.StartContext ctx) {
	    visitChildren(ctx);
		return 0;
	}
	
	@Override
	public Integer visitBegin(MyGrammarParser.BeginContext ctx) {
		
		visitChildren(ctx);
		try{
		file = new FileWriter(filename);
		output = new BufferedWriter(file);
		output.write("BEGIN");
		output.write("\n");
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
			file = new FileWriter(filename,true);
			output = new BufferedWriter(file);
			output.write("END");
			output.write("\n");
			output.close();
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
				file = new FileWriter(filename,true);
				output = new BufferedWriter(file);
				output.write("\n");
				output.write("load"+" "+num);
				output.write("\n");
				output.write("store"+" "+var);
				output.write("\n");
				output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		}else{
			if(ctx.getChildCount()== 4 && (ctx.E.getText().matches("[0-9]+")|| ctx.E.getText().equals("true")|| ctx.E.getText().equals("false"))){
				int num = visit(ctx.E);
				try{
					file = new FileWriter(filename,true);
					output = new BufferedWriter(file);
					output.write("\n");
					output.write("load "+num);
					output.write("\n");
					output.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			}else{
			visit(ctx.E);	
			}
			try{
				file = new FileWriter(filename,true);
				output = new BufferedWriter(file);
				String var = ctx.id.getText();
				output.write("store "+" "+var);
				output.write("\n");
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
								file = new FileWriter(filename,true);
								output = new BufferedWriter(file);
								output.write("mul");
								output.write("\n");
								output.close();
						 }catch(IOException e){
								e.printStackTrace();
							}
				}
				else if((!ctx.L.getText().matches("[0-9]+")) && (ctx.R.getText().matches("[0-9]+"))){
					visit(ctx.L);
					int num = visit(ctx.R);
					try{
						file = new FileWriter(filename,true);
						output = new BufferedWriter(file);
						output.write("load "+num);
						output.write("\n");
						output.write("mul");
						output.write("\n");
						output.close();
					}catch(IOException e){
						e.printStackTrace();
					}
				}
				else if ((!ctx.R.getText().matches("[0-9]+")) && (ctx.L.getText().matches("[0-9]+"))){
					visit(ctx.R);
					int num = visit(ctx.L);
					try{
						file = new FileWriter(filename,true);
						output = new BufferedWriter(file);
						output.write("load "+num);
						output.write("\n");
						output.write("mul");
						output.write("\n");
						output.close();
					}catch(IOException e){
						e.printStackTrace();
					}
				}else{			
					int num1 = visit(ctx.L);
					int num2 = visit(ctx.R);
					try{
						file = new FileWriter(filename,true);
						output = new BufferedWriter(file);
						output.write("load "+num1);
						output.write("\n");
						output.write("load "+num2);
						output.write("\n");
						output.write("mul");
						output.write("\n");
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
							file = new FileWriter(filename,true);
							output = new BufferedWriter(file);
							output.write("div");
							output.write("\n");
							output.close();
					 }catch(IOException e){
							e.printStackTrace();
						}
			}
			else if((!ctx.L.getText().matches("[0-9]+")) && (ctx.R.getText().matches("[0-9]+"))){
				visit(ctx.L);
				int num = visit(ctx.R);
				try{
					file = new FileWriter(filename,true);
					output = new BufferedWriter(file);
					output.write("load "+num);
					output.write("\n");
					output.write("div");
					output.write("\n");
					output.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			else if ((!ctx.R.getText().matches("[0-9]+")) && (ctx.L.getText().matches("[0-9]+"))){
				visit(ctx.R);
				int num = visit(ctx.L);
				try{
					file = new FileWriter(filename,true);
					output = new BufferedWriter(file);
					output.write("load "+num);
					output.write("\n");
					output.write("div");
					output.write("\n");
					output.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}else{			
				int num1 = visit(ctx.L);
				int num2 = visit(ctx.R);
				try{
					file = new FileWriter(filename,true);
					output = new BufferedWriter(file);
					output.write("load "+num1);
					output.write("\n");
					output.write("load "+num2);
					output.write("\n");
					output.write("div");
					output.write("\n");
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
							file = new FileWriter(filename,true);
							output = new BufferedWriter(file);
							output.write("add");
							output.write("\n");
							output.close();
					 }catch(IOException e){
							e.printStackTrace();
						}
			}
			else if((!ctx.L.getText().matches("[0-9]+")) && (ctx.R.getText().matches("[0-9]+"))){
				visit(ctx.L);
				int num = visit(ctx.R);
				try{
					file = new FileWriter(filename,true);
					output = new BufferedWriter(file);
					output.write("load "+num);
					output.write("\n");
					output.write("add");
					output.write("\n");
					output.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			else if ((!ctx.R.getText().matches("[0-9]+")) && (ctx.L.getText().matches("[0-9]+"))){
				visit(ctx.R);
				int num = visit(ctx.L);
				try{
					file = new FileWriter(filename,true);
					output = new BufferedWriter(file);
					output.write("load "+num);
					output.write("\n");
					output.write("add");
					output.write("\n");
					output.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}else{			
				int num1 = visit(ctx.L);
				int num2 = visit(ctx.R);
				try{
					file = new FileWriter(filename,true);
					output = new BufferedWriter(file);
					output.write("load "+num1);
					output.write("\n");
					output.write("load "+num2);
					output.write("\n");
					output.write("add");
					output.write("\n");
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
							file = new FileWriter(filename,true);
							output = new BufferedWriter(file);
							output.write("sub");
							output.write("\n");
							output.close();
					 }catch(IOException e){
							e.printStackTrace();
						}
			}
			else if((!ctx.L.getText().matches("[0-9]+")) && (ctx.R.getText().matches("[0-9]+"))){
				visit(ctx.L);
				int num = visit(ctx.R);
				try{
					file = new FileWriter(filename,true);
					output = new BufferedWriter(file);
					output.write("load "+num);
					output.write("\n");
					output.write("sub");
					output.write("\n");
					output.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			else if ((!ctx.R.getText().matches("[0-9]+")) && (ctx.L.getText().matches("[0-9]+"))){
				visit(ctx.R);
				int num = visit(ctx.L);
				try{
					file = new FileWriter(filename,true);
					output = new BufferedWriter(file);
					output.write("load "+num);
					output.write("\n");
					output.write("sub");
					output.write("\n");
					output.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}else{			
				int num1 = visit(ctx.L);
				int num2 = visit(ctx.R);
				try{
					file = new FileWriter(filename,true);
					output = new BufferedWriter(file);
					output.write("load "+num1);
					output.write("\n");
					output.write("load "+num2);
					output.write("\n");
					output.write("sub");
					output.write("\n");
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
					file = new FileWriter(filename,true);
					output = new BufferedWriter(file);
					output.write(("load " + ctx.R.getText()));
					output.write("\n");
					output.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}else{
			visit(ctx.R);
			}
			String opr = "";
			if(ctx.ROP.getText().equals("<")){					
					opr = "LE";					
			}
			else if (ctx.ROP.getText().equals(">")){
				opr = "GE";
			}else if (ctx.ROP.getText().equals("<=")){
				opr = "LEQ";
			}else if (ctx.ROP.getText().equals(">=")){
				opr = "GEQ";
			}else if(ctx.ROP.getText().equals("==")){
				opr = "EQ";
			}else if(ctx.ROP.getText().equals("!=")){
				opr = "NEQ";
		}
			try{
				file = new FileWriter(filename,true);
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
				file = new FileWriter(filename,true);
				output = new BufferedWriter(file);
			output.write("store" + " " + ctx.ID.getText());
			output.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else {
			if (ctx.aE.getText().matches("[0-9]+")){
				try{
					file = new FileWriter(filename,true);
					output = new BufferedWriter(file);
					int num = visit(ctx.aE);
					output.write("load "+ num);
					output.write("\n");	
					output.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			}

			try{
				file = new FileWriter(filename,true);
				output = new BufferedWriter(file);
			output.write("store" + " " + ctx.ID.getText());
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
			file = new FileWriter(filename,true);
			output = new BufferedWriter(file);
			output.write("\n");
			output.write("load " + ctx.getText());
			output.write("\n");
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
			file = new FileWriter(filename,true);
			output = new BufferedWriter(file);
			output.write("decl " + ctx.getChild(2).getText() + " ");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
			visitChildren(ctx);
			try{
				file = new FileWriter(filename,true);
				output = new BufferedWriter(file);
				output.write("\n");
				output.close();
			}catch(IOException e){
				e.printStackTrace();
			}	
			return 0;
		
	}
	
	@Override
	public Integer visitParameters(MyGrammarParser.ParametersContext ctx) {
		visitChildren(ctx);
		try{
			file = new FileWriter(filename,true);
			output = new BufferedWriter(file);
			output.write("\n");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	
	@Override
	public Integer visitParameter(MyGrammarParser.ParameterContext ctx) {
		try{
			file = new FileWriter(filename,true);
			output = new BufferedWriter(file);
			output.write(ctx.getChild(0).getText() + " " + ctx.getChild(1).getText() + " " );
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
			return 0;
	}
	
	@Override
	public Integer visitRtrnStat(MyGrammarParser.RtrnStatContext ctx) {
		if(ctx.E.getText().matches("[0-9]+")){
			int num = visit(ctx.E);
			try{
				file = new FileWriter(filename,true);
				output = new BufferedWriter(file);
				output.write("\n");
				output.write("load " + num);
				output.write("\n");
				output.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			visit(ctx.E);
		}
		try{
			file = new FileWriter(filename,true);
			output = new BufferedWriter(file);
			output.write("ret");
			output.write("\n");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public Integer visitFuncCallStat(MyGrammarParser.FuncCallStatContext ctx) {
		try{
			file = new FileWriter(filename,true);
			output = new BufferedWriter(file);
			output.write("\n");
			if(ctx.getChild(2)!=null)
				output.write("call " + ctx.getChild(0) + " " + ctx.getChild(2).getText());
			else
				output.write("call " + ctx.getChild(0));
			output.write("\n");
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
			file = new FileWriter(filename,true);
			output = new BufferedWriter(file);
			output.write(num + "\n");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Integer visitStacktype(MyGrammarParser.StacktypeContext ctx) {
		try{
			file = new FileWriter(filename,true);
			output = new BufferedWriter(file);
			output.write("\n");
			output.write("STACK " + ctx.ID.getText()+ "\n");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Integer visitStackoper(MyGrammarParser.StackoperContext ctx) {
		try{
			file = new FileWriter(filename,true);
			output = new BufferedWriter(file);
		if(ctx.getChild(1).getText().contains(".push")){			
			output.write(ctx.PUSH.getText() + ".push" + " " + ctx.StackNumber.getText());
			output.write("\n"); 
		}
		 if(ctx.getChild(1).getText().equals(".pop()")){
			 output.write(ctx.POP.getText() + ".pop");			 
			 output.write("\n");
		 }
		if(ctx.getChild(1).getText().equals(".peek()")){
			output.write(ctx.PEEK.getText() + ".peek");
			output.write("\n");
		}
		else if(ctx.getChild(1).getText().equals(".isEmpty()")){
			output.write(ctx.EMPTY.getText() + ".isEmpty");
			output.write("\n");
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
			file = new FileWriter(filename,true);
			output = new BufferedWriter(file);
			output.write("CHK ");
			output.write("\n");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		visitChildren(ctx);

			try{
			file = new FileWriter(filename,true);
			output = new BufferedWriter(file);
			output.write("\n");
			output.write("EndIf");
			output.write("\n");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public Integer visitElsestat(MyGrammarParser.ElsestatContext ctx) {
	
		try{
			file = new FileWriter(filename,true);
			output = new BufferedWriter(file);
			output.write("Cond False");
			output.write("\n");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
			visitChildren(ctx);
		
			try{
			file = new FileWriter(filename,true);
			output = new BufferedWriter(file);
			output.write("\n");
			output.write("EndIfElse");
			output.write("\n");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
			return 0;
	}
	
	@Override
	public Integer visitWhileStat(MyGrammarParser.WhileStatContext ctx) {
		
		try{
			file = new FileWriter(filename,true);
			output = new BufferedWriter(file);
			output.write("WHILE ");
			output.write("\n");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
			visitChildren(ctx);
			
			try{
				file = new FileWriter(filename,true);
			output = new BufferedWriter(file);
			output.write("\n");
			output.write("gotowhile");
			output.write("\n");
			output.write("\nEndWhile");
			output.write("\n");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return 0;
		
	}
	
	@Override
	public Integer visitDisplayStat(MyGrammarParser.DisplayStatContext ctx) {
		try{
			file = new FileWriter(filename,true);
			output = new BufferedWriter(file);
			output.write("\n");
			output.write("disp " + ctx.id.getText());
			output.write("\n");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
			return 0;
		
	}
}