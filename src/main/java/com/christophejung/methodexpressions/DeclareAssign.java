package com.christophejung.methodexpressions;

public class DeclareAssign implements Statement
{
    private String varType;
    private Assign value;

    public DeclareAssign(String varType, Assign value)
    {
        this.varType = varType;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return varType + " " + value;
    }
}
