// Generated from cc.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ccParser}.
 */
public interface ccListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ccParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ccParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ccParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ccParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Signal}
	 * labeled alternative in {@link ccParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterSignal(ccParser.SignalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Signal}
	 * labeled alternative in {@link ccParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitSignal(ccParser.SignalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ccParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterNot(ccParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ccParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitNot(ccParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link ccParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterDisjunction(ccParser.DisjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link ccParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitDisjunction(ccParser.DisjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Expression}
	 * labeled alternative in {@link ccParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ccParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Expression}
	 * labeled alternative in {@link ccParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ccParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Conjunction}
	 * labeled alternative in {@link ccParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(ccParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Conjunction}
	 * labeled alternative in {@link ccParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(ccParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Function_call}
	 * labeled alternative in {@link ccParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(ccParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Function_call}
	 * labeled alternative in {@link ccParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(ccParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link ccParser#exps}.
	 * @param ctx the parse tree
	 */
	void enterExps(ccParser.ExpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ccParser#exps}.
	 * @param ctx the parse tree
	 */
	void exitExps(ccParser.ExpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ccParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(ccParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ccParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(ccParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ccParser#hardwaredecl}.
	 * @param ctx the parse tree
	 */
	void enterHardwaredecl(ccParser.HardwaredeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ccParser#hardwaredecl}.
	 * @param ctx the parse tree
	 */
	void exitHardwaredecl(ccParser.HardwaredeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ccParser#inputs}.
	 * @param ctx the parse tree
	 */
	void enterInputs(ccParser.InputsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ccParser#inputs}.
	 * @param ctx the parse tree
	 */
	void exitInputs(ccParser.InputsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ccParser#outputs}.
	 * @param ctx the parse tree
	 */
	void enterOutputs(ccParser.OutputsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ccParser#outputs}.
	 * @param ctx the parse tree
	 */
	void exitOutputs(ccParser.OutputsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ccParser#latches}.
	 * @param ctx the parse tree
	 */
	void enterLatches(ccParser.LatchesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ccParser#latches}.
	 * @param ctx the parse tree
	 */
	void exitLatches(ccParser.LatchesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ccParser#def}.
	 * @param ctx the parse tree
	 */
	void enterDef(ccParser.DefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ccParser#def}.
	 * @param ctx the parse tree
	 */
	void exitDef(ccParser.DefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ccParser#updates}.
	 * @param ctx the parse tree
	 */
	void enterUpdates(ccParser.UpdatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ccParser#updates}.
	 * @param ctx the parse tree
	 */
	void exitUpdates(ccParser.UpdatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ccParser#siminputs}.
	 * @param ctx the parse tree
	 */
	void enterSiminputs(ccParser.SiminputsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ccParser#siminputs}.
	 * @param ctx the parse tree
	 */
	void exitSiminputs(ccParser.SiminputsContext ctx);
}