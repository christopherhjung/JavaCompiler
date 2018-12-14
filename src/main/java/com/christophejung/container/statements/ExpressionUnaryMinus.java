package com.christophejung.container.statements;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;

public class ExpressionUnaryMinus extends Program implements Expression
{
    private Expression value;

    public ExpressionUnaryMinus(Expression value)
    {
        this.value = value;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("una-");
        writer.print(value);
    }
}
