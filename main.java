import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.CharStreams;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException{

	// we expect exactly one argument: the name of the input file
	if (args.length!=1) {
	    System.err.println("\n");
	    System.err.println("Please give as input argument a filename\n");
	    System.exit(-1);
	}
	String filename=args[0];

	// open the input file
	CharStream input = CharStreams.fromFileName(filename);
	    //new ANTLRFileStream (filename); // depricated
	
	// create a lexer/scanner
	ccLexer lex = new ccLexer(input);
	
	// get the stream of tokens from the scanner
	CommonTokenStream tokens = new CommonTokenStream(lex);
	
	// create a parser
	ccParser parser = new ccParser(tokens);
	
	// and parse anything from the grammar for "start"
	ParseTree parseTree = parser.start();

	// Construct an interpreter and run it on the parse tree
	Interpreter interpreter = new Interpreter();
	String result=interpreter.visit(parseTree);
	System.out.println("The result is: "+result);
    }
}

// We write an interpreter that implements interface
// "implVisitor<T>" that is automatically generated by ANTLR
// This is parameterized over a return type "<T>" which is in our case
// simply a Double.

class Interpreter extends AbstractParseTreeVisitor<String>
                  implements ccVisitor<String> {
    // todo - Java will complain that "Interpreter" does not in fact
    // implement "implVisitor" at the moment.
	String visitStart(ccParser.StartContext ctx) {

	}

	String visitSignal(ccParser.SignalContext ctx) {

	}

	String visitNot(ccParser.NotContext ctx) {

	}

	String visitDisjunction(ccParser.DisjunctionContext ctx) {

	}

	String visitExpression(ccParser.ExpressionContext ctx) {

	}

	String visitConjunction(ccParser.ConjunctionContext ctx) {

	}

	String visitFunction_call(ccParser.Function_callContext ctx) {

	}

	String visitExps(ccParser.ExpsContext ctx) {

	}
	
	String visitArgs(ccParser.ArgsContext ctx) {

	}

	String visitHardwaredecl(ccParser.HardwaredeclContext ctx) {
		return "<H1>"+ctx.getText()+"</H1>"
	}

	String visitInputs(ccParser.InputsContext ctx) {
		String result = "<H2>";
		Boolean isFirst = 1;
		for (e: ctx.IDENT()) {
			if (isFirst) {
				result = result + e.getText();
				isFirst = 0;
			}
			else {
				result = result + ", " + e.getText();
			}
		}
		return result + "</H2>"
	}

	String visitOutputs(ccParser.OutputsContext ctx) {
		return "<H2>"+ctx.getText()+"</H2>"
	}

	String visitLatches(ccParser.LatchesContext ctx) {
		return "<H2>"+ctx.getText()+"</H2>"
	}

	String visitDef(ccParser.DefContext ctx) {

	}

	String visitUpdates(ccParser.UpdatesContext ctx) {

	}

	String visitSiminputs(ccParser.SiminputsContext ctx) {

	}

}

