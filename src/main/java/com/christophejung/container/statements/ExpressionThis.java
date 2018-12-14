package com.christophejung.container.statements;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;

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
