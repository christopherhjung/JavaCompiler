package com.christophejung.container.methodexpressions;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;
import com.christophejung.container.statements.Expression;

public class IfStatement extends Program implements Statement
{
    private Expression condition;
    private Statement expression;

    public IfStatement(Expression condition, Statement expression)
    {
        this.condition = condition;
        this.expression = expression;
    }

    public Statement getExpression()
    {
        return expression;
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
