package com.christophejung.statements;

public class StatementBooleanAnd implements Statement
{
    private Statement left;
    private Statement right;

    public StatementBooleanAnd(Statement left, Statement right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " && " + right;
    }
}
