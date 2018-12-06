package com.christophejung.statements;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;

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
