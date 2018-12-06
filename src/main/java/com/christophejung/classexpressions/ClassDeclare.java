package com.christophejung.classexpressions;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;

public class ClassDeclare extends Program implements ClassStatement
{
    private String varType;
    private String varName;

    public ClassDeclare(String varType, String varName)
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
