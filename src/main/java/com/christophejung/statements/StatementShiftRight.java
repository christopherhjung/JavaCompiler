package com.christophejung.statements;

public class StatementShiftRight implements Statement
{
    private Statement left;
    private Statement right;

    public StatementShiftRight(Statement left, Statement right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return left + " >> " + right;
    }
}
