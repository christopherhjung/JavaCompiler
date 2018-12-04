package com.christophejung.statements;


import com.christophejung.methodexpressions.Statement;

public class ExpressionPreDecrement implements Expression, Statement
{
    private Expression left;

    public ExpressionPreDecrement(Expression left)
    {
        this.left = left;
    }

    @Override
    public String toString()
    {
        return "--" + left;
    }
}
