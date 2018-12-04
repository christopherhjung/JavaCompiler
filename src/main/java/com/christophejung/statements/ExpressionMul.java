package com.christophejung.statements;

public class ExpressionMul implements Expression
{
    private Expression left;
    private Expression right;

    public ExpressionMul(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " * " + right;
    }
}
