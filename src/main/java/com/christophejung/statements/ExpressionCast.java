package com.christophejung.statements;


import com.christophejung.methodexpressions.Statement;

public class ExpressionCast implements Expression, Statement
{
    private String type;
    private Expression left;

    public ExpressionCast(String type, Expression left)
    {
        this.type = type;
        this.left = left;
    }

    @Override
    public String toString()
    {
        return "(" + type + ")" + left;
    }
}
