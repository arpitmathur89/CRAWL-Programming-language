import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

public class MyGrammarMain {
	
	
    public static void main(String[] args) throws Exception {
        /*
    	if(args.length > 1 || args.length < 1)
            throw new IllegalArgumentException("Invalid Number of Arguments");
		*/
       String filename = "input.txt";
    	
        InputStream is = System.in;
        if ( filename!=null ) is = new FileInputStream(filename);
        ANTLRInputStream input = new ANTLRInputStream(is);
        
        MyGrammarLexer lexer = new MyGrammarLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);        
        MyGrammarParser parser = new MyGrammarParser(tokens);        
        ParseTree tree = parser.start(); // parse        
        MyVisitor eval = new MyVisitor();
        eval.visit(tree);
    }
}