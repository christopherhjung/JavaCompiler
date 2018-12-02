package com.christophejung.methodexpressions;

import com.christophejung.statements.Statement;

public class DeclareAssign implements MethodExpression
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
