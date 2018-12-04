package com.christophejung.statements;


import com.christophejung.methodexpressions.MethodExpression;

public class StatementPreIncrement implements Statement, MethodExpression
{
    private Statement left;

    public StatementPreIncrement(Statement left)
    {
        this.left = left;
    }

    @Override
    public String toString()
    {
        return "++" + left;
    }
}
