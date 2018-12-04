package com.christophejung;

import com.christophejung.classexpressions.ClassStatement;

import java.util.List;

public class ClassContainer
{
    private String className;
    private List<ClassStatement> classStatements;

    public ClassContainer(String className, List<ClassStatement> classStatements)
    {
        this.className = className;
        this.classStatements = classStatements;
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("class ");
        sb.append(className);
        sb.append("{");

        for (ClassStatement expression : classStatements)
        {
            sb.append(expression);
            sb.append(';');
        }

        sb.append("}");


        return sb.toString();
    }
}
