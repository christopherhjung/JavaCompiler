package com.christophejung.container.statements;


import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;
import com.christophejung.container.Type;
import com.christophejung.container.methodexpressions.Statement;

public class ExpressionCast extends Program implements Expression, Statement
{
    private Type type;
    private Expression left;

    public ExpressionCast(Type type, Expression left)
    {
        this.type = type;
        this.left = left;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("(");
        writer.print(type);
        writer.print(")");
        writer.print(left);
    }
}
