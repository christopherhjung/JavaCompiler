package com.christophejung.statements;

public class ExpressionEquals implements Expression
{
    private Expression left;
    private Expression right;

    public ExpressionEquals(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " == " + right;
    }
}
