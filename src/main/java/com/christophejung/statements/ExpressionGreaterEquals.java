package com.christophejung.statements;

public class ExpressionGreaterEquals implements Expression
{
    private Expression left;
    private Expression right;

    public ExpressionGreaterEquals(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " >= " + right;
    }
}
