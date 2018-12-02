package com.christophejung.statements;

public class StatementBitwiseAnd implements Statement
{
    private Statement left;
    private Statement right;

    public StatementBitwiseAnd(Statement left, Statement right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " & " + right;
    }
}
