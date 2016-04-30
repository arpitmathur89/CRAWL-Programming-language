// Generated from MyGrammar.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MyGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MyGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MyGrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(MyGrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MyGrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammarParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(MyGrammarParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MyGrammarParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammarParser#ifStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(MyGrammarParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammarParser#ifstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstatement(MyGrammarParser.IfstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammarParser#elsestat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsestat(MyGrammarParser.ElsestatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammarParser#whileStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(MyGrammarParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammarParser#displayStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisplayStat(MyGrammarParser.DisplayStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammarParser#funcCallStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallStat(MyGrammarParser.FuncCallStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammarParser#actualParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualParams(MyGrammarParser.ActualParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammarParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(MyGrammarParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammarParser#rtrnStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRtrnStat(MyGrammarParser.RtrnStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammarParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(MyGrammarParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammarParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(MyGrammarParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ADD}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitADD(MyGrammarParser.ADDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OP}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOP(MyGrammarParser.OPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BOOL}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBOOL(MyGrammarParser.BOOLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MUL}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMUL(MyGrammarParser.MULContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDEN}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDEN(MyGrammarParser.IDENContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NUM}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNUM(MyGrammarParser.NUMContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FCALL}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFCALL(MyGrammarParser.FCALLContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MyGrammarParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MyGrammarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammarParser#stacktype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStacktype(MyGrammarParser.StacktypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammarParser#stackoper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStackoper(MyGrammarParser.StackoperContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammarParser#begin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBegin(MyGrammarParser.BeginContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammarParser#end}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd(MyGrammarParser.EndContext ctx);
}