package com.christophejung.statements;

public class StatementMul implements Statement
{
    private Statement left;
    private Statement right;

    public StatementMul(Statement left, Statement right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " * " + right;
    }
}
