package com.christophejung.statements;


import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;
import com.christophejung.methodexpressions.Statement;

public class ExpressionPostDecrement extends Program implements Expression, Statement
{
    private Expression left;

    public ExpressionPostDecrement(Expression left)
    {
        this.left = left;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print(left);
        writer.print("--");
    }
}
