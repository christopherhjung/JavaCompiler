package com.christophejung.classexpressions;

public class ClassDeclare implements ClassStatement
{
    private String varType;
    private String varName;

    public ClassDeclare(String varType, String varName)
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
