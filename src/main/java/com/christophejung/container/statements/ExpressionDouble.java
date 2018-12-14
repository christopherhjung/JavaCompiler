package com.christophejung.container.statements;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;

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
