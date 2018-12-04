package com.christophejung.statements;

public class ExpressionShiftLeft implements Expression
{
    private Expression left;
    private Expression right;

    public ExpressionShiftLeft(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " << " + right;
    }
}
