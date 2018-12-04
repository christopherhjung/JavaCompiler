package com.christophejung.statements;

public class ExpressionBitwiseOr implements Expression
{
    private Expression left;
    private Expression right;

    public ExpressionBitwiseOr(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " | " + right;
    }
}
