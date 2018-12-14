package com.christophejung.container.statements;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;

public class ExpressionString extends Program implements Expression
{
    private String value;

    public ExpressionString(String value)
    {
        this.value = value;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("\"");
        writer.print(value);
        writer.print("\"");
    }
}
