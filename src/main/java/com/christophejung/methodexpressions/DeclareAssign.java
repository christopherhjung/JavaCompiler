package com.christophejung.methodexpressions;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;
import com.christophejung.Type;
import com.christophejung.statements.Expression;

public class DeclareAssign extends Program implements Statement
{
    private Type varType;
    private String varName;
    private Expression value;

    public DeclareAssign(Type varType, String varName, Expression value)
    {
        this.varType = varType;
        this.varName = varName;
        this.value = value;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print(varType);
        writer.print(" ");
        writer.print(varName);
        writer.print(" = ");
        writer.print(value);
    }
}
