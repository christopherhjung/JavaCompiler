package com.christophejung.statements;

public class StatementDouble implements Statement
{
    private double value;

    public StatementDouble(double value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return value+"";
    }
}
