package com.christophejung.statements;

public class StatementVariable implements Statement
{
    private String name;

    public StatementVariable(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
