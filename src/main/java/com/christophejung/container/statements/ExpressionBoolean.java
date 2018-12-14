package com.christophejung.container.statements;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;

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
