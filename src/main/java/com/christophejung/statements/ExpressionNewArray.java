package com.christophejung.statements;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;
import com.christophejung.methodexpressions.Statement;

public class ExpressionNewArray extends Program implements Expression, Statement
{
    private Expression target;
    private Expression dimension;

    public ExpressionNewArray(Expression target, Expression dimension)
    {
        this.target = target;
        this.dimension = dimension;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("new ");
        writer.print(target);
        writer.print("[");
        writer.print(dimension);
        writer.print(']');
    }
}
