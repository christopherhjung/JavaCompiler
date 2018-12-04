package com.christophejung.statements;

public class StatementDiv
{
    private Expression left;
    private Expression right;

    public StatementDiv(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " / " + right;
    }
}
