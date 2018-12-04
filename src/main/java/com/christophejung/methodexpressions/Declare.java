package com.christophejung.methodexpressions;

public class Declare implements Statement
{
    private String varType;
    private String varName;

    public Declare(String varType, String varName)
    {
        this.varType = varType;
        this.varName = varName;
    }

    @Override
    public String toString()
    {
        return varType + " " + varName;
    }
}
