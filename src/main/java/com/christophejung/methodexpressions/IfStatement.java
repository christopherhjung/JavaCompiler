package com.christophejung.methodexpressions;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;
import com.christophejung.statements.Expression;

public class IfStatement extends Program implements Statement
{
    private Expression condition;
    private Statement expression;

    public IfStatement(Expression condition, Statement expression)
    {
        this.condition = condition;
        this.expression = expression;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("if(");
        writer.print(condition);
        writer.print(")");
        writer.print(expression);
    }
}
