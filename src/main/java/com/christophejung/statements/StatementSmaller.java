package com.christophejung.statements;

public class StatementSmaller implements Statement
{
    private Statement left;
    private Statement right;

    public StatementSmaller(Statement left, Statement right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " < " + right;
    }
}
