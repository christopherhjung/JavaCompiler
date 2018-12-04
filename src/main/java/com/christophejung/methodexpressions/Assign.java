package com.christophejung.methodexpressions;

import com.christophejung.statements.Expression;

public class Assign implements Expression, Statement
{
    private String varName;
    private Expression expression;

    public Assign(String varName, Expression expression)
    {
        this.varName = varName;
        this.expression = expression;
    }

    @Override
    public String toString()
    {
        return varName + " = " + expression;
    }
}
