import org.stringtemplate.v4.*;
import java.io.*;

public class HelloMyVisitior extends HelloBaseVisitor<Integer>{
	
	public static String intermediate;
	
	@Override
	public Integer visitBegin(HelloParser.BeginContext ctx){
		super.visitBegin(ctx);
		ST temp = new ST("BEGIN");
		String t = temp.render();
		intermediate = t;
		intermediate +="\n";
		System.out.println(intermediate);
		return 0;	
	}
	
	@Override
	public Integer visitEnd(HelloParser.EndContext ctx){
		super.visitEnd(ctx);
		ST temp = new ST("END");
		String t = temp.render();
		intermediate += t;
		try{
			File file = new File("IC.txt");
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			output.write(intermediate);
			output.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		System.out.println(intermediate);
		return 0; 	
	}
	
	
	@Override
	public Integer visitProgram(HelloParser.ProgramContext ctx){
		
		return 0;
	}
	
}
