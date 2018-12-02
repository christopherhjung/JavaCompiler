package com.christophejung.statements;


import com.christophejung.methodexpressions.MethodExpression;

public class StatementDecrement implements Statement, MethodExpression
{
    private Statement left;

    public StatementDecrement(Statement left)
    {
        this.left = left;
    }

    @Override
    public String toString()
    {
        return left + "--";
    }
}
