package com.christophejung.classexpressions;

import com.christophejung.Block;
import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;
import com.christophejung.methodexpressions.Declare;

import java.util.List;

public class MethodContainer extends Program implements ClassStatement
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
    public void write(HierarchicalWriter writer)
    {
        writer.print(returnType);
        writer.print(' ');
        writer.print(methodName);
        writer.print("(");

        boolean firstArgument = false;
        for (Declare declare : declarations)
        {
            if (firstArgument)
            {
                writer.print(", ");
            }
            writer.print(declare);
            firstArgument = true;
        }

        writer.print(")");
        writer.print(expression);
    }
}
