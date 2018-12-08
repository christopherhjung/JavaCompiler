package com.christophejung.methodexpressions;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;
import com.christophejung.statements.Expression;

public class ThrowStatement extends Program implements Statement
{
    private Expression value;

    public ThrowStatement(Expression value)
    {
        this.value = value;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("throw ");
        writer.print(value);
    }
}
