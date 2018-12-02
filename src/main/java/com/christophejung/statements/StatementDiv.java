package com.christophejung.statements;

public class StatementDiv
{
    private Statement left;
    private Statement right;

    public StatementDiv(Statement left, Statement right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " / " + right;
    }
}
