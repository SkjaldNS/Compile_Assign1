import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.CharStreams;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AST{};

abstract class Program extends AST{
    abstract public String eval();
}

abstract class Exp extends AST{
    abstract public String eval();
}


class Start extends Program {
	
    List<Program> ps;

    Start(List<Program> ps) {
        this.ps = ps;
    }

    @Override
    public String eval() {
	String result;
        for (Prograp p: ps){
		result = result + p.eval;
	}
	return result;
    }
}



class Hardware extends Program {

    Signal s;

    Hardware(Signal s) {
        this.s = s;
    }

    @Override
    public String eval() {
        return s.eval();
    }
}

class Input extends Program {

    Signal s;

    Input(Signal s) {
        this.s = s;
    }
    @Override
    public String eval() {
        return s.eval();
    }

}

class Output extends Program {

    Signal s;

    Output(Signal s) {
        this.s = s;
    }

    @Override
    public String eval() {
        return s.eval();
    }

}

class Latch extends Program {

    Signal s;

    Latch(Signal s) {
        this.s = s;
    }

    @Override
    public String eval() {
        return s.eval();
    }

}

class Def extends Program {

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

class Update extends Program {

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

class SimInput extends Program {

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

class Arg extends Program {

    List<Signal> ls;

    Arg(List<Signal> ls) {
        this.ls = ls;
    }

    @Override
    public String eval() {
	String result;    
	for (Signal s: ls){
		result = result + s.eval();
	}
	return result;
    }
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
