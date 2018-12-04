package com.christophejung.statements;

public class ExpressionAdd implements Expression
{
    private Expression left;
    private Expression right;

    public ExpressionAdd(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " + " + right;
    }
}
