import java.io.*;

public class MyVisitor extends MyGrammarBaseVisitor<Integer> {
	
	public static String intermediate;
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
		file = new FileWriter("itermediatecode.txt",true);
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
		//super.visitEnd(ctx);
		try{
			file = new FileWriter("itermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write("END\n");
			output.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("END");
		//System.out.println(intermediate);
		return 0;				
	}
	
	@Override
	public Integer visitProgram(MyGrammarParser.ProgramContext ctx) {
		// TODO Auto-generated method stub
		visitChildren(ctx);
		return 0;
	}
	
	@Override
	public Integer visitVariable(MyGrammarParser.VariableContext ctx) {
		// TODO Auto-generated method stub
		
		if(ctx.getChildCount()== 4){
			if(ctx.E.children.size()<2){
				System.out.println(ctx.t.getText());
				if(ctx.t.getText().equals("int")){
					try{
						file = new FileWriter("itermediatecode.txt",true);
						output = new BufferedWriter(file);
					String var = ctx.id.getText();
					int num = visit(ctx.E);
					output.write("mov"+" "+var+","+Integer.toString(num));
					output.write("\n");
					System.out.println("mov"+" "+var+","+Integer.toString(num));
					output.close();
					}catch(IOException e){
						e.printStackTrace();
					}						
					}
				else if(ctx.t.getText().equals("bool"))
					{
					
					String var = ctx.id.getText();
					int num = visit(ctx.E);					
					
					try{
						file = new FileWriter("itermediatecode.txt",true);
						output = new BufferedWriter(file);
					output.write("mov"+" "+var+","+Integer.toString(num));
					output.write("\n");
					System.out.println("mov"+" "+var+","+num);
					output.close();
					}catch(IOException e){
						e.printStackTrace();
					}	
				}
			}else{			
				visit(ctx.E);
				try{
					file = new FileWriter("itermediatecode.txt",true);
					output = new BufferedWriter(file);
				String var = ctx.id.getText();
				output.write("mov"+" "+var+","+"temp");
				output.write("\n");
				System.out.println("mov"+" "+var+","+"temp");
				output.write("del temp");
				output.write("\n");
				System.out.println("del temp");
				output.close();
			}catch(IOException e){
				e.printStackTrace();
			}				
		}		
		}
		else if(ctx.getChildCount()== 2){
			
				String var = ctx.id.getText();
				int num = 0;
				try{
					file = new FileWriter("itermediatecode.txt",true);
					output = new BufferedWriter(file);
				output.write("mov"+" "+var+","+num);
				output.write("\n");
				System.out.println("mov"+" "+var+","+num);	
				output.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
	
		return 0;
	}
	
	@Override
	public Integer visitNUM(MyGrammarParser.NUMContext ctx) {
		
		return Integer.parseInt(ctx.getText());
	}
	
	@Override
	public Integer visitBOOL(MyGrammarParser.BOOLContext ctx) {
		// TODO Auto-generated method stub
		
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
				try{
					file = new FileWriter("itermediatecode.txt",true);
					output = new BufferedWriter(file);	
				output.write("mov"+" "+"temp,"+ ctx.L.getText());
				output.write("\n");
			System.out.println("mov"+" "+"temp,"+ ctx.L.getText());
			output.write("mov"+" "+"temp,"+ ctx.R.getText());
			output.write("\n");
			System.out.println("mul"+" "+"temp"+","+ ctx.R.getText());
				output.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			else if(ctx.getChild(1).getText().equals("/")){
				try{
					file = new FileWriter("itermediatecode.txt",true);
					output = new BufferedWriter(file);	
					output.write("mov"+" "+"temp,"+ ctx.L.getText());
					output.write("\n");
					output.write("div"+" "+"temp"+","+ ctx.R.getText());
					output.write("\n");
				System.out.println("mov"+" "+"temp,"+ ctx.L.getText());
				System.out.println("div"+" "+"temp"+","+ ctx.R.getText());
				output.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			
		
		return 0;
	}
	
	@Override
	public Integer visitADD(MyGrammarParser.ADDContext ctx) {
		// TODO Auto-generated method stub
		
			if(ctx.getChild(1).getText().equals("+")){
				try{
					file = new FileWriter("itermediatecode.txt",true);
					output = new BufferedWriter(file);
				output.write("mov"+" "+"temp,"+ ctx.L.getText());
				output.write("\n");
			System.out.println("mov"+" "+"temp,"+ ctx.L.getText());
			output.write("add"+" "+"temp"+","+ ctx.R.getText());
			output.write("\n");
			System.out.println("add"+" "+"temp"+","+ ctx.R.getText());	
			output.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			else if(ctx.getChild(1).getText().equals("-")){
				try{
					file = new FileWriter("itermediatecode.txt",true);
					output = new BufferedWriter(file);
				output.write("mov"+" "+"temp,"+ ctx.L.getText());
				output.write("\n");
				System.out.println("mov"+" "+"temp,"+ ctx.L.getText());
				output.write("sub"+" "+"temp"+","+ ctx.R.getText());
				output.write("\n");
				System.out.println("sub"+" "+"temp"+","+ ctx.R.getText());
				output.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		return 0;
	}
	
	@Override
	public Integer visitOP(MyGrammarParser.OPContext ctx) {
		
			visit(ctx.L);
			try{
				file = new FileWriter("itermediatecode.txt",true);
				output = new BufferedWriter(file);
			output.write(" " +ctx.ROP.getText()+ " ");
			System.out.print(" " +ctx.ROP.getText()+ " ");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
			visit(ctx.R);
			if (ctx.R.getText().matches("[0-9]+")){
				try{
					file = new FileWriter("itermediatecode.txt",true);
					output = new BufferedWriter(file);
				output.write((ctx.R.getText()));
				output.write("\n");
				System.out.println(Integer.parseInt(ctx.R.getText()));
				output.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			
		
		return 0;
	}
	
	
	@Override
	public Integer visitAssignment(MyGrammarParser.AssignmentContext ctx) {
		
		visitChildren(ctx);
		if(!(ctx.aE.getText().matches("[0-9]+"))){
			try{
				file = new FileWriter("itermediatecode.txt",true);
				output = new BufferedWriter(file);
			output.write("mov" + " " + ctx.ID.getText() + "," + "temp");
			System.out.print("mov" + " " + ctx.ID.getText() + "," + "temp");
			output.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else {
			try{
				file = new FileWriter("itermediatecode.txt",true);
				output = new BufferedWriter(file);
			output.write("mov" + " " + ctx.ID.getText() + ",");
			System.out.print("mov" + " " + ctx.ID.getText() + ",");
			output.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			if (ctx.aE.getText().matches("[0-9]+")){
				try{
					file = new FileWriter("itermediatecode.txt",true);
					output = new BufferedWriter(file);
				output.write(ctx.aE.getText());
				output.write("\n");
				System.out.println(ctx.aE.getText());	
				output.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			}
			visit(ctx.aE);

		}
		
		return 0;
	}
	
	@Override
	public Integer visitType(MyGrammarParser.TypeContext ctx) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Integer visitIDEN(MyGrammarParser.IDENContext ctx) {
		try{
			file = new FileWriter("itermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write(ctx.getText());
			System.out.print(ctx.getText());
			output.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Integer visitFunction(MyGrammarParser.FunctionContext ctx) {
		//System.out.println("Inside function definition");
		try{
			file = new FileWriter("itermediatecode.txt",true);
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
		//System.out.println(ctx.getChildCount());
		visitChildren(ctx);
		
		return 0;
	}
	
	
	@Override
	public Integer visitParameter(MyGrammarParser.ParameterContext ctx) {
		try{
			file = new FileWriter("itermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write(ctx.getChild(0).getText() + " " + ctx.getChild(1).getText() + " " + "\n");
			System.out.print(ctx.getChild(0).getText() + " " + ctx.getChild(1).getText() + " " + "\n");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
			return 0;
	}
	
	@Override
	public Integer visitRtrnStat(MyGrammarParser.RtrnStatContext ctx) {
		try{
			file = new FileWriter("itermediatecode.txt",true);
			output = new BufferedWriter(file);
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
			file = new FileWriter("itermediatecode.txt",true);
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
			file = new FileWriter("itermediatecode.txt",true);
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
			file = new FileWriter("itermediatecode.txt",true);
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
			file = new FileWriter("itermediatecode.txt",true);
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
			file = new FileWriter("itermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write("\n");
			output.write("CHK ");
			System.out.println();
			System.out.print("CHK ");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
			visit(ctx.exp);
			try{
				file = new FileWriter("itermediatecode.txt",true);
				output = new BufferedWriter(file);
			output.write("Cond True");
			output.write("\n");
			System.out.println("Cond True");
			}catch(IOException e){
				e.printStackTrace();
			}
			visit(ctx.st);
			try{
			file = new FileWriter("itermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write("\nEndIf");
			output.write("\n");
			System.out.println("\nEndIf");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public Integer visitElsestat(MyGrammarParser.ElsestatContext ctx) {
		// TODO Auto-generated method stub
		try{
			file = new FileWriter("itermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write("Cond False");
			output.write("\n");
			System.out.println("Cond False");
		}catch(IOException e){
			e.printStackTrace();
		}
			visit(ctx.eS);
			try{
			file = new FileWriter("itermediatecode.txt",true);
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
			file = new FileWriter("itermediatecode.txt",true);
			output = new BufferedWriter(file);
			//visitChildren(ctx);
			output.write("WHILE ");
			System.out.print("WHILE ");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
			visit(ctx.exp);
			try{
			file = new FileWriter("itermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write("Cond True");
			output.write("\n");
			System.out.println("Cond True");
			}catch(IOException e){
				e.printStackTrace();
			}
			visit(ctx.st);
			try{
				file = new FileWriter("itermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write("\nEndWhile");
			output.write("\n");
			System.out.println("\nEndWhile");
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return 0;
		
	}
	
	@Override
	public Integer visitDisplayStat(MyGrammarParser.DisplayStatContext ctx) {
		try{
			file = new FileWriter("itermediatecode.txt",true);
			output = new BufferedWriter(file);
			output.write("disp " + ctx.id.getText());
			System.out.print("disp " + ctx.id.getText());
			output.close();
		}catch(IOException e){
			e.printStackTrace();
		}
			return 0;
		
	}
}
