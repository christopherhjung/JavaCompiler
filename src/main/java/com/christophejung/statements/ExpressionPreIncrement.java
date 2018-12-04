package com.christophejung.statements;


import com.christophejung.methodexpressions.Statement;

public class ExpressionPreIncrement implements Expression, Statement
{
    private Expression left;

    public ExpressionPreIncrement(Expression left)
    {
        this.left = left;
    }

    @Override
    public String toString()
    {
        return "++" + left;
    }
}
