package com.christophejung.statements;

public class ExpressionString implements Expression
{
    private String value;

    public ExpressionString(String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "\"" + value + "\"";
    }
}
