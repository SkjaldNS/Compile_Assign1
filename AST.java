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

}

class Output extends Program {

}

class Latch extends Program {

}

class Def extends Program {

}

class Update extends Program {

}

class SimInput extends Program {

}

class Signal extends Exp {

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

}

class Disjunction extends Exp {

}

class FunctionCall extends Exp {

}

class Expression extends Exp {

}
