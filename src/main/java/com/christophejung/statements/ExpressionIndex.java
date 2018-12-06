package com.christophejung.statements;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;
import com.christophejung.methodexpressions.Statement;

public class ExpressionIndex extends Program implements Expression, Statement
{
    private Expression target;
    private Expression index;

    public ExpressionIndex(Expression target, Expression index)
    {
        this.target = target;
        this.index = index;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print(target);
        writer.print("[");
        writer.print(index);
        writer.print(']');
    }
}
