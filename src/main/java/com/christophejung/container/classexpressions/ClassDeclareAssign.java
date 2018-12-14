package com.christophejung.container.classexpressions;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;
import com.christophejung.container.Type;
import com.christophejung.container.methodexpressions.Assign;

public class ClassDeclareAssign extends Program implements ClassStatement
{
    private Type varType;
    private Assign value;

    public ClassDeclareAssign(Type varType, Assign value)
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
