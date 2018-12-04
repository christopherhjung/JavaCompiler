package com.christophejung.statements;

public class ExpressionSmaller implements Expression
{
    private Expression left;
    private Expression right;

    public ExpressionSmaller(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " < " + right;
    }
}
