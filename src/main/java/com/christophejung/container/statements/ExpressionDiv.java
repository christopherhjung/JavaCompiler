package com.christophejung.container.statements;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;

public class ExpressionDiv extends Program implements Expression
{
    private Expression left;
    private Expression right;

    public ExpressionDiv(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print(left);
        writer.print("/");
        writer.print(right);
    }
}
