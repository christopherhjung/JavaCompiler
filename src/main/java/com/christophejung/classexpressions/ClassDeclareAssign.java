package com.christophejung.classexpressions;

import com.christophejung.methodexpressions.Assign;
import com.christophejung.methodexpressions.MethodExpression;

public class ClassDeclareAssign implements ClassExpression
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
