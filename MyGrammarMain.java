import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

public class MyGrammarMain {
    public static void main(String[] args) throws Exception {
        String inputFile = "input.txt";
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null ) is = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);
        
        MyGrammarLexer lexer = new MyGrammarLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        MyGrammarParser parser = new MyGrammarParser(tokens);
        
        ParseTree tree = parser.start(); // parse        
        MyVisitor eval = new MyVisitor();
        System.out.println("I am here");
        eval.visit(tree);
    }
}