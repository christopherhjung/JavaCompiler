package com.christophejung.statements;

public class StatementGreater implements Statement
{
    private Statement left;
    private Statement right;

    public StatementGreater(Statement left, Statement right)
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
