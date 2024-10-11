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
        String result = "";
        for (Program p : ps) {
            result += p.eval();
        }
        return result;
    }
}

class Hardware extends Program {
    String name;

    Hardware(String name) {
        this.name = name;
    }

    @Override
    public String eval() {
        return result;
    }
}

class Input extends Program {

    @Override
    public String eval() {
        return "<H2>" + String.join(",", inputs) + "</H2>";
    }

}

class Output extends Program {

    @Override
    public String eval() {
        return "<H2>" + String.join(",", outputs) + "</H2>";
    }

}

class Latch extends Program {

    @Override
    public String eval() {
        List<String> latches = new ArrayList<>();
		for (ccParser.LatchContext i : ctx.IDENT()) {
			latches.add(i.getText());
		}
		return "<H2>" + String.join(",", latches) + "</H2>";
    }

}

class Def extends Program {

    @Override
    public String eval() {

    }


}

class Update extends Program {

    @Override
    public String eval() {
        return ctx.e.visitSignal().getText() + "&larr" + ctx.e.visitExp().getText();
    }


}

class SimInput extends Program {


    @Override
    public String eval() {
        List<String> siminputs = new ArrayList<>();
		for (ccParser.SiminputContext i : ctx.IDENT()) {
			siminputs.add(i.getText());
		}
		return "<H2>" + String.join(",", siminputs) + "</H2>";
    }

}

class Arg extends Program {

    @Override
    public String eval() [

    }
}

class Signal extends Exp {

    @Override
    public String eval() {
        return ctx.getText();
    }


}

class Not extends Exp {
    Exp e;

    Not(Exp e) {
        this.e = e;
    }

    @Override
    public String eval() {
        return "(\\neg" + e.eval() + ")";
    }
}

class Conjunction extends Exp {

    @Override
    public String eval() {
        return ctx.e1.visitExp() + "\\wedge" + ctx.e2.visitExp();
    }


}

class Disjunction extends Exp {


    @Override
    public String eval() {
        return ctx.e1.visitExp() + "\\vee" + ctx.e2.visitExp();
    }

}

class FunctionCall extends Exp {


    @Override
    public String eval() {
        return ctx.IDENT().getText() + "(" + ctx.exps().visitExps() + ")";
    }


}

class Expression extends Exp {


    @Override
    public String eval() {
        List<String> exps = new ArrayList<>();
		for (ccParser.ExpContext i : ctx.exp()) {
			exps.add(i.getText());
		}
		return "<H2>" + String.join(",", exps) + "</H2>";
    }


}
