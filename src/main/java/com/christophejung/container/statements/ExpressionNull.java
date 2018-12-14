package com.christophejung.container.statements;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;

public class ExpressionNull extends Program implements Expression
{
    public ExpressionNull()
    {
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("null");
    }
}
