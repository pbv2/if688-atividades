package br.ufpe.cin.if688.minijava.gen;// Generated from C:/Users/User/Desktop/MiniJava-master (copy)\pbv2.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link pbv2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface pbv2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link pbv2Parser#goal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoal(pbv2Parser.GoalContext ctx);
	/**
	 * Visit a parse tree produced by {@link pbv2Parser#mainClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainClass(pbv2Parser.MainClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link pbv2Parser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(pbv2Parser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link pbv2Parser#classDeclSimple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclSimple(pbv2Parser.ClassDeclSimpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link pbv2Parser#classDeclExtends}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclExtends(pbv2Parser.ClassDeclExtendsContext ctx);
	/**
	 * Visit a parse tree produced by {@link pbv2Parser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(pbv2Parser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link pbv2Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(pbv2Parser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link pbv2Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(pbv2Parser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link pbv2Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(pbv2Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link pbv2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(pbv2Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link pbv2Parser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(pbv2Parser.IdentifierContext ctx);
}