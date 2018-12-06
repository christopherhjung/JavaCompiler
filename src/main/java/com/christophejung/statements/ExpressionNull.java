package com.christophejung.statements;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;

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
