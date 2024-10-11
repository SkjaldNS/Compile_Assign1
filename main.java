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
		return "<!DOCTYPE html>\n"+ "" +
				"<html><head><title>"+title+"</title>\n"+
				"<script src=\"https://polyfill.io/v3/polyfill.min.js?features=es6\"></script>\n" +
				"<script type=\"text/javascript\" id=\"MathJax-script\" async\n" +
				"src=\"https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-chtml.js\">\n" +
				"</script></head><body>\n" +
				mainText + "\n" +
				"</body></html>";
    }
}

// We write an interpreter that implements interface
// "implVisitor<T>" that is automatically generated by ANTLR
// This is parameterized over a return type "<T>" which is in our case
// simply a Double.

class Interpreter extends AbstractParseTreeVisitor<String>
		implements ccVisitor<String> {

	String visitStart(ccParser.StartContext ctx) {
		// Implementation needed
		List<String> ps = new ArrayList<String>();
		for(ccParser.CmdContext i : ctx.cs) {
			ps.add((String) visit(ps));
		}
		return new Sequence(ps);
	}

	String visitSignal(ccParser.SignalContext ctx) {

	}

	String visitNot(ccParser.NotContext ctx) {

	}

	String visitDisjunction(ccParser.DisjunctionContext ctx) {

	}

	String visitExpression(ccParser.ExpressionContext ctx) {
		// Implementation needed
		return null;
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

	}

	String visitInputs(ccParser.InputsContext ctx) {

	}

	String visitOutputs(ccParser.OutputsContext ctx) {
	
	}

	String visitLatches(ccParser.LatchesContext ctx) {

	}

	String visitDef(ccParser.DefContext ctx) {
		// Implementation needed
		return null;
	}

	String visitUpdates(ccParser.UpdatesContext ctx) {

	}

	String visitSiminputs(ccParser.SiminputsContext ctx) {

	}
}
