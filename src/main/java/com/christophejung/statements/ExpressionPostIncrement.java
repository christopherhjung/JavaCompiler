package com.christophejung.statements;


import com.christophejung.methodexpressions.Statement;

public class ExpressionPostIncrement implements Expression, Statement
{
    private Expression left;

    public ExpressionPostIncrement(Expression left)
    {
        this.left = left;
    }

    @Override
    public String toString()
    {
        return left + "++";
    }
}
