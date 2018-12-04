package com.christophejung.statements;

public class ExpressionSub implements Expression
{
    private Expression left;
    private Expression right;

    public ExpressionSub(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " - " + right;
    }
}
