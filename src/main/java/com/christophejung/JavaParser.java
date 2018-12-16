package com.christophejung;

import com.christophejung.container.*;
import com.christophejung.container.classexpressions.MethodContainer;
import com.christophejung.container.methodexpressions.*;
import com.christophejung.container.statements.*;
import com.christopherjung.reflectparser.ParserRule;
import com.christopherjung.reflectparser.ScannerIgnore;
import com.christopherjung.reflectparser.ScannerSingle;
import com.christopherjung.reflectparser.ScannerToken;

import java.util.List;

@SuppressWarnings("all")
public class JavaParser
{
    @ScannerSingle
    public static String structureChars = "[](){},:;.?";

    @ScannerIgnore
    public static String ignore = "\\s+";

    @ScannerIgnore
    public static String comment = "/\\*([^*]|\\*+[^*/])*\\*+/";

    @ScannerIgnore
    public static String singleLineComment = "//[^\n]+";

    @ScannerToken
    public static String importKeyword = "import(?=[^\\w])";

    @ScannerToken
    public static String classKeyword = "class(?=[^\\w])";

    @ScannerToken
    public static String ifKeyword = "if(?=[^\\w])";

    @ScannerToken
    public static String elseKeyword = "else(?=[^\\w])";

    @ScannerToken
    public static String whileKeyword = "while(?=[^\\w])";

    @ScannerToken
    public static String forKeyword = "for(?=[^\\w])";

    @ScannerToken
    public static String newKeyword = "new(?=[^\\w])";

    @ScannerToken
    public static String nullKeyword = "null(?=[^\\w])";

    @ScannerToken
    public static String returnKeyword = "return(?=[^\\w])";

    @ScannerToken
    public static String extendsKeyword = "extends(?=[^\\w])";

    @ScannerToken
    public static String implementsKeyword = "implements(?=[^\\w])";

    @ScannerToken
    public static String abstractKeyword = "abstract(?=[^\\w])";

    @ScannerToken
    public static String throwsKeyword = "throws(?=[^\\w])";

    @ScannerToken
    public static String throwKeyword = "throw(?=[^\\w])";

    @ScannerToken
    public static String tryKeyword = "try(?=[^\\w])";

    @ScannerToken
    public static String catchKeyword = "catch(?=[^\\w])";

    @ScannerToken
    public static String thisKeyword = "this(?=[^\\w])";

    @ScannerToken
    public static String staticKeyword = "static(?=[^\\w])";

    @ScannerToken
    public static String visibility = "(public|private|protected)(?=[^\\w])";

    @ScannerToken
    public static String booleanValue = "(true|false)(?=[^\\w])";

    @ScannerToken
    public static String number = "[-+]?[0-9]+(\\.[0-9]+)?([eE][+-]?[0-9]+)?";

    @ScannerToken
    public static String word = "[a-zA-Z_]\\w*";

    @ScannerToken
    public static String string = "\"[^\"]*\"";

    @ScannerToken("++")
    public static String increment = "\\+\\+";

    @ScannerToken("+=")
    public static String addAssign = "\\+=";

    @ScannerToken("+")
    public static String add = "\\+";

    @ScannerToken("--")
    public static String decrement = "\\-\\-";

    @ScannerToken("-=")
    public static String decrementAssign = "\\-=";

    @ScannerToken("-")
    public static String sub = "\\-";

    @ScannerToken("==")
    public static String equals = "==";

    @ScannerToken("=")
    public static String assign = "=";

    @ScannerToken("!=")
    public static String notEquals = "!=";

    @ScannerToken("!")
    public static String not = "!";

    @ScannerToken("~=")
    public static String bitwiseNotEquals = "~=";

    @ScannerToken("~")
    public static String bitwiseNot = "~";

    @ScannerToken(">=")
    public static String greaterEquals = ">=";

    @ScannerToken(">")
    public static String greater = ">";

    @ScannerToken("<=")
    public static String smallerEquals = "<=";

    @ScannerToken("<")
    public static String smaller = "<";

    @ScannerToken("*=")
    public static String multiplyAssign = "\\*=";

    @ScannerToken("*")
    public static String multiply = "\\*";

    @ScannerToken("/=")
    public static String divideAssign = "/=";

    @ScannerToken("/")
    public static String divide = "/";

    @ScannerToken("||=")
    public static String booleanOrAssign = "\\|\\|=";

    @ScannerToken("||")
    public static String booleanOr = "\\|\\|";

    @ScannerToken("|=")
    public static String bitwiseOrAssign = "\\|=";

    @ScannerToken("|")
    public static String bitwiseOr = "\\|";

    @ScannerToken("&&=")
    public static String booleanAndAssign = "&&=";

    @ScannerToken("&&")
    public static String booleanAnd = "&&";

    @ScannerToken("&=")
    public static String bitwiseAndAssign = "&=";

    @ScannerToken("&")
    public static String bitwiseAnd = "&";

    @ScannerToken(">>=")
    public static String shiftRightAssign = ">>=";

    @ScannerToken(">>")
    public static String shiftRight = ">>";

    @ScannerToken("<<=")
    public static String shiftLeftAssign = "<<=";

    @ScannerToken("<<")
    public static String shiftLeft = "<<";

    @ParserRule("root -> imports:import* classes:class*")
    public static ProgramFile start(List<Import> imports, List<ClassContainer> classes)
    {
        return new ProgramFile("test", imports, classes);
    }

    @ParserRule("package -> packageKeyword path:word ';'")
    public static String packageImpl(String path)
    {
        return path;
    }

    @ParserRule("import -> importKeyword path:word ';'")
    public static Import clazz(String path)
    {
        return new Import(path);
    }

    @ParserRule("class -> visibility? abstractKeyword? classKeyword className:type superclass:extends? interfaces:implements? '{' classStatements:classStatement* '}'")
    public static ClassContainer classValue(String visibility, Type className, List<Statement> classStatements, Type superclass, List<Type> interfaces)
    {
        return new ClassContainer(className, superclass, interfaces, classStatements);
    }

    @ParserRule("extends -> extendsKeyword type")
    public static Type extendsExpression(Type type)
    {
        return type;
    }

    @ParserRule("implements -> implementsKeyword interfaces:type{min=1,separator=','}")
    public static List<Type> implementsExpression(List<Type> interfaces)
    {
        return interfaces;
    }

    //@ParserRule("classStatement -> statement:declare ';'")
    @ParserRule("classStatement -> statement:block")
    @ParserRule("classStatement -> statement:method")
    public static Statement classDeclareAssign(Statement statement)
    {
        return statement;
    }

    @ParserRule("modifier -> visibility? staticKeyword?")
    public static Integer modifier(String visibility, String staticKeyword)
    {
        int modifier = 0;

        if ("public".equals(visibility))
        {
            modifier |= 1;
        }
        else if ("private".equals(visibility))
        {
            modifier |= 2;
        }
        else if ("protected".equals(visibility))
        {
            modifier |= 4;
        }

        if ("static".equals(staticKeyword))
        {
            modifier |= 8;
        }

        return modifier;
    }

    @ParserRule("classStatement -> modifier? varType:type varName:word '=' expression ';'")
    public static Statement var(Integer modifier, Type varType, String varName, Expression expression)
    {
        if (modifier == null)
        {
            modifier = 0;
        }
        return new DeclareAssign(varType, varName, expression);
    }

    @ParserRule("method -> modifier? returnType:type methodName:word '(' declarations:declare{separator=','} ')' inner:block")
    public static MethodContainer nonEmptyObject(Integer modifier, String methodName, Type returnType, List<Declare> declarations, Block inner)
    {
        if (modifier == null)
        {
            modifier = 0;
        }
        return new MethodContainer(methodName, modifier, returnType, declarations, inner);
    }

    @ParserRule("block -> '{' methodStatements:methodStatement* '}'")
    public static Block nonEmptyObject(List<Statement> methodStatements)
    {
        return new Block(methodStatements);
    }

    @ParserRule("methodStatement -> statement:if")
    @ParserRule("methodStatement -> statement:block")
    @ParserRule("methodStatement -> statement:tryCatch")
    @ParserRule("methodStatement -> statement:while")
    @ParserRule("methodStatement -> statement:for")
    @ParserRule("methodStatement -> statement:forEach")
    @ParserRule("methodStatement -> statement:singleLineStatement ';'")
    @ParserRule("methodStatement -> statement:return ';'")
    @ParserRule("methodStatement -> statement:throw ';'")
    public static Statement methodStatement(Statement statement)
    {
        return statement;
    }

    @ParserRule("return -> returnKeyword expression")
    public static Statement returnStatement(Expression expression)
    {
        return new ReturnStatement(expression);
    }

    @ParserRule("throw -> throwKeyword expression")
    public static Statement throwStatement(Expression expression)
    {
        return new ThrowStatement(expression);
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

    @ParserRule("declareAssign -> varType:type varName:word '=' expression")
    public static Statement varDefAssign(Type varType, String varName, Expression expression)
    {
        return new DeclareAssign(varType, varName, expression);
    }

    @ParserRule("declare -> varType:type varName:word")
    public static Declare declare(Type varType, String varName)
    {
        return new Declare(varType, varName);
    }

    @ParserRule("type -> varType:word")
    public static Type type(String varType)
    {
        return new Type(varType);
    }

    @ParserRule("type -> varType:word '<' types:type{min=1,separator=','} '>'")
    public static Type type(String varType, List<Type> types)
    {
        return new Type(varType, types);
    }

    //if
    @ParserRule("if -> ifKeyword '(' expression ')' ifBranch:methodStatement")
    public static IfStatement ifStatement(Expression expression, Statement ifBranch)
    {
        return new IfStatement(expression, ifBranch);
    }

    @ParserRule("if -> ifKeyword '(' expression ')' ifBranch:methodStatement elseKeyword elseBranch:methodStatement")
    public static IfElseStatement ifElseStatement(Expression expression, Statement ifBranch, Statement elseBranch)
    {
        return new IfElseStatement(expression, ifBranch, elseBranch);
    }

    @ParserRule("tryCatch -> tryKeyword tryBranch:methodStatement catchKeyword '(' expression:declare ')' catchBranch:methodStatement")
    public static TryCatchStatement tryCatchStatement(Statement tryBranch, Statement catchBranch, Declare expression)
    {
        return new TryCatchStatement(tryBranch, catchBranch);
    }

    //While
    @ParserRule("while -> whileKeyword '(' expression ')' inner:methodStatement")
    public static WhileStatement whileStatement(Expression expression, Statement inner)
    {
        return new WhileStatement(expression, inner);
    }

    @ParserRule("for -> forKeyword '(' init:singleLineStatement ';' condition:expression ';' increment:expression ')' inner:methodStatement")
    public static ForStatement forStatement(Statement init, Expression condition, Expression increment, Statement inner)
    {
        return new ForStatement(init, condition, increment, inner);
    }

    @ParserRule("forEach -> forKeyword '(' target:declare ':' iterator:expression ')' inner:methodStatement")
    public static ForEachStatement forEachStatement(Declare target, Expression iterator, Statement inner)
    {
        return new ForEachStatement(target, iterator, inner);
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

    @ParserRule("assign -> booleanOr '=' expression")
    public static Assign assignExpression(Expression booleanOr, Expression expression)
    {
        return new Assign(booleanOr, expression);
    }

    @ParserRule("expression -> modifyAssign")
    public static Expression assignAdd(Expression modifyAssign)
    {
        return modifyAssign;
    }

    @ParserRule("modifyAssign -> booleanOr '+=' expression")
    public static AssignAdd assignAdd(Expression booleanOr, Expression expression)
    {
        return new AssignAdd(booleanOr, expression);
    }

    @ParserRule("modifyAssign -> booleanOr '-=' expression")
    public static AssignSub assignSub(Expression booleanOr, Expression expression)
    {
        return new AssignSub(booleanOr, expression);
    }

    @ParserRule("modifyAssign -> booleanOr '*=' expression")
    public static AssignMul assignMul(Expression booleanOr, Expression expression)
    {
        return new AssignMul(booleanOr, expression);
    }

    @ParserRule("modifyAssign -> booleanOr '/=' expression")
    public static AssignDiv assignDiv(Expression booleanOr, Expression expression)
    {
        return new AssignDiv(booleanOr, expression);
    }

    //booleanOr
    @ParserRule("booleanOr -> booleanOr '||' booleanAnd")
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
    @ParserRule("booleanAnd -> booleanAnd '&&' bitwiseOr")
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
    @ParserRule("bitwiseOr -> bitwiseOr '|' bitwiseAnd")
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
    @ParserRule("bitwiseAnd -> bitwiseAnd '&' equals")
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
    @ParserRule("equals -> equals '==' comp")
    public static Expression equals(Expression equals, Expression comp)
    {
        return new ExpressionEquals(equals, comp);
    }

    @ParserRule("equals -> equals '!=' comp")
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
    @ParserRule("comp -> comp '<' shift")
    public static Expression smaller(Expression comp, Expression shift)
    {
        return new ExpressionSmaller(comp, shift);
    }

    @ParserRule("comp -> comp '<=' shift")
    public static Expression smallerEquals(Expression comp, Expression shift)
    {
        return new ExpressionSmallerEquals(comp, shift);
    }

    @ParserRule("comp -> comp '>=' shift")
    public static Expression greaterEquals(Expression comp, Expression shift)
    {
        return new ExpressionGreaterEquals(comp, shift);
    }

    @ParserRule("comp -> comp '>' shift")
    public static Expression greater(Expression comp, Expression shift)
    {
        return new ExpressionGreater(comp, shift);
    }

    @ParserRule("comp -> shift")
    public static Expression comp(Expression shift)
    {
        return shift;
    }

    //shift
    @ParserRule("shift -> shift '>>' add")
    public static Expression shiftRight(Expression shift, Expression add)
    {
        return new ExpressionShiftRight(shift, add);
    }

    @ParserRule("shift -> shift '<<' add")
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
    @ParserRule("add -> add '+' mul")
    public static Expression add(Expression add, Expression mul)
    {
        return new ExpressionAdd(add, mul);
    }

    @ParserRule("add -> add '-' mul")
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
    @ParserRule("mul -> mul '*' cast")
    public static ExpressionMul mul(Expression mul, Expression cast)
    {
        return new ExpressionMul(mul, cast);
    }

    @ParserRule("mul -> mul '%' cast")
    public static ExpressionModulo modulo(Expression mul, Expression cast)
    {
        return new ExpressionModulo(mul, cast);
    }

    @ParserRule("mul -> mul '/' cast")
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


    @ParserRule("path -> ( path '.' )? word")
    public static String cast(String path, String word)
    {
        return path + word;
    }

    @ParserRule("cast -> '(' type:word ')' increment")
    public static Expression cast(String type, Expression increment)
    {
        return new ExpressionCast(new Type(type), increment);
    }

    @ParserRule("cast -> '+' increment")
    public static Expression unaryPlus(Expression increment)
    {
        return new ExpressionUnaryPlus(increment);
    }

    @ParserRule("cast -> '-' increment")
    public static Expression unaryNegate(Expression increment)
    {
        return new ExpressionUnaryMinus(increment);
    }

    @ParserRule("cast -> increment")
    public static Expression cast(Expression increment)
    {
        return increment;
    }

    //increment
    @ParserRule("increment -> member '++'")
    public static Expression increment(Expression member)
    {
        return new ExpressionPostIncrement(member);
    }

    @ParserRule("increment -> member '--'")
    public static Expression decrement(Expression member)
    {
        return new ExpressionPostDecrement(member);
    }

    @ParserRule("increment -> '++' member")
    public static Expression preIncrement(Expression member)
    {
        return new ExpressionPreIncrement(member);
    }

    @ParserRule("increment -> '--' member")
    public static Expression preDecrement(Expression member)
    {
        return new ExpressionPreDecrement(member);
    }

    @ParserRule("increment -> '!' member")
    public static Expression logicNegate(Expression member)
    {
        return new ExpressionUnaryLogicNegate(member);
    }

    @ParserRule("increment -> '~' member")
    public static Expression bitwiseNegate(Expression member)
    {
        return new ExpressionUnaryBitwiseNegate(member);
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

    @ParserRule("newInstance -> newKeyword type expressions:expressionParenthesis")
    public static ExpressionNewInstance newInstance(Type type, List<Expression> expressions)
    {
        return new ExpressionNewInstance(type, expressions);
    }

    @ParserRule("newArray -> newKeyword type '[' dimension:expression ']'")
    public static ExpressionNewArray newArray(Type type, Expression dimension)
    {
        return new ExpressionNewArray(type, dimension);
    }

    @ParserRule("member -> member '.' name:( word | classKeyword )")
    public static Expression member(Expression member, String name)
    {
        return new MemberSelect(member, name);
    }

    @ParserRule("member -> '(' expression ')'")
    public static Expression parenth(Expression expression)
    {
        return expression;
    }

    @ParserRule("member -> methodCall")
    public static Expression methodCall(Expression methodCall)
    {
        return methodCall;
    }

    @ParserRule("member -> target:member '[' index:expression ']'")
    public static Expression methodCall(Expression target, Expression index)
    {
        return new ExpressionIndex(target, index);
    }

    @ParserRule("member -> rawExpression")
    public static Expression member(Expression rawExpression)
    {
        return rawExpression;
    }

    @ParserRule("methodCall -> member expressions:expressionParenthesis")
    public static MethodCall methodCall(Expression member, List<Expression> expressions)
    {
        return new MethodCall(member, expressions);
    }

    @ParserRule("expressionParenthesis -> '(' expressions:expression{separator=','} ')'")
    public static List<Expression> methodCall(List<Expression> expressions)
    {
        return expressions;
    }

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
    public static ExpressionDouble doubleExpression(String key)
    {
        return new ExpressionDouble(Double.parseDouble(key));
    }

    @ParserRule("rawExpression -> key:string")
    public static ExpressionString string(String key)
    {
        return new ExpressionString(key.substring(1, key.length() - 1));
    }

    @ParserRule("rawExpression -> key:booleanValue")
    public static ExpressionBoolean booleanValue(String key)
    {
        return new ExpressionBoolean(Boolean.parseBoolean(key));
    }

    @ParserRule("rawExpression -> nullKeyword")
    public static ExpressionNull nullKeyword()
    {
        return new ExpressionNull();
    }

    @ParserRule("rawExpression -> thisKeyword")
    public static ExpressionThis thisKeyword()
    {
        return new ExpressionThis();
    }
}
