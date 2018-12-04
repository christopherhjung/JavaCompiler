package com.christophejung.statements;


import com.christophejung.methodexpressions.MethodExpression;

public class StatementPostDecrement implements Statement, MethodExpression
{
    private Statement left;

    public StatementPostDecrement(Statement left)
    {
        this.left = left;
    }

    @Override
    public String toString()
    {
        return left + "--";
    }
}
