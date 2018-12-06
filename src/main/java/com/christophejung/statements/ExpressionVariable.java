package com.christophejung.statements;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;

public class ExpressionVariable extends Program implements Expression
{
    private String name;

    public ExpressionVariable(String name)
    {
        this.name = name;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print(name);
    }
}
