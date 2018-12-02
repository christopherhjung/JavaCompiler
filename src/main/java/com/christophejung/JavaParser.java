package com.christophejung;

import com.christophejung.classexpressions.ClassDeclareAssign;
import com.christophejung.classexpressions.ClassExpression;
import com.christophejung.classexpressions.MethodContainer;
import com.christophejung.methodexpressions.*;
import com.christophejung.statements.*;
import com.christopherjung.reflectparser.*;

import java.beans.Expression;
import java.util.ArrayList;
import java.util.List;

public class JavaParser
{
    @ScannerSingle
    public static String structureChars = "[](){},:;*/";

    @ScannerToken("||")
    public static String booleanOr = "\\|\\|";

    @ScannerToken("|")
    public static String bitwiseOr = "\\|";

    @ScannerToken("&&")
    public static String booleanAnd = "\\&\\&";

    @ScannerToken("&")
    public static String bitwiseAnd = "\\&";

    @ScannerToken("++")
    public static String increment = "\\+\\+";

    @ScannerToken("+")
    public static String add = "\\+";

    @ScannerToken("--")
    public static String decrement = "\\-\\-";

    @ScannerToken("-")
    public static String sub = "\\-";

    @ScannerToken("==")
    public static String equals = "==";

    @ScannerToken("!=")
    public static String notEquals = "!=";

    @ScannerToken("=")
    public static String assign = "=";

    @ScannerToken(">=")
    public static String greaterEquals = ">=";

    @ScannerToken("<=")
    public static String smallerEquals = "<=";

    @ScannerToken(">>")
    public static String shiftRight = ">>";

    @ScannerToken("<<")
    public static String shiftLeft = "<<";

    @ScannerToken(">")
    public static String greater = ">";

    @ScannerToken("<")
    public static String smaller = "<";

    @ScannerToken
    public static String importKeyword = "import";

    @ScannerToken
    public static String classKeyword = "class";

    @ScannerToken
    public static String ifKeyword = "if";

    @ScannerToken
    public static String whileKeyword = "while";

    @ScannerToken
    public static String forKeyword = "for";

    @ScannerToken
    public static String visibility = "public|private|protected";

    @ScannerIgnore
    public static String ignore = "\\s+";

    @ScannerToken
    public static String number = "[-+]?[0-9]+(\\.[0-9]+)?([eE][+-]?[0-9]+)?";

    @ScannerToken
    public static String string = "\"[^\"]*\"";

    @ScannerToken
    public static String word = "[a-zA-Z]\\w*";


    @ParserRoot("clazz:class EOF")
    public static ClassContainer start(ClassContainer clazz)
    {
        return clazz;
    }

    @ParserRule("class -> visibility? classKeyword className:word { classExpressions }")
    public static ClassContainer classValue(String visibility, String className, List<ClassExpression> classExpressions)
    {
        return new ClassContainer(className, classExpressions);
    }

    @ParserRule("classExpressions -> classExpressions? classExpression")
    public static List<ClassExpression> classExpressions(List<ClassExpression> classExpressions, ClassExpression classExpression)
    {
        if (classExpressions == null)
        {
            classExpressions = new ArrayList<>();
        }

        classExpressions.add(classExpression);

        return classExpressions;
    }

    @ParserRule("classExpression -> classDeclareAssign ;")
    public static ClassExpression classExpressions(ClassDeclareAssign classDeclareAssign)
    {
        return classDeclareAssign;
    }

    @ParserRule("classDeclareAssign -> varType:word assign")
    public static ClassDeclareAssign classDeclareAssign(String varType, Assign assign)
    {
        return new ClassDeclareAssign(varType, assign);
    }

    @ParserRule("classExpression -> method")
    public static ClassExpression classExpressions(MethodContainer method)
    {
        return method;
    }

    @ParserRule("method -> visibility? returnType:word methodName:word ( declarations? ) { methodExpressions }")
    public static MethodContainer nonEmptyObject(String visibility, String methodName, String returnType, List<Declare> declarations, List<MethodExpression> methodExpressions)
    {
        if (declarations == null)
        {
            declarations = new ArrayList<>();
        }

        return new MethodContainer(methodName, returnType, declarations, methodExpressions);
    }

    @ParserRule("declarations -> (declarations ,)? declare")
    public static List<Declare> declarations(List<Declare> declarations, Declare declare)
    {
        if (declarations == null)
        {
            declarations = new ArrayList<>();
        }

        declarations.add(declare);

        return declarations;
    }

    @ParserRule("methodExpressions -> methodExpressions? methodExpression")
    public static List<MethodExpression> methodStatments(MethodExpression methodExpression, List<MethodExpression> methodExpressions)
    {
        if (methodExpressions == null)
        {
            methodExpressions = new ArrayList<>();
        }

        methodExpressions.add(methodExpression);

        return methodExpressions;
    }

    @ParserRule("methodExpression -> declareAssign ;")
    public static DeclareAssign varDefAssign(DeclareAssign declareAssign)
    {
        return declareAssign;
    }

    @ParserRule("declareAssign -> varType:word assign")
    public static DeclareAssign varDefAssign(String varType, Assign assign)
    {
        return new DeclareAssign(varType, assign);
    }

    @ParserRule("methodExpression -> declare ;")
    public static Declare declare(Declare declare)
    {
        return declare;
    }

    @ParserRule("declare -> varType:word varName:word")
    public static Declare declare(String varType, String varName)
    {
        return new Declare(varType, varName);
    }

    @ParserRule("methodExpression -> assign ;")
    public static Assign assign(Assign assign)
    {
        return assign;
    }

    @ParserRule("statement -> assignStatement")
    public static Statement statement(Statement assignStatement)
    {
        return assignStatement;
    }

    //if
    @ParserRule("methodExpression -> expression:if")
    public static MethodExpression assign(IfExpression expression)
    {
        return expression;
    }

    @ParserRule("if -> ifKeyword ( statement ) { methodExpressions? }")
    public static IfExpression statement(Statement statement, List<MethodExpression> methodExpressions)
    {
        if (methodExpressions == null)
        {
            methodExpressions = new ArrayList<>();
        }

        return new IfExpression(statement, methodExpressions);
    }

    //While
    @ParserRule("methodExpression -> expression:while")
    public static MethodExpression whileExpression(WhileExpression expression)
    {
        return expression;
    }

    @ParserRule("while -> whileKeyword ( statement ) { methodExpressions? }")
    public static WhileExpression whileExpression(Statement statement, List<MethodExpression> methodExpressions)
    {
        if (methodExpressions == null)
        {
            methodExpressions = new ArrayList<>();
        }

        return new WhileExpression(statement, methodExpressions);
    }


    //for
    @ParserRule("methodExpression -> expression:for")
    public static MethodExpression forExpression(ForExpression expression)
    {
        return expression;
    }

    @ParserRule("for -> forKeyword ( init:declareAssign ; condition:statement ; increment:statement ) { methodExpressions? }")
    public static ForExpression forExpression(DeclareAssign init, Statement condition, Statement increment, List<MethodExpression> methodExpressions)
    {
        if (methodExpressions == null)
        {
            methodExpressions = new ArrayList<>();
        }

        return new ForExpression(init, condition, increment, methodExpressions);
    }

    //assign
    @ParserRule("assign -> varName:word = assignStatement")
    public static Assign assignStatement(String varName, Statement assignStatement)
    {
        return new Assign(varName, assignStatement);
    }

    @ParserRule("assignStatement -> assign")
    public static Statement assignStatee(Statement assign)
    {
        return assign;
    }

    @ParserRule("assignStatement -> boolComp")
    public static Statement assign(Statement boolComp)
    {
        return boolComp;
    }

    //boolean
    @ParserRule("boolComp -> boolComp && equals")
    public static Statement booleanAnd(Statement boolComp, Statement equals)
    {
        return new StatementBooleanAnd(boolComp, equals);
    }

    @ParserRule("boolComp -> boolComp & equals")
    public static Statement bitwiseAnd(Statement boolComp, Statement equals)
    {
        return new StatementBitwiseAnd(boolComp, equals);
    }

    @ParserRule("boolComp -> boolComp || equals")
    public static Statement booleanOr(Statement boolComp, Statement equals)
    {
        return new StatementBooleanOr(boolComp, equals);
    }

    @ParserRule("boolComp -> boolComp | equals")
    public static Statement bitwiseOr(Statement boolComp, Statement equals)
    {
        return new StatementBitwiseOr(boolComp, equals);
    }

    @ParserRule("boolComp -> equals")
    public static Statement boolComp(Statement equals)
    {
        return equals;
    }

    //equals
    @ParserRule("equals -> equals == comp")
    public static Statement equals(Statement equals, Statement comp)
    {
        return new StatementEquals(equals, comp);
    }

    @ParserRule("equals -> equals != comp")
    public static Statement notEquals(Statement equals, Statement comp)
    {
        return new StatementNotEquals(equals, comp);
    }

    @ParserRule("equals -> comp")
    public static Statement greater(Statement comp)
    {
        return comp;
    }

    //compares
    @ParserRule("comp -> comp < shift")
    public static Statement smaller(Statement comp, Statement shift)
    {
        return new StatementSmaller(comp, shift);
    }

    @ParserRule("comp -> comp <= shift")
    public static Statement smallerEquals(Statement comp, Statement shift)
    {
        return new StatementSmallerEquals(comp, shift);
    }

    @ParserRule("comp -> comp >= shift")
    public static Statement greaterEquals(Statement comp, Statement shift)
    {
        return new StatementGreaterEquals(comp, shift);
    }

    @ParserRule("comp -> comp > shift")
    public static Statement greater(Statement comp, Statement shift)
    {
        return new StatementGreaterEquals(comp, shift);
    }

    @ParserRule("comp -> shift")
    public static Statement comp(Statement shift)
    {
        return shift;
    }

    //shift
    @ParserRule("shift -> shift >> add")
    public static Statement shiftRight(Statement shift, Statement add)
    {
        return new StatementShiftRight(shift, add);
    }

    @ParserRule("shift -> shift << add")
    public static Statement shiftLeft(Statement shift, Statement add)
    {
        return new StatementShiftLeft(shift, add);
    }

    @ParserRule("shift -> add")
    public static Statement shift(Statement add)
    {
        return add;
    }

    //additions
    @ParserRule("add -> add + mul")
    public static Statement add(Statement add, Statement mul)
    {
        return new StatementAdd(add, mul);
    }

    @ParserRule("add -> add - mul")
    public static Statement sub(Statement add, Statement mul)
    {
        return new StatementSub(add, mul);
    }

    @ParserRule("add -> mul")
    public static Statement add(Statement mul)
    {
        return mul;
    }

    //multiplication
    @ParserRule("mul -> mul * increment")
    public static StatementMul mul(Statement mul, Statement increment)
    {
        return new StatementMul(mul, increment);
    }

    @ParserRule("mul -> mul % increment")
    public static StatementModulo modulo(Statement mul, Statement increment)
    {
        return new StatementModulo(mul, increment);
    }

    @ParserRule("mul -> mul / increment")
    public static StatementMul div(Statement mul, Statement increment)
    {
        return new StatementMul(mul, increment);
    }

    @ParserRule("mul -> increment")
    public static Statement mul(Statement increment)
    {
        return increment;
    }

    //increment
    @ParserRule("increment -> rawStatement ++")
    public static Statement increment(Statement rawStatement)
    {
        return new StatementIncrement(rawStatement);
    }

    @ParserRule("increment -> rawStatement --")
    public static Statement decrement(Statement rawStatement)
    {
        return new StatementDecrement(rawStatement);
    }

    @ParserRule("increment -> rawStatement")
    public static Statement incrementLoop(Statement rawStatement)
    {
        return rawStatement;
    }

    //parenthesis
    @ParserRule("rawStatement -> ( statement )")
    public static Statement parenth(Statement statement)
    {
        return statement;
    }

    @ParserRule("rawStatement -> key:word")
    public static StatementVariable variable(String key)
    {
        return new StatementVariable(key);
    }

    @ParserRule("rawStatement -> key:number")
    public static StatementDouble testing(String key)
    {
        return new StatementDouble(Double.parseDouble(key));
    }

    @ParserRule("rawStatement -> key:string")
    public static StatementString string(String key)
    {
        return new StatementString(key.substring(1, key.length() - 1));
    }
}