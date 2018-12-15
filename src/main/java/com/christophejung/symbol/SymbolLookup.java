package com.christophejung.symbol;

import com.christophejung.container.Block;
import com.christophejung.container.ClassContainer;
import com.christophejung.container.Type;
import com.christophejung.container.methodexpressions.*;
import com.christophejung.container.statements.Expression;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolLookup
{
    private static HashMap<String, Symbol> symbols;
    private static long position;

    public static Map<String, Symbol> lookup(Block block)
    {
        symbols = new HashMap<>();

        lookupRecursive(block.getExpressions());

        return symbols;
    }

    private static void add(String name, Type type)
    {
        if (symbols.containsKey(name))
        {
            throw new RuntimeException("Lookup Error: Name " + name + " already defined");
        }

        symbols.put(name, new Symbol(name, type));
    }

    private static void lookupRecursive(List<Statement> list)
    {
        for (Statement statement : list)
        {
            lookupRecursive(statement);
        }
    }

    private static void lookupRecursive(Statement statement)
    {
        position++;

        if (statement instanceof Block)
        {
            Block block = (Block) statement;

            lookupRecursive(block.getExpressions());
        }
        else if (statement instanceof WhileStatement)
        {
            WhileStatement whileStatement = (WhileStatement) statement;

            lookupRecursive(whileStatement.getExpression());
        }
        else if (statement instanceof ForStatement)
        {
            ForStatement forStatement = (ForStatement) statement;

            lookupRecursive(forStatement.getExpression());
        }
        else if (statement instanceof ForEachStatement)
        {
            ForEachStatement forStatement = (ForEachStatement) statement;

            lookupRecursive(forStatement.getExpression());
        }
        else if (statement instanceof IfStatement)
        {
            IfStatement ifStatement = (IfStatement) statement;

            lookupRecursive(ifStatement.getExpression());
        }
        else if (statement instanceof IfElseStatement)
        {
            IfElseStatement ifElseStatement = (IfElseStatement) statement;

            lookupRecursive(ifElseStatement.getIfBranch());
            lookupRecursive(ifElseStatement.getElseBranch());
        }
        else if (statement instanceof Declare)
        {
            Declare declare = (Declare) statement;

            add(declare.getName(), declare.getType());
        }
        else if (statement instanceof DeclareAssign)
        {
            DeclareAssign declareAssign = (DeclareAssign) statement;

            add(declareAssign.getName(), declareAssign.getType());
        }
    }
}
