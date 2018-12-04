package com.christophejung.statements;


import com.christophejung.methodexpressions.MethodExpression;

public class StatementPreDecrement implements Statement, MethodExpression
{
    private Statement left;

    public StatementPreDecrement(Statement left)
    {
        this.left = left;
    }

    @Override
    public String toString()
    {
        return "--" + left;
    }
}
