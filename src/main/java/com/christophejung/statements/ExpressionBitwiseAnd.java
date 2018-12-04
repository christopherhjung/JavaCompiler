package com.christophejung.statements;

public class ExpressionBitwiseAnd implements Expression
{
    private Expression left;
    private Expression right;

    public ExpressionBitwiseAnd(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " & " + right;
    }
}