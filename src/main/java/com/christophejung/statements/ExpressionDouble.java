package com.christophejung.statements;

public class ExpressionDouble implements Expression
{
    private double value;

    public ExpressionDouble(double value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return value+"";
    }
}
