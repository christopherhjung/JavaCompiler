package com.christophejung.statements;

public class ExpressionSmallerEquals implements Expression
{
    private Expression left;
    private Expression right;

    public ExpressionSmallerEquals(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " <= " + right;
    }
}
