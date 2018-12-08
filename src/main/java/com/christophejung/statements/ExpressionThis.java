package com.christophejung.statements;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;

public class ExpressionThis extends Program implements Expression
{
    public ExpressionThis()
    {
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("this");
    }
}
