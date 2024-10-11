// Generated from cc.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ccParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ccVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ccParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ccParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Signal}
	 * labeled alternative in {@link ccParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignal(ccParser.SignalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ccParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(ccParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link ccParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunction(ccParser.DisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Expression}
	 * labeled alternative in {@link ccParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ccParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Conjunction}
	 * labeled alternative in {@link ccParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(ccParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Function_call}
	 * labeled alternative in {@link ccParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(ccParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ccParser#exps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExps(ccParser.ExpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ccParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(ccParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ccParser#hardwaredecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHardware(ccParser.HardwareContext ctx);
	/**
	 * Visit a parse tree produced by {@link ccParser#inputs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(ccParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by {@link ccParser#outputs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput(ccParser.OutputContext ctx);
	/**
	 * Visit a parse tree produced by {@link ccParser#latches}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLatch(ccParser.LatchContext ctx);
	/**
	 * Visit a parse tree produced by {@link ccParser#def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef(ccParser.DefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ccParser#updates}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate(ccParser.UpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ccParser#siminputs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimInput(ccParser.SimInputContext ctx);
}
