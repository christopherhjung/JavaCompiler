package com.christophejung.container.statements;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;
import com.christophejung.container.methodexpressions.Statement;

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
