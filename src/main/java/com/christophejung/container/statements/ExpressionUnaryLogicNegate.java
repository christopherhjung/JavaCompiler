package com.christophejung.container.statements;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;

public class ExpressionUnaryLogicNegate extends Program implements Expression
{
    private Expression value;

    public ExpressionUnaryLogicNegate(Expression value)
    {
        this.value = value;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("!");
        writer.print(value);
    }
}
