package com.christophejung.statements;

public class ExpressionGreater implements Expression
{
    private Expression left;
    private Expression right;

    public ExpressionGreater(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " > " + right;
    }
}
