package com.christophejung.container.methodexpressions;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;
import com.christophejung.container.statements.Expression;

public class ReturnStatement extends Program implements Statement
{
    private Expression value;

    public ReturnStatement(Expression value)
    {
        this.value = value;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("return ");
        writer.print(value);
    }
}
