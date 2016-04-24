import org.stringtemplate.v4.*;
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
		ST temp = new ST("END");
		String t = temp.render();
		intermediate += t;
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
	public Integer visitADD(MyGrammarParser.ADDContext ctx) {
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
	public Integer visitOP(MyGrammarParser.OPContext ctx) {
		visit(ctx.L);
		System.out.print(" " +ctx.ROP.getText()+ " ");
		visit(ctx.R);
		if (ctx.R.getText().matches("[0-9]+"))
			System.out.println(Integer.parseInt(ctx.R.getText()));
		return 0;
	}
	
	
	@Override
	public Integer visitAssignment(MyGrammarParser.AssignmentContext ctx) {
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
	public Integer visitType(MyGrammarParser.TypeContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("Inside Type");
		return super.visitType(ctx);
	}
	
	@Override
	public Integer visitIDEN(MyGrammarParser.IDENContext ctx) {
		System.out.print(ctx.getText());
		return 0;
	}
	
	@Override
	public Integer visitFunction(MyGrammarParser.FunctionContext ctx) {
		System.out.println("Inside function definition");
		return super.visitFunction(ctx);
	}
	
	@Override
	public Integer visitIfStat(MyGrammarParser.IfStatContext ctx) {
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
	public Integer visitIfstatement(MyGrammarParser.IfstatementContext ctx) {
		// TODO Auto-generated method stub
		
		System.out.print("CHK ");
		visit(ctx.exp);
		System.out.println("Cond True");
		visit(ctx.st);
		System.out.println("\nEndIf");
		
		return 0;
	}
	@Override
	public Integer visitElsestat(MyGrammarParser.ElsestatContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("Cond False");
		visit(ctx.eS);
		System.out.println("EndIfElse");
		return 0;
	}
	
	@Override
	public Integer visitWhileStat(MyGrammarParser.WhileStatContext ctx) {
		
		visitChildren(ctx);
		
		System.out.print("WHILE ");
		visit(ctx.exp);
		System.out.println("Cond True");
		visit(ctx.st);
		System.out.println("\nEndWhile");
		
		return 0;
		
	}
	
	@Override
	public Integer visitDisplayStat(MyGrammarParser.DisplayStatContext ctx) {
		System.out.print("disp " + ctx.id.getText());
		return 0;
	}
}
