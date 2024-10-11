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
	String result;
        for (Line p: ps){
		result = result + p.eval;
	}
	return result;
    }
}



class Hardware extends Line {

    Signal s;

    Hardware(Signal s) {
        this.s = s;
    }

    @Override
    public String eval() {
        return s.eval();
    }
}

class Input extends Line {

    Signal s;

    Input(Signal s) {
        this.s = s;
    }
    @Override
    public String eval() {
        return s.eval();
    }

}

class Output extends Line {

    Signal s;

    Output(Signal s) {
        this.s = s;
    }

    @Override
    public String eval() {
        return s.eval();
    }

}

class Latch extends Line {

    Signal s;

    Latch(Signal s) {
        this.s = s;
    }

    @Override
    public String eval() {
        return s.eval();
    }

}

class Def extends Line {

    Exp e;
    Signal s;
    Arg a;

    Def(Exp e, Signal s, Arg a) {
        this.e = e;
        this.s = s;
        this.a = a;
    }

    @Override
    public String eval() {
	return s.eval()+a.eval()+e.eval()
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
        return s.eval()+e.eval()
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
	s.eval()
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
        return name;
    }


}

class Not extends Exp {
    Exp e;

    Not(Exp e) {
        this.e = e;
    }

    @Override
    public String eval() {
        return e.eval();
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
        return e1.eval()+e2.eval();
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
        return e1.eval()+e2.eval();
    }

}

class FunctionCall extends Exp {

    Signal s;
    Expression e;

    FunctionCall(Signal s, Expression e) {
        this.s = s;
        this.e = e;
    }


    @Override
    public String eval() {
        return s.eval()+e.eval();
    }


}

class Expression extends Exp {

    Exp e1;

    Expression(Exp e) {
        this.e = e;
    }


    @Override
    public String eval() {
        return e.eval();
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
		List<String> ls;
		for(Exp e: list) {
			ls.add(e.eval());
		}
		return String.join(", ", ls);
	}
}

