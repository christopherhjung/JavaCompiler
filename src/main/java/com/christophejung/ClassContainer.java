package com.christophejung;

import com.christophejung.classexpressions.ClassExpression;

import java.util.List;

public class ClassContainer
{
    private String className;
    private List<ClassExpression> classExpressions;

    public ClassContainer(String className, List<ClassExpression> classExpressions)
    {
        this.className = className;
        this.classExpressions = classExpressions;
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(className);
        sb.append("{");

        for (ClassExpression expression : classExpressions)
        {
            sb.append(expression);
            sb.append(';');
        }

        sb.append("}");


        return sb.toString();
    }
}
