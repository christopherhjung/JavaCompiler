package com.christophejung;

import com.christophejung.classexpressions.ClassDeclareAssign;
import com.christophejung.classexpressions.ClassStatement;
import com.christophejung.classexpressions.MethodContainer;
import com.christophejung.methodexpressions.*;
import com.christophejung.statements.*;
import com.christopherjung.reflectparser.*;

import java.util.ArrayList;
import java.util.List;

public class JavaParser
{
    @ScannerSingle
    public static String structureChars = "[](){},:;.?";

    @ScannerIgnore
    public static String ignore = "\\s+";

    @ScannerToken("*=")
    public static String multiplyAssign = "\\*\\=";

    @ScannerToken("*")
    public static String multiply = "\\*";

    @ScannerToken("/=")
    public static String divideAssign = "\\/\\=";

    @ParserIgnore
    @ScannerToken
    public static String comment = "\\/\\*([^*]|\\*+[^*\\/])*\\*+\\/";

    @ParserIgnore
    @ScannerToken
    public static String singleLineComment = "\\/\\/[^\n]+";

    @ScannerToken("/")
    public static String divide = "\\/";

    @ScannerToken("||")
    public static String booleanOr = "\\|\\|";

    @ScannerToken("||=")
    public static String booleanOrAssign = "\\|\\|\\=";

    @ScannerToken("|")
    public static String bitwiseOr = "\\|";

    @ScannerToken("|=")
    public static String bitwiseOrAssign = "\\|\\=";

    @ScannerToken("&&")
    public static String booleanAnd = "\\&\\&";

    @ScannerToken("&&=")
    public static String booleanAndAssign = "\\&\\&\\=";

    @ScannerToken("&")
    public static String bitwiseAnd = "\\&";

    @ScannerToken("&=")
    public static String bitwiseAndAssign = "\\&\\=";

    @ScannerToken("++")
    public static String increment = "\\+\\+";

    @ScannerToken("+=")
    public static String addAssign = "\\+\\=";

    @ScannerToken("+")
    public static String add = "\\+";

    @ScannerToken("--")
    public static String decrement = "\\-\\-";

    @ScannerToken("-=")
    public static String decrementAssign = "\\-\\=";

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

    @ScannerToken(">>=")
    public static String shiftRightAssign = ">>=";

    @ScannerToken("<<")
    public static String shiftLeft = "<<";

    @ScannerToken("<<=")
    public static String shiftLeftAssign = "<<=";

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
    public static String newKeyword = "new";

    @ScannerToken
    public static String visibility = "public|private|protected";

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

    @ParserRule("class -> visibility? classKeyword className:word { classStatements }")
    public static ClassContainer classValue(String visibility, String className, List<ClassStatement> classStatements)
    {
        return new ClassContainer(className, classStatements);
    }

    @ParserRule("classStatements -> classStatements? classStatement")
    public static List<ClassStatement> classStatements(List<ClassStatement> classStatements, ClassStatement classStatement)
    {
        if (classStatements == null)
        {
            classStatements = new ArrayList<>();
        }

        classStatements.add(classStatement);

        return classStatements;
    }

    @ParserRule("classStatement -> classDeclareAssign ;")
    public static ClassStatement classStatements(ClassDeclareAssign classDeclareAssign)
    {
        return classDeclareAssign;
    }

    @ParserRule("classDeclareAssign -> visibility? varType:word assign")
    public static ClassDeclareAssign classDeclareAssign(String varType, Assign assign)
    {
        return new ClassDeclareAssign(varType, assign);
    }

    @ParserRule("classStatement -> method")
    public static ClassStatement classStatements(MethodContainer method)
    {
        return method;
    }

    @ParserRule("method -> visibility? returnType:word methodName:word ( declarations? ) inner:block")
    public static MethodContainer nonEmptyObject(String visibility, String methodName, String returnType, List<Declare> declarations, Block inner)
    {
        if (declarations == null)
        {
            declarations = new ArrayList<>();
        }

        return new MethodContainer(methodName, returnType, declarations, inner);
    }

    @ParserRule("methodStatement -> block")
    public static Statement classStatements(Block block)
    {
        return block;
    }

    @ParserRule("block -> { methodStatements? }")
    public static Block nonEmptyObject(List<Statement> methodStatements)
    {
        if (methodStatements == null)
        {
            methodStatements = new ArrayList<>();
        }

        return new Block(methodStatements);
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

    @ParserRule("methodStatements -> methodStatements? methodStatement")
    public static List<Statement> methodStatments(Statement methodStatement, List<Statement> methodStatements)
    {
        if (methodStatements == null)
        {
            methodStatements = new ArrayList<>();
        }

        methodStatements.add(methodStatement);

        return methodStatements;
    }

    @ParserRule("methodStatement -> declareAssign ;")
    public static DeclareAssign varDefAssign(DeclareAssign declareAssign)
    {
        return declareAssign;
    }

    @ParserRule("declareAssign -> varType:word assign")
    public static DeclareAssign varDefAssign(String varType, Assign assign)
    {
        return new DeclareAssign(varType, assign);
    }

    @ParserRule("methodStatement -> declare ;")
    public static Declare declare(Declare declare)
    {
        return declare;
    }

    @ParserRule("declare -> varType:word varName:word")
    public static Declare declare(String varType, String varName)
    {
        return new Declare(varType, varName);
    }

    @ParserRule("methodStatement -> assign ;")
    public static Assign assign(Assign assign)
    {
        return assign;
    }

    @ParserRule("methodStatement -> expression ;")
    public static Statement tunnel(Expression expression)
    {
        try
        {
            return (Statement) expression;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    //if
    @ParserRule("methodStatement -> statement:if")
    public static Statement assign(IfStatement statement)
    {
        return statement;
    }

    @ParserRule("if -> ifKeyword ( expression ) inner:methodStatement")
    public static IfStatement expression(Expression expression, Statement inner)
    {
        return new IfStatement(expression, inner);
    }

    //While
    @ParserRule("methodStatement -> statement:while")
    public static Statement whileStatement(WhileStatement statement)
    {
        return statement;
    }

    @ParserRule("while -> whileKeyword ( expression ) inner:methodStatement")
    public static WhileStatement whileStatement(Expression expression, Statement inner)
    {
        return new WhileStatement(expression, inner);
    }

    //for
    @ParserRule("methodStatement -> statement:for")
    public static Statement forStatement(ForStatement statement)
    {
        return statement;
    }

    @ParserRule("for -> forKeyword ( init:declareAssign ; condition:expression ; increment:expression ) inner:methodStatement")
    public static ForStatement forStatement(DeclareAssign init, Expression condition, Expression increment, Statement inner)
    {
        return new ForStatement(init, condition, increment, inner);
    }

    //assign
    @ParserRule("expression -> assignExpression")
    public static Expression expression(Expression assignExpression)
    {
        return assignExpression;
    }

    @ParserRule("assign -> varName:word = assignExpression")
    public static Assign assignExpression(String varName, Expression assignExpression)
    {
        return new Assign(varName, assignExpression);
    }

    @ParserRule("assignExpression -> assign")
    public static Expression assignStatee(Expression assign)
    {
        return assign;
    }

    @ParserRule("assignExpression -> booleanOr")
    public static Expression assign(Expression booleanOr)
    {
        return booleanOr;
    }

    //booleanOr

    @ParserRule("booleanOr -> booleanOr || booleanAnd")
    public static Expression booleanOr(Expression booleanOr, Expression booleanAnd)
    {
        return new ExpressionBooleanOr(booleanOr, booleanAnd);
    }

    @ParserRule("booleanOr -> booleanAnd")
    public static Expression booleanOr(Expression booleanAnd)
    {
        return booleanAnd;
    }

    //booleanAnd
    @ParserRule("booleanAnd -> booleanAnd && bitwiseOr")
    public static Expression booleanAnd(Expression booleanAnd, Expression bitwiseOr)
    {
        return new ExpressionBooleanAnd(booleanAnd, bitwiseOr);
    }

    @ParserRule("booleanAnd -> bitwiseOr")
    public static Expression booleanAnd(Expression bitwiseOr)
    {
        return bitwiseOr;
    }

    //bitwiseOr

    @ParserRule("bitwiseOr -> bitwiseOr | bitwiseAnd")
    public static Expression bitwiseOr(Expression bitwiseOr, Expression bitwiseAnd)
    {
        return new ExpressionBitwiseOr(bitwiseOr, bitwiseAnd);
    }

    @ParserRule("booleanOr -> bitwiseAnd")
    public static Expression bitwiseOr(Expression bitwiseAnd)
    {
        return bitwiseAnd;
    }

    //bitwiseAnd
    @ParserRule("bitwiseAnd -> bitwiseAnd & comp")
    public static Expression bitwiseAnd(Expression bitwiseAnd, Expression comp)
    {
        return new ExpressionBitwiseAnd(bitwiseAnd, comp);
    }

    @ParserRule("bitwiseAnd -> comp")
    public static Expression boolComp(Expression comp)
    {
        return comp;
    }

    //equals
    @ParserRule("equals -> equals == comp")
    public static Expression equals(Expression equals, Expression comp)
    {
        return new ExpressionEquals(equals, comp);
    }

    @ParserRule("equals -> equals != comp")
    public static Expression notEquals(Expression equals, Expression comp)
    {
        return new ExpressionNotEquals(equals, comp);
    }

    @ParserRule("equals -> comp")
    public static Expression greater(Expression comp)
    {
        return comp;
    }

    //compares
    @ParserRule("comp -> comp < shift")
    public static Expression smaller(Expression comp, Expression shift)
    {
        return new ExpressionSmaller(comp, shift);
    }

    @ParserRule("comp -> comp <= shift")
    public static Expression smallerEquals(Expression comp, Expression shift)
    {
        return new ExpressionSmallerEquals(comp, shift);
    }

    @ParserRule("comp -> comp >= shift")
    public static Expression greaterEquals(Expression comp, Expression shift)
    {
        return new ExpressionGreaterEquals(comp, shift);
    }

    @ParserRule("comp -> comp > shift")
    public static Expression greater(Expression comp, Expression shift)
    {
        return new ExpressionGreaterEquals(comp, shift);
    }

    @ParserRule("comp -> shift")
    public static Expression comp(Expression shift)
    {
        return shift;
    }

    //shift
    @ParserRule("shift -> shift >> add")
    public static Expression shiftRight(Expression shift, Expression add)
    {
        return new ExpressionShiftRight(shift, add);
    }

    @ParserRule("shift -> shift << add")
    public static Expression shiftLeft(Expression shift, Expression add)
    {
        return new ExpressionShiftLeft(shift, add);
    }

    @ParserRule("shift -> add")
    public static Expression shift(Expression add)
    {
        return add;
    }

    //additions
    @ParserRule("add -> add + mul")
    public static Expression add(Expression add, Expression mul)
    {
        return new ExpressionAdd(add, mul);
    }

    @ParserRule("add -> add - mul")
    public static Expression sub(Expression add, Expression mul)
    {
        return new ExpressionSub(add, mul);
    }

    @ParserRule("add -> mul")
    public static Expression add(Expression mul)
    {
        return mul;
    }

    //multiplication
    @ParserRule("mul -> mul * cast")
    public static ExpressionMul mul(Expression mul, Expression cast)
    {
        return new ExpressionMul(mul, cast);
    }

    @ParserRule("mul -> mul % cast")
    public static ExpressionModulo modulo(Expression mul, Expression cast)
    {
        return new ExpressionModulo(mul, cast);
    }

    @ParserRule("mul -> mul / cast")
    public static ExpressionMul div(Expression mul, Expression cast)
    {
        return new ExpressionMul(mul, cast);
    }

    @ParserRule("mul -> cast")
    public static Expression mul(Expression cast)
    {
        return cast;
    }

    //cast and new


    @ParserRule("cast -> ( type:word ) increment")
    public static Expression cast(String type, Expression increment)
    {
        return new ExpressionCast(type, increment);
    }

    @ParserRule("cast -> newInstance")
    public static ExpressionNew newInstance(ExpressionNew newInstance)
    {
        return newInstance;
    }

    /*
    @ParserRule("methodStatement -> newInstance ;")
    public static Statement forStatement(ExpressionNew newInstance)
    {
        return newInstance;
    }*/

    @ParserRule("newInstance -> newKeyword member")
    public static ExpressionNew dslkds(Expression member)
    {
        return new ExpressionNew(member);
    }

    @ParserRule("cast -> increment")
    public static Expression cast(Expression increment)
    {
        return increment;
    }

    //increment
    @ParserRule("increment -> member ++")
    public static Expression increment(Expression member)
    {
        return new ExpressionPostIncrement(member);
    }

    @ParserRule("increment -> member --")
    public static Expression decrement(Expression member)
    {
        return new ExpressionPostDecrement(member);
    }

    @ParserRule("increment -> ++ member")
    public static Expression preIncrement(Expression member)
    {
        return new ExpressionPreIncrement(member);
    }

    @ParserRule("increment -> -- member")
    public static Expression preDecrement(Expression member)
    {
        return new ExpressionPreDecrement(member);
    }

    @ParserRule("increment -> member")
    public static Expression incrementLoop(Expression member)
    {
        return member;
    }

    //member assozi

    @ParserRule("member -> member . methodCallPrio")
    public static Expression member(Expression member, Expression methodCallPrio)
    {
        return new MemberSelect(member, methodCallPrio);
    }

    @ParserRule("member -> ( expression )")
    public static Expression parenth(Expression expression)
    {
        return expression;
    }

    @ParserRule("member -> methodCallPrio")
    public static Expression member(Expression methodCallPrio)
    {
        return methodCallPrio;
    }

    //methodCall
    /*@ParserRule("methodStatement -> methodCall ;")
    public static Statement methodCall(MethodCall methodCall)
    {
        return methodCall;
    }*/

    @ParserRule("methodCallPrio -> methodCall")
    public static Expression methodCallPrio(MethodCall methodCall)
    {
        return methodCall;
    }

    @ParserRule("methodCallPrio -> rawExpression")
    public static Expression methodCall(Expression rawExpression)
    {
        return rawExpression;
    }

    @ParserRule("methodCall -> rawExpression expressionParenthesis")
    public static MethodCall methodCall(Expression rawExpression, List<Expression> expressionParenthesis)
    {
        return new MethodCall(rawExpression, expressionParenthesis);
    }

    @ParserRule("expressionParenthesis -> ( expressions? )")
    public static List<Expression> methodCall(List<Expression> expressions)
    {
        if (expressions == null)
        {
            expressions = new ArrayList<>();
        }

        return expressions;
    }

    @ParserRule("expressions -> (expressions ,)? expression")
    public static List<Expression> methodCall(List<Expression> expressions, Expression expression)
    {
        if (expressions == null)
        {
            expressions = new ArrayList<>();
        }

        expressions.add(expression);

        return expressions;
    }

    //raaaw
    @ParserRule("rawExpression -> key:word")
    public static ExpressionVariable variable(String key)
    {
        return new ExpressionVariable(key);
    }

    @ParserRule("rawExpression -> key:number")
    public static ExpressionDouble testing(String key)
    {
        return new ExpressionDouble(Double.parseDouble(key));
    }

    @ParserRule("rawExpression -> key:string")
    public static ExpressionString string(String key)
    {
        return new ExpressionString(key.substring(1, key.length() - 1));
    }
}
