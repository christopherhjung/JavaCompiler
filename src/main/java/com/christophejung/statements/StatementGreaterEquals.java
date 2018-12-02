package com.christophejung.statements;

public class StatementGreaterEquals implements Statement
{
    private Statement left;
    private Statement right;

    public StatementGreaterEquals(Statement left, Statement right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " >= " + right;
    }
}
