package com.christophejung;

import com.christophejung.classexpressions.ClassStatement;

import java.util.List;

public class ClassContainer extends Program
{
    private Type className;
    private List<ClassStatement> classStatements;
    private String superclass;
    private List<String> interfaces;

    public ClassContainer(Type className, String superclass, List<String> interfaces, List<ClassStatement> classStatements)
    {
        this.className = className;
        this.superclass = superclass;
        this.interfaces = interfaces;
        this.classStatements = classStatements;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("class ");
        writer.print(className);

        if (superclass != null)
        {
            writer.print(" extends ");
            writer.print(superclass);
        }

        if (interfaces != null)
        {
            writer.print(" implements ");
            boolean first = false;
            for (String interfaceObj : interfaces)
            {
                if (first)
                {
                    writer.print(", ");
                }

                writer.print(interfaceObj);
                first = true;
            }
        }

        writer.println("{");
        writer.enterLevel();

        for (ClassStatement expression : classStatements)
        {
            writer.print(expression);
            if( !writer.isNewLine() ) writer.println(";");
        }

        writer.leaveLevel();
        writer.print("}");
    }
}
