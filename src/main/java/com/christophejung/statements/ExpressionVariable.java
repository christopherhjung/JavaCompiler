package com.christophejung.statements;

public class ExpressionVariable implements Expression
{
    private String name;

    public ExpressionVariable(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
