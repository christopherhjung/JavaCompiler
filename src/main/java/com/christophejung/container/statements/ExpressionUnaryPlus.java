package com.christophejung.container.statements;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;

public class ExpressionUnaryPlus extends Program implements Expression
{
    private Expression value;

    public ExpressionUnaryPlus(Expression value)
    {
        this.value = value;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("+");
        writer.print(value);
    }
}
