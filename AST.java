import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.CharStreams;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AST{};

abstract class Line extends AST{
    abstract public String eval();
}


class Sequence extends Line {
	
    List<Line> ps;
    Sequence(List<Line> ps) {
        this.ps = ps;
    }

    @Override
    public String eval() {
	String result = "";
        for (Line p: ps){
		result = result + p.eval();
	}
	return "<!DOCTYPE html>"
		+ "<html><head><title>HDL0</title>"
		+ "<script src=\"https://polyfill.io/v3/polyfill.min.js?features=es6\"></script>"
		+ "<script type=\"text/javascript\" id=\"MathJax-script\""
		+ "async"
		+ "src=\"https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-chtml.js\">"
		+ "</script></head><body>"
		+ result 
		+ "</body></html>";
    }
}



class Hardware extends Line {

    String s;

    Hardware(String s) {
        this.s = s;
    }

    @Override
    public String eval() {
        return "<H1>" + s + "</H1>\n";
    }
}

class Input extends Line {

    Args s;

    Input(Args s) {
        this.s = s;
    }
    @Override
    public String eval() {
        return "<H2> Inputs </H2>\n"+s.eval()+"\n";
    }

}

class Output extends Line {

    Args s;

    Output(Args s) {
        this.s = s;
    }

    @Override
    public String eval() {
        return "<H2> Outputs </H2>\n"+ s.eval()+"\n";
    }

}

class Latch extends Line {

    Args s;

    Latch(Args s) {
        this.s = s;
    }

    @Override
    public String eval() {
        return "<H2> Latches </H2>\n"+ s.eval()+"\n";
    }

}

class Def extends Line {

    Exp e;
    String s;
    Args a;

    Def(String s, Args a, Exp e) {
        this.s = s;
        this.a = a;
        this.e = e;
    }

    @Override
    public String eval() {
	return "<H2> Def </H2>\n\\(\\mathit{"+ s + "} ("+ a.eval() + ")=("
            + e.eval()+")\\)<br>";
    }


}

class Update extends Line {

    String s;
    Exp e;

    Update(String s, Exp e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public String eval() {
        return "<H2> Updates </H2>\n"+ s +"&larr;\\(\\mathit{"
                +e.eval()+"\n";
    }


}

class SimInput extends Line {

    String s;
    String b;

    SimInput(String s, String b) {
        this.s = s;
        this.b = b;
    }

    @Override
    public String eval() {
	    return "<H2> Simulation Inputs </H2>\n"+ s + b + "\n";
    }

}

abstract class Exp extends AST{
    abstract public String eval();
}

class Signal extends Exp {

    String name;

    Signal(String name) {
        this.name = name;
    }

    @Override
    public String eval() {
        return "\\mathrm{" + name + "}";
    }


}

class Not extends Exp {
    Exp e;

    Not(Exp e) {
        this.e = e;
    }

    @Override
    public String eval() {
        return "(\\neg(" + e.eval() + ")";
    }
}

class Conjunction extends Exp {

    Exp e1;
    Exp e2;

    Conjunction(Exp e1, Exp e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public String eval() {
        return  e1.eval()+ "\\wedge" + e2.eval();
    }


}

class Disjunction extends Exp {

    Exp e1;
    Exp e2;

    Disjunction(Exp e1, Exp e2) {
        this.e1 = e1;
        this.e2 = e2;
    }


    @Override
    public String eval() {
        return e1.eval()+ "\\vee" + e2.eval();
    }

}

class Function_call extends Exp {

    String s;
    Exps e;

    Function_call(String s, Exps e) {
        this.s = s;
        this.e = e;
    }


    @Override
    public String eval() {
        return s + e.eval();
    }


}

class Expression extends Exp {

    Exp e;

    Expression(Exp e) {
        this.e = e;
    }


    @Override
    public String eval() {
        return "(" + e.eval() + ")";
    }


}

class Args extends AST {
	String s;

	Args(String s) {
		this.s = s;
	}

	public String eval() {
		return s;
			
	}
}

class Exps extends AST  {
	List<Exp> list;

	Exps(List<Exp> l) {
		this.list = l;
	}

	public String eval() {
		List<String> ls = new ArrayList<String>();
		for(Exp e: list) {
			ls.add(e.eval());
		}
		return "(" + String.join(", ", ls) + ")";
	}
}

