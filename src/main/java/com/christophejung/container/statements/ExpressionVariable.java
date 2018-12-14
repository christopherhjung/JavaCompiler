package com.christophejung.container.statements;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;

public class ExpressionVariable extends Program implements Expression
{
    private String name;

    public ExpressionVariable(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print(name);
    }
}
