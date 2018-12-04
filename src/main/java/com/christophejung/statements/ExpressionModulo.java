package com.christophejung.statements;

public class ExpressionModulo implements Expression
{
    private Expression left;
    private Expression right;

    public ExpressionModulo(Expression left, Expression right)
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
