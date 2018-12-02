package com.christophejung.statements;

public class StatementModulo implements Statement
{
    private Statement left;
    private Statement right;

    public StatementModulo(Statement left, Statement right)
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
