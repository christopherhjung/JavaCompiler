package com.christophejung.statements;


import com.christophejung.methodexpressions.MethodExpression;

public class StatementIncrement implements Statement, MethodExpression
{
    private Statement left;

    public StatementIncrement(Statement left)
    {
        this.left = left;
    }

    @Override
    public String toString()
    {
        return left + "++";
    }
}
