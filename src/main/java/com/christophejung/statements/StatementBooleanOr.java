package com.christophejung.statements;

public class StatementBooleanOr implements Statement
{
    private Statement left;
    private Statement right;

    public StatementBooleanOr(Statement left, Statement right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " || " + right;
    }
}
