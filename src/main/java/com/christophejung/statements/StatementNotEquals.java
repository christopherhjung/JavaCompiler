package com.christophejung.statements;

public class StatementNotEquals implements Statement
{
    private Statement left;
    private Statement right;

    public StatementNotEquals(Statement left, Statement right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " != " + right;
    }
}
