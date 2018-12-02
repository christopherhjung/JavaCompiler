package com.christophejung.statements;

public class StatementEquals implements Statement
{
    private Statement left;
    private Statement right;

    public StatementEquals(Statement left, Statement right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " == " + right;
    }
}
