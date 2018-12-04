package com.christophejung.statements;


import com.christophejung.methodexpressions.Statement;

public class ExpressionPostDecrement implements Expression, Statement
{
    private Expression left;

    public ExpressionPostDecrement(Expression left)
    {
        this.left = left;
    }

    @Override
    public String toString()
    {
        return left + "--";
    }
}
