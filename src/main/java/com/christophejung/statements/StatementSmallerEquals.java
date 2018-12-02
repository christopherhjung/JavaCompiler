package com.christophejung.statements;

public class StatementSmallerEquals implements Statement
{
    private Statement left;
    private Statement right;

    public StatementSmallerEquals(Statement left, Statement right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " <= " + right;
    }
}
