package com.christophejung.classexpressions;

import com.christophejung.methodexpressions.Assign;

public class ClassDeclareAssign implements ClassStatement
{
    private String varType;
    private Assign value;

    public ClassDeclareAssign(String varType, Assign value)
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
