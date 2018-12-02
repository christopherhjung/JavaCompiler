package com.christophejung.statements;

public class StatementShiftLeft implements Statement
{
    private Statement left;
    private Statement right;

    public StatementShiftLeft(Statement left, Statement right)
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
