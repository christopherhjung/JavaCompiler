package com.christophejung.statements;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;

public class ExpressionDouble extends Program implements Expression
{
    private double value;

    public ExpressionDouble(double value)
    {
        this.value = value;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print(value);
    }
}
