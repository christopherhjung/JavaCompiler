package com.christophejung.statements;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;

public class ExpressionBoolean extends Program implements Expression
{
    private boolean value;

    public ExpressionBoolean(boolean value)
    {
        this.value = value;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print(value);
    }
}
