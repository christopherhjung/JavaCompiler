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
    public static String nullKeyword = "null";

    @ScannerToken
    public static String returnKeyword = "return";

    @ScannerToken
    public static String extendsKeyword = "extends";

    @ScannerToken
    public static String implementsKeyword = "implements";

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

    @ParserRule("class -> visibility? classKeyword className:word superclass:extends? interfaces:implements? { classStatements }")
    public static ClassContainer classValue(String visibility, String className, List<ClassStatement> classStatements, String superclass, List<String> interfaces)
    {
        return new ClassContainer(className, superclass, interfaces, classStatements);
    }

    @ParserRule("extends -> extendsKeyword className:word")
    public static String extendsExpression(String className)
    {
        return className;
    }

    @ParserRule("implements -> implementsKeyword interfaces")
    public static List<String> implementsExpression(List<String> interfaces)
    {
        return interfaces;
    }

    @ParserRule("interfaces -> (interfaces ,)? word")
    public static List<String> implementsExpression(List<String> interfaces, String word)
    {
        if (interfaces == null)
        {
            interfaces = new ArrayList<>();
        }

        interfaces.add(word);

        return interfaces;
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

    @ParserRule("classStatement -> visibility? varType:word assign ;")
    public static ClassDeclareAssign classDeclareAssign(String varType, Assign assign)
    {
        return new ClassDeclareAssign(varType, assign);
    }

    @ParserRule("classStatement -> block")
    public static ClassStatement classDeclareAssign(Block block)
    {
        return block;
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

    @ParserRule("methodStatement -> statement:if")
    @ParserRule("methodStatement -> statement:block")
    @ParserRule("methodStatement -> statement:while")
    @ParserRule("methodStatement -> statement:singleLineStatement ;")
    @ParserRule("methodStatement -> statement:return ;")
    public static Statement methodStatement(Statement statement)
    {
        return statement;
    }

    @ParserRule("return -> returnKeyword expression")
    public static Statement returnStatement(Expression expression)
    {
        return new ReturnStatement(expression);
    }

    @ParserRule("singleLineStatement -> statement:assign")
    @ParserRule("singleLineStatement -> statement:modifyAssign")
    @ParserRule("singleLineStatement -> statement:declare")
    @ParserRule("singleLineStatement -> statement:declareAssign")
    @ParserRule("singleLineStatement -> statement:methodCall")
    @ParserRule("singleLineStatement -> statement:newInstance")
    public static Statement singleLineStatement(Statement statement)
    {
        return statement;
    }

    @ParserRule("declareAssign -> varType:word varName:word = expression")
    public static Statement varDefAssign(String varType, String varName, Expression expression)
    {
        return new DeclareAssign(varType, varName, expression);
    }

    @ParserRule("declare -> varType:word varName:word")
    public static Declare declare(String varType, String varName)
    {
        return new Declare(varType, varName);
    }

    //if

    @ParserRule("if -> ifKeyword ( expression ) inner:methodStatement")
    public static IfStatement expression(Expression expression, Statement inner)
    {
        return new IfStatement(expression, inner);
    }

    //While
    @ParserRule("while -> whileKeyword ( expression ) inner:methodStatement")
    public static WhileStatement whileStatement(Expression expression, Statement inner)
    {
        return new WhileStatement(expression, inner);
    }

    @ParserRule("for -> forKeyword ( init:singleLineStatement ; condition:expression ; increment:expression ) inner:methodStatement")
    public static ForStatement forStatement(Statement init, Expression condition, Expression increment, Statement inner)
    {
        return new ForStatement(init, condition, increment, inner);
    }

    @ParserRule("expression -> booleanOr")
    public static Expression assign(Expression booleanOr)
    {
        return booleanOr;
    }

    @ParserRule("expression -> assign")
    public static Assign assignExpression(Assign assign)
    {
        return assign;
    }

    @ParserRule("assign -> booleanOr = expression")
    public static Assign assignExpression(Expression booleanOr, Expression expression)
    {
        return new Assign(booleanOr, expression);
    }

    @ParserRule("expression -> modifyAssign")
    public static Expression assignAdd(Expression modifyAssign)
    {
        return modifyAssign;
    }

    @ParserRule("modifyAssign -> booleanOr += expression")
    public static AssignAdd assignAdd(Expression booleanOr, Expression expression)
    {
        return new AssignAdd(booleanOr, expression);
    }

    @ParserRule("modifyAssign -> booleanOr -= expression")
    public static AssignSub assignSub(Expression booleanOr, Expression expression)
    {
        return new AssignSub(booleanOr, expression);
    }

    @ParserRule("modifyAssign -> booleanOr *= expression")
    public static AssignAdd assignMul(Expression booleanOr, Expression expression)
    {
        return new AssignAdd(booleanOr, expression);
    }

    @ParserRule("modifyAssign -> booleanOr /= expression")
    public static AssignDiv assignDiv(Expression booleanOr, Expression expression)
    {
        return new AssignDiv(booleanOr, expression);
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

    @ParserRule("bitwiseOr -> bitwiseAnd")
    public static Expression bitwiseOr(Expression bitwiseAnd)
    {
        return bitwiseAnd;
    }

    //bitwiseAnd
    @ParserRule("bitwiseAnd -> bitwiseAnd & equals")
    public static Expression bitwiseAnd(Expression bitwiseAnd, Expression equals)
    {
        return new ExpressionBitwiseAnd(bitwiseAnd, equals);
    }

    @ParserRule("bitwiseAnd -> equals")
    public static Expression boolComp(Expression equals)
    {
        return equals;
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
    public static ExpressionDiv div(Expression mul, Expression cast)
    {
        return new ExpressionDiv(mul, cast);
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
    @ParserRule("member -> newInstance")
    public static ExpressionNewInstance newInstance(ExpressionNewInstance newInstance)
    {
        return newInstance;
    }

    @ParserRule("member -> newArray")
    public static ExpressionNewArray newArray(ExpressionNewArray newArray)
    {
        return newArray;
    }

    @ParserRule("newInstance -> newKeyword variable expressionParenthesis")
    public static ExpressionNewInstance newInstance(Expression variable, List<Expression> expressionParenthesis)
    {
        return new ExpressionNewInstance(variable, expressionParenthesis);
    }

    @ParserRule("newArray -> newKeyword variable [ dimension:expression ]")
    public static ExpressionNewArray newArray(Expression variable, Expression dimension)
    {
        return new ExpressionNewArray(variable, dimension);
    }

    @ParserRule("member -> member . rawExpression")
    public static Expression member(Expression member, Expression rawExpression)
    {
        return new MemberSelect(member, rawExpression);
    }

    @ParserRule("member -> ( expression )")
    public static Expression parenth(Expression expression)
    {
        return expression;
    }

    @ParserRule("member -> methodCall")
    public static Expression methodCall(Expression methodCall)
    {
        return methodCall;
    }

    @ParserRule("member -> target:member [ index:expression ]")
    public static Expression methodCall(Expression target, Expression index)
    {
        return new ExpressionIndex(target, index);
    }

    @ParserRule("member -> rawExpression")
    public static Expression member(Expression rawExpression)
    {
        return rawExpression;
    }

    @ParserRule("methodCall -> member expressionParenthesis")
    public static MethodCall methodCall(Expression member, List<Expression> expressionParenthesis)
    {
        return new MethodCall(member, expressionParenthesis);
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
    @ParserRule("rawExpression -> variable")
    public static ExpressionVariable variable(ExpressionVariable variable)
    {
        return variable;
    }


    @ParserRule("variable -> key:word")
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

    @ParserRule("rawExpression -> nullKeyword")
    public static ExpressionNull nullKeyword()
    {
        return new ExpressionNull();
    }
}
