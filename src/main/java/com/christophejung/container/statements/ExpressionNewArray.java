package com.christophejung.container.statements;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;
import com.christophejung.container.Type;
import com.christophejung.container.methodexpressions.Statement;

public class ExpressionNewArray extends Program implements Expression, Statement
{
    private Type target;
    private Expression dimension;

    public ExpressionNewArray(Type target, Expression dimension)
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
