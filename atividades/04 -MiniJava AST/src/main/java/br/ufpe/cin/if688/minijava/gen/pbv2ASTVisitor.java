package br.ufpe.cin.if688.minijava.gen;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import br.ufpe.cin.if688.minijava.gen.pbv2Parser.ClassDeclExtendsContext;
import br.ufpe.cin.if688.minijava.gen.pbv2Parser.ClassDeclSimpleContext;
import br.ufpe.cin.if688.minijava.gen.pbv2Parser.ClassDeclarationContext;
import br.ufpe.cin.if688.minijava.gen.pbv2Parser.ExpressionContext;
import br.ufpe.cin.if688.minijava.gen.pbv2Parser.GoalContext;
import br.ufpe.cin.if688.minijava.gen.pbv2Parser.IdentifierContext;
import br.ufpe.cin.if688.minijava.gen.pbv2Parser.MainClassContext;
import br.ufpe.cin.if688.minijava.gen.pbv2Parser.MethodDeclarationContext;
import br.ufpe.cin.if688.minijava.gen.pbv2Parser.StatementContext;
import br.ufpe.cin.if688.minijava.gen.pbv2Parser.TypeContext;
import br.ufpe.cin.if688.minijava.gen.pbv2Parser.VarDeclarationContext;
import br.ufpe.cin.if688.minijava.ast.And;
import br.ufpe.cin.if688.minijava.ast.ArrayAssign;
import br.ufpe.cin.if688.minijava.ast.ArrayLength;
import br.ufpe.cin.if688.minijava.ast.ArrayLookup;
import br.ufpe.cin.if688.minijava.ast.Assign;
import br.ufpe.cin.if688.minijava.ast.Block;
import br.ufpe.cin.if688.minijava.ast.BooleanType;
import br.ufpe.cin.if688.minijava.ast.Call;
import br.ufpe.cin.if688.minijava.ast.ClassDecl;
import br.ufpe.cin.if688.minijava.ast.ClassDeclExtends;
import br.ufpe.cin.if688.minijava.ast.ClassDeclList;
import br.ufpe.cin.if688.minijava.ast.ClassDeclSimple;
import br.ufpe.cin.if688.minijava.ast.Exp;
import br.ufpe.cin.if688.minijava.ast.ExpList;
import br.ufpe.cin.if688.minijava.ast.False;
import br.ufpe.cin.if688.minijava.ast.Formal;
import br.ufpe.cin.if688.minijava.ast.FormalList;
import br.ufpe.cin.if688.minijava.ast.Identifier;
import br.ufpe.cin.if688.minijava.ast.IdentifierType;
import br.ufpe.cin.if688.minijava.ast.IdentifierExp;
import br.ufpe.cin.if688.minijava.ast.If;
import br.ufpe.cin.if688.minijava.ast.IntArrayType;
import br.ufpe.cin.if688.minijava.ast.IntegerLiteral;
import br.ufpe.cin.if688.minijava.ast.IntegerType;
import br.ufpe.cin.if688.minijava.ast.LessThan;
import br.ufpe.cin.if688.minijava.ast.MainClass;
import br.ufpe.cin.if688.minijava.ast.MethodDecl;
import br.ufpe.cin.if688.minijava.ast.MethodDeclList;
import br.ufpe.cin.if688.minijava.ast.Minus;
import br.ufpe.cin.if688.minijava.ast.NewArray;
import br.ufpe.cin.if688.minijava.ast.NewObject;
import br.ufpe.cin.if688.minijava.ast.Not;
import br.ufpe.cin.if688.minijava.ast.Plus;
import br.ufpe.cin.if688.minijava.ast.Print;
import br.ufpe.cin.if688.minijava.ast.Program;
import br.ufpe.cin.if688.minijava.ast.Statement;
import br.ufpe.cin.if688.minijava.ast.StatementList;
import br.ufpe.cin.if688.minijava.ast.This;
import br.ufpe.cin.if688.minijava.ast.Times;
import br.ufpe.cin.if688.minijava.ast.True;
import br.ufpe.cin.if688.minijava.ast.Type;
import br.ufpe.cin.if688.minijava.ast.VarDecl;
import br.ufpe.cin.if688.minijava.ast.VarDeclList;
import br.ufpe.cin.if688.minijava.ast.While;

public class pbv2ASTVisitor implements pbv2Visitor<Object> {

    @Override
    public Object visit(ParseTree tree) {
        return tree.accept(this);
    }

    @Override
    public Object visitChildren(RuleNode node) {
        return null;
    }

    @Override
    public Object visitTerminal(TerminalNode node) {
        return null;
    }

    @Override
    public Object visitErrorNode(ErrorNode node) {
        return null;
    }

    @Override
    public Object visitGoal(GoalContext ctx) {
        MainClass mainClass = (MainClass) ctx.mainClass().accept(this);
        ClassDeclList cdl = new ClassDeclList();

        for (ClassDeclarationContext cdc : ctx.classDeclaration()) {
            cdl.addElement((ClassDecl) cdc.accept(this));
        }

        return new Program(mainClass, cdl);
    }

    @Override
    public Object visitMainClass(MainClassContext ctx) {
        Identifier id1 = (Identifier) ctx.identifier(0).accept(this);
        Identifier id2 = (Identifier) ctx.identifier(1).accept(this);

        Statement stm = (Statement) ctx.statement().accept(this);

        return new MainClass(id1, id2, stm);
    }

    @Override
    public Object visitClassDeclaration(ClassDeclarationContext ctx) {
        if(ctx.classDeclSimple() == null) {
            return ctx.classDeclExtends().accept(this);
        }else {
            return ctx.classDeclSimple().accept(this);
        }
    }

    @Override
    public Object visitClassDeclSimple(ClassDeclSimpleContext ctx) {
        Identifier id = (Identifier) ctx.identifier().accept(this);
        VarDeclList dc = new VarDeclList();
        for (VarDeclarationContext v : ctx.varDeclaration()) {
            dc.addElement((VarDecl) v.accept(this));
        }
        MethodDeclList ml = new MethodDeclList();
        for(MethodDeclarationContext d : ctx.methodDeclaration()) {
            ml.addElement((MethodDecl) d.accept(this)) ;
        }
        return new ClassDeclSimple(id, dc, ml);
    }

    @Override
    public Object visitClassDeclExtends(ClassDeclExtendsContext ctx) {
        Identifier id =  (Identifier) ctx.identifier(0).accept(this);
        Identifier id2 =  (Identifier) ctx.identifier(1).accept(this);
        VarDeclList dc = new VarDeclList();
        for (VarDeclarationContext v : ctx.varDeclaration()) {
            dc.addElement((VarDecl) v.accept(this));
        }
        MethodDeclList ml = new MethodDeclList();
        for(MethodDeclarationContext d : ctx.methodDeclaration()) {
            ml.addElement((MethodDecl) d.accept(this)) ;
        }
        return new ClassDeclExtends(id,id2, dc, ml);

    }

    @Override
    public Object visitVarDeclaration(VarDeclarationContext ctx) {
        Type type = (Type) ctx.type().accept(this);
        Identifier id = (Identifier) ctx.identifier().accept(this);

        return new VarDecl(type, id);
    }

    @Override
    public Object visitMethodDeclaration(MethodDeclarationContext ctx) {
        Type type = (Type) ctx.type(0).accept(this);
        Identifier id = (Identifier) ctx.identifier(0).accept(this);

        FormalList fl = new FormalList();
        for (int i = 1; i < ctx.type().size(); i++) {
            fl.addElement(new Formal((Type) ctx.type(i).accept(this), (Identifier) ctx.identifier(i).accept(this)));
        }

        VarDeclList vdl = new VarDeclList();
        for (VarDeclarationContext vdc : ctx.varDeclaration()) {
            vdl.addElement((VarDecl) vdc.accept(this));
        }

        StatementList sl = new StatementList();
        for (StatementContext sc : ctx.statement()) {
            sl.addElement((Statement) sc.accept(this));
        }

        Object aux = ctx.expression().accept(this);
        Exp exp;
        if(aux instanceof Exp) {
            exp = (Exp) ctx.expression().accept(this);
        } else {
            exp = new IdentifierExp(ctx.expression().getText());
        }

        return new MethodDecl(type, id, fl, vdl, sl, exp);
    }

    @Override
    public Object visitType(TypeContext ctx) {
        String value = ctx.getText();

        if(value.equals("int")){
            return new IntegerType();
        }else if(value.equals("int[]")){
            return new IntArrayType();
        }else if(value.equals("boolean")){
            return new BooleanType();
        }else{
            return new IdentifierType(value);
        }
    }

    @Override
    public Object visitStatement(StatementContext ctx) {
        String start = ctx.getStart().getText();

        if (start.equalsIgnoreCase("{")) {
            StatementList sl = new StatementList();

            for (StatementContext sc : ctx.statement()) {
                sl.addElement((Statement) sc.accept(this));
            }

            return new Block(sl);
        } else if (start.equalsIgnoreCase("if")) {

            Object aux = ctx.expression(0).accept(this);
            Exp exp;
            if(aux instanceof Exp) {
                exp = (Exp) aux;
            } else {
                exp = new IdentifierExp(ctx.expression(0).getText());
            }

            Statement stm1_if = (Statement) ctx.statement(0).accept(this);
            Statement stm2_if = (Statement) ctx.statement(1).accept(this);

            return new If(exp,stm1_if,stm2_if);

        } else if (start.equalsIgnoreCase("while")) {

            Object aux = ctx.expression(0).accept(this);
            Exp exp;
            if(aux instanceof Exp) {
                exp = (Exp) aux;
            } else {
                exp = new IdentifierExp(ctx.expression(0).getText());
            }
            Statement stm_w = (Statement) ctx.statement(0).accept(this);

            return new While(exp, stm_w);

        } else if (start.equalsIgnoreCase("System.out.println")) {
            Exp exp = (Exp) ctx.expression(0).accept(this);

            return new Print(exp);

        } else if (ctx.expression().size() == 1) {
            Identifier id = (Identifier) ctx.identifier().accept(this);

            Object aux = ctx.expression(0).accept(this);
            Exp exp;
            if(aux instanceof Exp) {
                exp = (Exp)aux;
            } else {
                exp =  new IdentifierExp(ctx.expression(0).getText());
            }

            return new Assign(id, exp);
        } else {
            Identifier id = (Identifier) ctx.identifier().accept(this);

            Object aux1 = ctx.expression(0).accept(this);
            Object aux2 = ctx.expression(1).accept(this);
            Exp exp1,exp2;
            if(aux1 instanceof Exp) {
                exp1 = (Exp)aux1;
            } else {
                exp1 =  new IdentifierExp(ctx.expression(0).getText());
            }

            if(aux2 instanceof Exp) {
                exp2 = (Exp) aux2;
            } else {
                exp2 =  new IdentifierExp(ctx.expression(1).getText());
            }

            return new ArrayAssign(id, exp1, exp2);
        }
    }

    @Override
    public Object visitExpression(ExpressionContext ctx) {
        int expAmount = ctx.expression().size();
        int childAmount = ctx.getChildCount();
        String start = ctx.getStart().getText();

        if (childAmount >= 5 && ctx.getChild(1).getText().equals(".")) {
            Object exp = ctx.expression(0).accept(this);
            Identifier id = (Identifier) ctx.identifier().accept(this);

            ExpList el = new ExpList();
            for (int i = 1; i < ctx.expression().size(); i++) {
                Object aux = ctx.expression(i).accept(this);
                if(aux instanceof Exp) el.addElement((Exp) aux);
                else {
                    IdentifierExp ie = new IdentifierExp(ctx.expression(i).getText());
                    el.addElement(ie);
                }
            }
            if(exp instanceof Exp) {
                Exp aux = (Exp)exp;
                return new Call(aux, id, el);
            } else {
                IdentifierExp ie = new IdentifierExp(ctx.expression(0).getText());
                return new Call(ie, id, el);
            }
        }

        if (expAmount == 2) {
            Object aux1 = ctx.expression(0).accept(this);
            Object aux2 = ctx.expression(1).accept(this);
            Exp exp1, exp2;
            if(aux1 instanceof Exp) {
                exp1 = (Exp) aux1;
            } else {
                exp1 = new IdentifierExp(ctx.expression(0).getText());
            }
            if(aux2 instanceof Exp) {
                exp2 = (Exp) aux2;
            } else {
                exp2 = new IdentifierExp(ctx.expression(1).getText());
            }
            String op = ctx.getChild(1).getText();

            if (childAmount == 3) {
                if(op.equals("&&")){
                    return new And(exp1, exp2);
                }else if(op.equals("<")){
                    return new LessThan(exp1, exp2);
                }else if(op.equals("+")){
                    return new Plus(exp1, exp2);
                }else if(op.equals("-")){
                    return new Minus(exp1, exp2);
                }else{
                    return new Times(exp1, exp2);
                }
            } else {
                return new ArrayLookup(exp1, exp2);
            }
        } else if (expAmount == 1) {
            Object exp = ctx.expression(0).accept(this);
            Exp aux;
            if(exp instanceof Exp) {
                aux = (Exp)exp;
            } else {
                aux = new IdentifierExp(ctx.expression(0).getText());
            }

            if (start.equals("!")) {
                return new Not(aux);
            } else if (start.equals("(")) {
                return aux;
            } else if (start.equals("new")) {
                return new NewArray(aux);
            } else {
                return new ArrayLength(aux);
            }
        } else if (start.equals("new")) {
            return new NewObject((Identifier) ctx.identifier().accept(this));
        } else if (start.equals("this")) {
            return new This();
        } else if (start.endsWith("true")) {
            return new True();
        } else if (start.endsWith("false")) {
            return new False();
        } else if (start.matches("\\d+")) {
            return new IntegerLiteral (Integer.parseInt(ctx.start.getText()));
        } else {
            return (Identifier) ctx.identifier().accept(this);
        }
    }

    @Override
    public Object visitIdentifier(IdentifierContext ctx) {
        return new Identifier(ctx.getText());
    }
}
