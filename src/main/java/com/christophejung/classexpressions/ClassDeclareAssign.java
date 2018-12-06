package com.christophejung.classexpressions;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;
import com.christophejung.methodexpressions.Assign;

public class ClassDeclareAssign extends Program implements ClassStatement
{
    private String varType;
    private Assign value;

    public ClassDeclareAssign(String varType, Assign value)
    {
        this.varType = varType;
        this.value = value;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print(varType);
        writer.print(" ");
        writer.print(value);
    }
}
