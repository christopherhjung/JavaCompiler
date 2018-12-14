package com.christophejung.container.statements;


import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;
import com.christophejung.container.methodexpressions.Statement;

public class ExpressionPreDecrement extends Program implements Expression, Statement
{
    private Expression left;

    public ExpressionPreDecrement(Expression left)
    {
        this.left = left;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("--");
        writer.print(left);
    }
}
