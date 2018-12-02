package com.christophejung.statements;

public class StatementSub implements Statement
{
    private Statement left;
    private Statement right;

    public StatementSub(Statement left, Statement right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " - " + right;
    }
}
