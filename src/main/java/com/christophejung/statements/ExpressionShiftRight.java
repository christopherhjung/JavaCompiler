package com.christophejung.statements;

public class ExpressionShiftRight implements Expression
{
    private Expression left;
    private Expression right;

    public ExpressionShiftRight(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " >> " + right;
    }
}
