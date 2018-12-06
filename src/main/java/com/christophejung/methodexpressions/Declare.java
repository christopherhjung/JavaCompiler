package com.christophejung.methodexpressions;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;

public class Declare extends Program implements Statement
{
    private String varType;
    private String varName;

    public Declare(String varType, String varName)
    {
        this.varType = varType;
        this.varName = varName;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print(varType);
        writer.print(" ");
        writer.print(varName);
    }
}
