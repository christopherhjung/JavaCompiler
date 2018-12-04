package com.christophejung.classexpressions;

import com.christophejung.Block;
import com.christophejung.methodexpressions.Declare;

import java.util.List;

public class MethodContainer implements ClassStatement
{
    private String methodName;
    private String returnType;
    private Block expression;
    private List<Declare> declarations;

    public MethodContainer(String methodName, String returnType, List<Declare> declarations, Block expression)
    {
        this.methodName = methodName;
        this.returnType = returnType;
        this.declarations = declarations;
        this.expression = expression;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(returnType);
        sb.append(' ');
        sb.append(methodName);
        sb.append("(");

        boolean firstArgument = false;
        for (Declare declare : declarations)
        {
            if (firstArgument)
            {
                sb.append(", ");
            }
            sb.append(declare);
            firstArgument = true;
        }

        sb.append(")");

        sb.append(expression);

        return sb.toString();
    }
}
