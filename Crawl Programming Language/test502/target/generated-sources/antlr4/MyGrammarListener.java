// Generated from MyGrammar.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyGrammarParser}.
 */
public interface MyGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(MyGrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(MyGrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MyGrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MyGrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(MyGrammarParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(MyGrammarParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MyGrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MyGrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(MyGrammarParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(MyGrammarParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void enterIfstatement(MyGrammarParser.IfstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void exitIfstatement(MyGrammarParser.IfstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#elsestat}.
	 * @param ctx the parse tree
	 */
	void enterElsestat(MyGrammarParser.ElsestatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#elsestat}.
	 * @param ctx the parse tree
	 */
	void exitElsestat(MyGrammarParser.ElsestatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(MyGrammarParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(MyGrammarParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#displayStat}.
	 * @param ctx the parse tree
	 */
	void enterDisplayStat(MyGrammarParser.DisplayStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#displayStat}.
	 * @param ctx the parse tree
	 */
	void exitDisplayStat(MyGrammarParser.DisplayStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#funcCallStat}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallStat(MyGrammarParser.FuncCallStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#funcCallStat}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallStat(MyGrammarParser.FuncCallStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#actualParams}.
	 * @param ctx the parse tree
	 */
	void enterActualParams(MyGrammarParser.ActualParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#actualParams}.
	 * @param ctx the parse tree
	 */
	void exitActualParams(MyGrammarParser.ActualParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(MyGrammarParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(MyGrammarParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#rtrnStat}.
	 * @param ctx the parse tree
	 */
	void enterRtrnStat(MyGrammarParser.RtrnStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#rtrnStat}.
	 * @param ctx the parse tree
	 */
	void exitRtrnStat(MyGrammarParser.RtrnStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(MyGrammarParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(MyGrammarParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(MyGrammarParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(MyGrammarParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ADD}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterADD(MyGrammarParser.ADDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ADD}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitADD(MyGrammarParser.ADDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OP}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOP(MyGrammarParser.OPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OP}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOP(MyGrammarParser.OPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BOOL}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBOOL(MyGrammarParser.BOOLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BOOL}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBOOL(MyGrammarParser.BOOLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MUL}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMUL(MyGrammarParser.MULContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MUL}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMUL(MyGrammarParser.MULContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IDEN}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIDEN(MyGrammarParser.IDENContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IDEN}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIDEN(MyGrammarParser.IDENContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NUM}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNUM(MyGrammarParser.NUMContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NUM}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNUM(MyGrammarParser.NUMContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FCALL}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFCALL(MyGrammarParser.FCALLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FCALL}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFCALL(MyGrammarParser.FCALLContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MyGrammarParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MyGrammarParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MyGrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MyGrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#stacktype}.
	 * @param ctx the parse tree
	 */
	void enterStacktype(MyGrammarParser.StacktypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#stacktype}.
	 * @param ctx the parse tree
	 */
	void exitStacktype(MyGrammarParser.StacktypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#stackoper}.
	 * @param ctx the parse tree
	 */
	void enterStackoper(MyGrammarParser.StackoperContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#stackoper}.
	 * @param ctx the parse tree
	 */
	void exitStackoper(MyGrammarParser.StackoperContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#begin}.
	 * @param ctx the parse tree
	 */
	void enterBegin(MyGrammarParser.BeginContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#begin}.
	 * @param ctx the parse tree
	 */
	void exitBegin(MyGrammarParser.BeginContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#end}.
	 * @param ctx the parse tree
	 */
	void enterEnd(MyGrammarParser.EndContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#end}.
	 * @param ctx the parse tree
	 */
	void exitEnd(MyGrammarParser.EndContext ctx);
}