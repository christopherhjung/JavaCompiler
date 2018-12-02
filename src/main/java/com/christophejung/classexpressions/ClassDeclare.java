package com.christophejung.classexpressions;

import com.christophejung.methodexpressions.MethodExpression;

public class ClassDeclare implements ClassExpression
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
