package com.christophejung.statements;

public class ExpressionNotEquals implements Expression
{
    private Expression left;
    private Expression right;

    public ExpressionNotEquals(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " != " + right;
    }
}
