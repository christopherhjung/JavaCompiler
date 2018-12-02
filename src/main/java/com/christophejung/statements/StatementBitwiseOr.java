package com.christophejung.statements;

public class StatementBitwiseOr implements Statement
{
    private Statement left;
    private Statement right;

    public StatementBitwiseOr(Statement left, Statement right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " | " + right;
    }
}
