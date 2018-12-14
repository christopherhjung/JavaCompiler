package com.christophejung.container.methodexpressions;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;
import com.christophejung.container.Type;

public class Declare extends Program implements Statement
{
    private Type type;
    private String name;

    public Declare(Type type, String varName)
    {
        this.type = type;
        this.name = varName;
    }

    public String getName()
    {
        return name;
    }

    public Type getType()
    {
        return type;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print(type);
        writer.print(" ");
        writer.print(name);
    }
}
