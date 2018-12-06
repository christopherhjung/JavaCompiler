package com.christophejung.statements;


import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;
import com.christophejung.methodexpressions.Statement;

public class ExpressionCast extends Program implements Expression, Statement
{
    private String type;
    private Expression left;

    public ExpressionCast(String type, Expression left)
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
