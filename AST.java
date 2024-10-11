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

    Signal s;

    Hardware(Signal s) {
        this.s = s;
    }

    @Override
    public String eval() {
        return "<H1>" + s.eval() + "</H1>\n";
    }
}

class Input extends Line {

    Signal s;

    Input(Signal s) {
        this.s = s;
    }
    @Override
    public String eval() {
        return "<H2> Inputs </H2>\n"+s.eval()+"\n";
    }

}

class Output extends Line {

    Signal s;

    Output(Signal s) {
        this.s = s;
    }

    @Override
    public String eval() {
        return "<H2> Outputs </H2>\n"+ s.eval()+"\n";
    }

}

class Latch extends Line {

    Signal s;

    Latch(Signal s) {
        this.s = s;
    }

    @Override
    public String eval() {
        return "<H2> Latches </H2>\n"+ s.eval()+"\n";
    }

}

class Def extends Line {

    Exp e;
    Signal s;
    Args a;

    Def(Exp e, Signal s, Args a) {
        this.e = e;
        this.s = s;
        this.a = a;
    }

    @Override
    public String eval() {
	return "<H2> Def </H2>\n\\(\\mathit{"+ s.eval() + "} ("+ a.eval() + ")=("
            + e.eval()+")\\)<br>";
    }


}

class Update extends Line {

    Signal s;
    Exp e;

    Update(Signal s, Exp e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public String eval() {
        return "<H2> Updates </H2>\n"+ s.eval()+"&larr;\\(\\mathit{"
                +e.eval()+"\n";
    }


}

class SimInput extends Line {

    Signal s;
    Boolean b;

    SimInput(Signal s, Boolean b) {
        this.s = s;
        this.b = b;
    }

    @Override
    public String eval() {
	    return "<H2> Simulation Inputs </H2>\n"+ s.eval() + b + "\n";
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

class FunctionCall extends Exp {

    Signal s;
    Exps e;

    FunctionCall(Signal s, Exps e) {
        this.s = s;
        this.e = e;
    }


    @Override
    public String eval() {
        return s.eval()+e.eval();
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
	List<String> list;

	Args(List<String> l) {
		this.list = l;
	}

	public String eval() {
		return String.join(", ", list);
			
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

