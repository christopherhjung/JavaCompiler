package com.christophejung.container.methodexpressions;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;
import com.christophejung.container.statements.Expression;

public class AssignSub extends Program implements Expression, Statement
{
    private Expression name;
    private Expression expression;

    public AssignSub(Expression name, Expression expression)
    {
        this.name = name;
        this.expression = expression;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print(name);
        writer.print(" -= ");
        writer.print(expression);
    }
}
