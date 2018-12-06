package com.christophejung.methodexpressions;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;
import com.christophejung.statements.Expression;

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
