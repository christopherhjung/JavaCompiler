package com.christophejung.classexpressions;

import com.christophejung.methodexpressions.Declare;
import com.christophejung.methodexpressions.MethodExpression;

import java.util.List;

public class MethodContainer implements ClassExpression
{
    private String methodName;
    private String returnType;
    private List<MethodExpression> methodMethodExpressions;
    private List<Declare> declarations;

    public MethodContainer(String methodName, String returnType, List<Declare> declarations, List<MethodExpression> methodMethodExpressions)
    {
        this.methodName = methodName;
        this.returnType = returnType;
        this.declarations = declarations;
        this.methodMethodExpressions = methodMethodExpressions;
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

        sb.append("){");

        for (MethodExpression methodExpression : methodMethodExpressions)
        {
            sb.append(methodExpression);
            sb.append(';');
        }

        sb.append("}");


        return sb.toString();
    }
}
