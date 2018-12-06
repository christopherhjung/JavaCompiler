package com.christophejung.statements;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;

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
