package com.christophejung.statements;

public class StatementAdd implements Statement
{
    private Statement left;
    private Statement right;

    public StatementAdd(Statement left, Statement right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " + " + right;
    }
}
