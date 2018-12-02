package com.christophejung.statements;

public class StatementString implements Statement
{
    private String value;

    public StatementString(String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "\"" + value + "\"";
    }
}
