package com.christophejung.methodexpressions;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;
import com.christophejung.statements.Expression;

public class Assign extends Program implements Expression, Statement
{
    private Expression varName;
    private Expression expression;

    public Assign(Expression varName, Expression expression)
    {
        this.varName = varName;
        this.expression = expression;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print(varName);
        writer.print("=");
        writer.print(expression);
    }
}
