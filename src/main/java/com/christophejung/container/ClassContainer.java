package com.christophejung.container;

import com.christophejung.container.methodexpressions.Statement;
import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.classexpressions.ClassStatement;
import com.christopherjung.regex.State;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ClassContainer extends Program
{
    private Type className;
    private List<Statement> classStatements;
    private Type superclass;
    private List<Type> interfaces;

    public ClassContainer(Type className, Type superclass, List<Type> interfaces, List<Statement> classStatements)
    {
        this.className = className;
        this.superclass = superclass;
        this.interfaces = interfaces;
        this.classStatements = classStatements;
    }

    public List<Statement> getClassStatements()
    {
        return Collections.unmodifiableList(classStatements);
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("class ");
        writer.print(className);

        if (superclass != null )
        {
            writer.print(" extends ");
            writer.print(superclass);
        }

        if (interfaces != null && interfaces.size() > 0)
        {
            writer.print(" implements ");
            boolean first = false;
            for (Type interfaceObj : interfaces)
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

        for (Statement expression : classStatements)
        {
            writer.print(expression);
            if( !writer.isNewLine() ) writer.println(";");
        }

        writer.leaveLevel();
        writer.print("}");
    }
}
