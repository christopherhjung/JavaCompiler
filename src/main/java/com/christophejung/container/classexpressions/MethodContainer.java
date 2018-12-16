package com.christophejung.container.classexpressions;

import com.christophejung.container.Block;
import com.christophejung.container.Program;
import com.christophejung.container.Type;
import com.christophejung.container.methodexpressions.Declare;
import com.christophejung.container.methodexpressions.Statement;
import com.christophejung.utils.HierarchicalWriter;

import java.lang.reflect.Modifier;
import java.util.List;

public class MethodContainer extends Program implements Statement
{
    private String methodName;
    private Type returnType;
    private Block expression;
    private int modifiers;
    private List<Declare> declarations;

    public MethodContainer(String methodName, int modifiers, Type returnType, List<Declare> declarations, Block expression)
    {
        this.modifiers = modifiers;
        this.methodName = methodName;
        this.returnType = returnType;
        this.declarations = declarations;
        this.expression = expression;
    }

    public Block getExpression()
    {
        return expression;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print(Modifier.toString(modifiers));

        if (modifiers > 0)
        {
            writer.print(" ");
        }

        writer.print(returnType);
        writer.print(' ');
        writer.print(methodName);
        writer.print("(");

        boolean firstArgument = false;
        if (declarations != null)
        {
            for (Declare declare : declarations)
            {
                if (firstArgument)
                {
                    writer.print(", ");
                }
                writer.print(declare);
                firstArgument = true;
            }
        }

        writer.print(")");
        writer.print(expression);
    }
}
