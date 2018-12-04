package com.christophejung.statements;

public class ExpressionBooleanOr implements Expression
{
    private Expression left;
    private Expression right;

    public ExpressionBooleanOr(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " || " + right;
    }
}
