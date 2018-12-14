package com.christophejung.container.statements;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;

public class ExpressionSmallerEquals extends Program implements Expression
{
    private Expression left;
    private Expression right;

    public ExpressionSmallerEquals(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print(left);
        writer.print("<=");
        writer.print(right);
    }
}
