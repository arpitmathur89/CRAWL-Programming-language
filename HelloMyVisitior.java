import org.stringtemplate.v4.*;


import java.io.*;

public class HelloMyVisitior extends HelloBaseVisitor<Integer>{
	
	public static String intermediate;
	FileWriter file;
	BufferedWriter output;
	
	@Override
	public Integer visitStart(HelloParser.StartContext ctx) {
		
		 visitChildren(ctx);
			return 0;
	}
	@Override
	public Integer visitBegin(HelloParser.BeginContext ctx){

	    System.out.println("BEGIN");
		ST temp = new ST("BEGIN");
		String t = temp.render();
		intermediate = t;
		intermediate +="\n";
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
	public Integer visitVariable(HelloParser.VariableContext ctx) { 
		if(ctx.getChildCount()== 4){
			if(ctx.E.children.size()<2){
				if(ctx.t.getText().equals("int")){
					String var = ctx.id.getText();
					int num = visit(ctx.E);
					System.out.println("mov"+" "+var+","+num);
				}else if(ctx.t.getText().equals("bool")){
					String var = ctx.id.getText();
					int num = visit(ctx.E);
					System.out.println("mov"+" "+var+","+num);
				}
			}
			else{
				visit(ctx.E);
				String var = ctx.id.getText();
				//System.out.println("visit aaya");
				System.out.println("mov"+" "+var+","+"temp");
				System.out.println("del temp");
			}
		}
		if(ctx.getChildCount()== 2){
				String var = ctx.id.getText();
				int num = 0;
				System.out.println("mov"+" "+var+","+num);			
		}
		
		return 0;
	}
	
	@Override
	public Integer visitEnd(HelloParser.EndContext ctx){
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
		ST temp = new ST("END");
		String t = temp.render();
		intermediate += t;
		//System.out.println(intermediate);
		return 0;				
	}
	
	
	@Override
	public Integer visitProgram(HelloParser.ProgramContext ctx){
		visitChildren(ctx);
		return 0;
	}
	
	@Override 
	public Integer visitNUM(HelloParser.NUMContext ctx) {
		// TODO Auto-generated method stub
		return Integer.parseInt(ctx.getText());
	}
	
	@Override
	public Integer visitBOOL(HelloParser.BOOLContext ctx) {
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
	public Integer visitMUL(HelloParser.MULContext ctx) {
		
		if(ctx.getChild(1).getText().equals("*")){
		System.out.println("mov"+" "+"temp,"+ ctx.L.getText());
		System.out.println("mul"+" "+"temp"+","+ ctx.R.getText());
		
		}
		else if(ctx.getChild(1).getText().equals("/")){
			System.out.println("mov"+" "+"temp,"+ ctx.L.getText());
			System.out.println("div"+" "+"temp"+","+ ctx.R.getText());
		}
		return 0;
	}
	
	@Override
	public Integer visitADD(HelloParser.ADDContext ctx) {
		// TODO Auto-generated method stub
		
		if(ctx.getChild(1).getText().equals("+")){
		System.out.println("mov"+" "+"temp,"+ ctx.L.getText());
		System.out.println("add"+" "+"temp"+","+ ctx.R.getText());		
		}
		else if(ctx.getChild(1).getText().equals("-")){
			System.out.println("mov"+" "+"temp,"+ ctx.L.getText());
			System.out.println("sub"+" "+"temp"+","+ ctx.R.getText());
		}
		return 0;
	}
	
	@Override
	public Integer visitOP(HelloParser.OPContext ctx) {
		visit(ctx.L);
		System.out.print(" " +ctx.ROP.getText()+ " ");
		visit(ctx.R);
		if (ctx.R.getText().matches("[0-9]+"))
			System.out.println(Integer.parseInt(ctx.R.getText()));
		return 0;
	}
	
	
	@Override
	public Integer visitAssignment(HelloParser.AssignmentContext ctx) {
		// TODO Auto-generated method stub
		//System.out.println("Inside Assignment");
		visitChildren(ctx);
		//System.out.println(ctx.getChild(2).getText());
		if(!(ctx.aE.getText().matches("[0-9]+"))){
			//System.out.println("aaya\n");
			System.out.print("mov" + " " + ctx.ID.getText() + "," + "temp");
		}else {
			System.out.print("mov" + " " + ctx.ID.getText() + ",");
			if (ctx.aE.getText().matches("[0-9]+"))
				System.out.println(Integer.parseInt(ctx.aE.getText()));	
			visit(ctx.aE);

		}
		//System.out.print("mov" + " " + ctx.ID.getText() + ",");
		
		return 0;
	}
	
	@Override
	public Integer visitType(HelloParser.TypeContext ctx) {
		// TODO Auto-generated method stub
		//System.out.println("Inside Type");
		return super.visitType(ctx);
	}
	
	@Override
	public Integer visitIDEN(HelloParser.IDENContext ctx) {
		System.out.print(ctx.getText());
		return 0;
	}
	
	@Override
	public Integer visitFunction(HelloParser.FunctionContext ctx) {
		//System.out.println("Inside function definition");
		System.out.print("decl " + ctx.getChild(2).getText() + " ") ;
		visitChildren(ctx);
		return 0;
	}
	//int paramcount  = 0;
	@Override
	public Integer visitParameters(HelloParser.ParametersContext ctx) {
		//System.out.println(ctx.getChildCount());
		visitChildren(ctx);
		
		return 0;
	}
	
	@Override
	public Integer visitParameter(HelloParser.ParameterContext ctx) {
	    
		System.out.print(ctx.getChild(0).getText() + " " + ctx.getChild(1).getText() + " " + "\n");
		return 0;
	}
	
	@Override
	public Integer visitRtrnStat(HelloParser.RtrnStatContext ctx) {
		System.out.println("ret");
		return 0;
	}
	
	@Override
	public Integer visitFuncCallStat(HelloParser.FuncCallStatContext ctx) {
		System.out.print("call " + ctx.getChild(0) + " " );
		visitChildren(ctx);
		return 0;
	}
	
	@Override
	public Integer visitActualParams(HelloParser.ActualParamsContext ctx) {
		visitChildren(ctx);
		int num = visit(ctx.pL);
		System.out.print(num + "\n");
		//visit(ctx.);
		return 0;
	}
	
	@Override
	public Integer visitIfStat(HelloParser.IfStatContext ctx) {
		// System.out.println("Inside if statement");
		//System.out.print("CHK ");
		System.out.println(ctx.getChildCount());
		visitChildren(ctx);
		//visit(ctx.exp);	
		//visit(ctx.st);
		//System.out.println(" ");
		return 0;
	}

	@Override
	public Integer visitIfstatement(HelloParser.IfstatementContext ctx) {
		// TODO Auto-generated method stub
		
		System.out.print("CHK ");
		visit(ctx.exp);
		System.out.println("Cond True");
		visit(ctx.st);
		System.out.println("\nEndIf");
		
		return 0;
	}
	@Override
	public Integer visitElsestat(HelloParser.ElsestatContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("Cond False");
		visit(ctx.eS);
		System.out.println("EndIfElse");
		return 0;
	}
	
	@Override
	public Integer visitWhileStat(HelloParser.WhileStatContext ctx) {
		
		visitChildren(ctx);
		
		System.out.print("WHILE ");
		visit(ctx.exp);
		System.out.println("Cond True");
		visit(ctx.st);
		System.out.println("\nEndWhile");
		
		return 0;
		
	}
	
	@Override
	public Integer visitDisplayStat(HelloParser.DisplayStatContext ctx) {
		System.out.print("disp " + ctx.id.getText() + "\n");
		return 0;
	}	
}
