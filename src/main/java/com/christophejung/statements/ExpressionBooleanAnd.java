package com.christophejung.statements;

public class ExpressionBooleanAnd implements Expression
{
    private Expression left;
    private Expression right;

    public ExpressionBooleanAnd(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " && " + right;
    }
}
