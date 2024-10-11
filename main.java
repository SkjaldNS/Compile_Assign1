import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.CharStreams;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

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
	Line result=(Line)interpreter.visit(parseTree);
	String output = result.eval();
	try {
		File html = new File("output.html");
		if(html.createNewFile()){
			FileWriter writer = new FileWriter("output.html");
			writer.write(output);
			writer.close();
			System.out.println("output.html created.");
		}
		else {
			System.out.println("File could not be created.");
		}
	}
	catch (IOException e) {
		System.out.println("An error occured.");
		e.printStackTrace();
	}
    }
}

// We write an interpreter that implements interface
// "implVisitor<T>" that is automatically generated by ANTLR
// This is parameterized over a return type "<T>" which is in our case
// simply a Double.

class Interpreter extends AbstractParseTreeVisitor<AST>
		implements ccVisitor<AST> {

	AST visitStart(ccParser.StartContext ctx) {
		List<Line> ps = new ArrayList<Line>();
		for(ccParser.LineContext i : ctx.cs) {
			ps.add((Line) visit(i));
		}
		return new Sequence(ps);
	}

	AST visitHardware(ccParser.HardwareContext ctx) {
		return new Hardware((Signal) visit(ctx.x));
	}

	AST visitInput(ccParser.InputContext ctx) {
		return new Input((Args) visit(ctx.l));
	}

	AST visitOutput(ccParser.OutputContext ctx) {
		return new Output((Args) visit(ctx.l));
	}

	AST visitLatch(ccParser.LatchContext ctx) {
		return new Latch((Args) visit(ctx.l));
	}

	AST visitDef(ccParser.DefContext ctx) {
		return new Def((Signal) visit(ctx.i), (Args) visit(ctx.l), (Exp) visit(ctx.e));
	}

	AST visitUpdate(ccParser.UpdateContext ctx) {
		return new Update((Signal) visit(ctx.i), (Exp) visit(ctx.e));
	}

	AST visitSiminput(ccParser.SiminputContext ctx) {
		return new Siminput((Signal) visit(ctx.i), (Boolean) visit(ctx.b));
	}

	AST visitSignal(ccParser.SignalContext ctx) {
		return new Signal(ctx.x.getText());
	}

	AST visitNot(ccParser.NotContext ctx) {
		return new Not((Exp) visit(ctx.e));
	}

	AST visitConjunction(ccParser.ConjunctionContext ctx) {
		return new Conjunction((Exp) visit(ctx.e1), (Exp) visit(ctx.e2));
	}

	AST visitDisjunction(ccParser.DisjunctionContext ctx) {
		return new Disjunction((Exp) visit(ctx.e1), (Exp) visit(ctx.e2));
	}

	AST visitExpression(ccParser.ExpressionContext ctx) {
		return new Expression((Exp) visit(ctx.e));
	}

	AST visitFunction_call(ccParser.Function_callContext ctx) {
		return new FunctionCall((Signal) visit(ctx.i.getText()), (Exps) visit(ctx.x));
	}

	AST visitArgs(ccParser.ArgsContext ctx) {
		List<String> l = new ArrayList<String>();
		for(ccParser.ArgContext i : ctx) {
			l.add(i.getText());
		}
		return new Args(l);
	}


	AST visitExps(ccParser.ExpsContext ctx) {
		List<Exp> l = new ArrayList<Exp>();
		for(ccParser.ExpContext i : ctx) {
			l.add((Exp) visit(i));
		}
		return new Exps(l);
	}

}
