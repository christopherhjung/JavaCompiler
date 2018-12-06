package com.christophejung.methodexpressions;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;
import com.christophejung.statements.Expression;

public class WhileStatement extends Program implements Statement
{
    private Expression condition;
    private Statement expression;

    public WhileStatement(Expression condition, Statement expression)
    {
        this.condition = condition;
        this.expression = expression;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("while(");
        writer.print(condition);
        writer.print(")");

        writer.print(expression);
    }
}
