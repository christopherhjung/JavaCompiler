package com.christophejung.container.methodexpressions;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;
import com.christophejung.container.Type;
import com.christophejung.container.statements.Expression;

public class DeclareAssign extends Program implements Statement
{
    private Type type;
    private String name;
    private Expression expression;

    public DeclareAssign(Type type, String name, Expression expression)
    {
        this.type = type;
        this.name = name;
        this.expression = expression;
    }

    public String getName()
    {
        return name;
    }

    public Type getType()
    {
        return type;
    }

    public Expression getExpression()
    {
        return expression;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print(type);
        writer.print(" ");
        writer.print(name);
        writer.print(" = ");
        writer.print(expression);
    }
}
