package br.ufpe.cin.if688.minijava.gen;// Generated from C:/Users/User/Desktop/MiniJava-master (copy)\pbv2.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link pbv2Parser}.
 */
public interface pbv2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link pbv2Parser#goal}.
	 * @param ctx the parse tree
	 */
	void enterGoal(pbv2Parser.GoalContext ctx);
	/**
	 * Exit a parse tree produced by {@link pbv2Parser#goal}.
	 * @param ctx the parse tree
	 */
	void exitGoal(pbv2Parser.GoalContext ctx);
	/**
	 * Enter a parse tree produced by {@link pbv2Parser#mainClass}.
	 * @param ctx the parse tree
	 */
	void enterMainClass(pbv2Parser.MainClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link pbv2Parser#mainClass}.
	 * @param ctx the parse tree
	 */
	void exitMainClass(pbv2Parser.MainClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link pbv2Parser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(pbv2Parser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link pbv2Parser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(pbv2Parser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link pbv2Parser#classDeclSimple}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclSimple(pbv2Parser.ClassDeclSimpleContext ctx);
	/**
	 * Exit a parse tree produced by {@link pbv2Parser#classDeclSimple}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclSimple(pbv2Parser.ClassDeclSimpleContext ctx);
	/**
	 * Enter a parse tree produced by {@link pbv2Parser#classDeclExtends}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclExtends(pbv2Parser.ClassDeclExtendsContext ctx);
	/**
	 * Exit a parse tree produced by {@link pbv2Parser#classDeclExtends}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclExtends(pbv2Parser.ClassDeclExtendsContext ctx);
	/**
	 * Enter a parse tree produced by {@link pbv2Parser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(pbv2Parser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link pbv2Parser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(pbv2Parser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link pbv2Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(pbv2Parser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link pbv2Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(pbv2Parser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link pbv2Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(pbv2Parser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link pbv2Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(pbv2Parser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link pbv2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(pbv2Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link pbv2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(pbv2Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link pbv2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(pbv2Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link pbv2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(pbv2Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link pbv2Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(pbv2Parser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link pbv2Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(pbv2Parser.IdentifierContext ctx);
}