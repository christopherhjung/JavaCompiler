package com.christophejung.methodexpressions;

import com.christophejung.statements.Statement;

public class Assign implements Statement, MethodExpression
{
    private String varName;
    private Statement statement;

    public Assign(String varName, Statement statement)
    {
        this.varName = varName;
        this.statement = statement;
    }

    @Override
    public String toString()
    {
        return varName + " = " + statement;
    }
}
