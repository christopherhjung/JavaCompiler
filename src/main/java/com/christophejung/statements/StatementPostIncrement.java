package com.christophejung.statements;


import com.christophejung.methodexpressions.MethodExpression;

public class StatementPostIncrement implements Statement, MethodExpression
{
    private Statement left;

    public StatementPostIncrement(Statement left)
    {
        this.left = left;
    }

    @Override
    public String toString()
    {
        return left + "++";
    }
}
